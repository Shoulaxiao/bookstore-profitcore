package com.shoulaxiao.controller;

import com.alibaba.druid.util.StringUtils;
import com.shoulaxiao.client.AbstractHttpRequest;
import com.shoulaxiao.client.method.HttpRequestGetHandler;
import com.shoulaxiao.constant.Symbol;
import com.shoulaxiao.constant.WeChatConstant;
import com.shoulaxiao.controller.utils.WeiXinUtil;
import com.shoulaxiao.model.WeChatAuthorResponse;
import com.shoulaxiao.util.redis.RedisClient;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author shoulaxiao
 * @Date 2021/3/3 11:24
 * @Description TODO 微信登录控制器
 * @Version 1.0
 **/
@Controller
@RequestMapping("api/wx")
public class WeixinController {

    private static final Logger logger = LoggerFactory.getLogger(WeixinController.class);

    @Resource
    private RedisClient redisClient;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(HttpServletRequest request, HttpServletResponse response) {
        try {
            String code = request.getParameter("code");
            AbstractHttpRequest httpHandler = new HttpRequestGetHandler();
            String url = WeChatConstant.CODE2_SESSION_URL
                    .replace("${APPID}", WeChatConstant.APPID)
                    .replace("${SECRET}", WeChatConstant.APP_SECRET)
                    .replace("${JSCODE}", code);
            String token = fetchToken(request);
            if (token == null) {
                String res = httpHandler.doSend(url, "");
                WeChatAuthorResponse weChatAuthorResponse = parseResult(res);
                //获取用户详情


                //保存Redis
                redisClient.set(WeChatConstant.LOGIN_REQ_HEADER + weChatAuthorResponse.getOpenid() + Symbol.UNDER_LINE + weChatAuthorResponse.getSessionKey(), "");
            }
        } catch (Exception ex) {
            logger.error("登录微信异常:{}", ex.getMessage(), ex);
        }
        return null;
    }

    private WeChatAuthorResponse parseResult(String res) {
        WeChatAuthorResponse weChatAuthorResponse = new WeChatAuthorResponse();
        JSONObject jsonObject = JSONObject.fromObject(res);
        if (jsonObject != null) {
            if (0 != jsonObject.getInt("errcode")) {
                logger.error("获取auth.code2Session失败,errcode={},errmsg={}", jsonObject.getInt("errcode"), jsonObject.getString("errmsg"));
                weChatAuthorResponse.setOpenid(jsonObject.getString("openid"));
                weChatAuthorResponse.setSessionKey(jsonObject.getString("session_key"));
                weChatAuthorResponse.setUnionId(jsonObject.getString("unionid"));
                weChatAuthorResponse.setErrCode(jsonObject.getInt("errcode"));
                weChatAuthorResponse.setErrMsg(jsonObject.getString("errmsg"));
            }
        }
        return weChatAuthorResponse;
    }

    /**
     * 获取token
     *
     * @param request 请求request
     * @return token
     */
    private String fetchToken(HttpServletRequest request) {
        String token = request.getHeader(WeChatConstant.LOGIN_REQ_HEADER);
        if (StringUtils.isEmpty(token)) {
            Cookie cookie = WeiXinUtil.getCookies(request, WeChatConstant.LOGIN_REQ_HEADER);
            if (cookie != null) {
                token = cookie.getValue();
            }
        }
        return token;
    }
}
