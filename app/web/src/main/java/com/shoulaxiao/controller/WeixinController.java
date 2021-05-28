package com.shoulaxiao.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.shoulaxiao.client.AbstractHttpRequest;
import com.shoulaxiao.client.method.HttpRequestGetHandler;
import com.shoulaxiao.constant.WeChatConstant;
import com.shoulaxiao.controller.utils.WeiXinUtil;
import com.shoulaxiao.enums.WeChatResEnum;
import com.shoulaxiao.model.WeChatAuthorResponse;
import com.shoulaxiao.model.response.SingleResult;
import com.shoulaxiao.model.user.UserInfo;
import com.shoulaxiao.service.UserService;
import com.shoulaxiao.util.redis.RedisClient;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

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

    @Resource
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public SingleResult login(HttpServletRequest request, HttpServletResponse response) {
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
                //解析结果
                WeChatAuthorResponse weChatAuthorResponse = parseResult(res);
                if (weChatAuthorResponse.getErrCode() == WeChatResEnum.SUCCESS.getCode()) {
                    String newToken = UUID.randomUUID().toString();
                    UserInfo userInfo = new UserInfo();
                    BeanUtils.copyProperties(response, userInfo);
                    //保存用户的信息
                    redisClient.setValue(WeChatConstant.LOGIN_REQ_HEADER + newToken, JSON.toJSONString(userInfo), WeChatConstant.LOGIN_REQ_HEADER_EXPIRE_TIME);
                    //获取用户详细信息，存储到数据库
                    userService.getUserInfoAndSave(userInfo.getOpenId());

                    Cookie cookie = new Cookie(WeChatConstant.LOGIN_REQ_HEADER, newToken);
                    cookie.setMaxAge(24 * 60 * 60);
                    cookie.setPath("/");
                    response.addCookie(cookie);
                }else {
                    logger.info("登录失败");
                    Cookie cookie = new Cookie(WeChatConstant.LOGIN_REQ_HEADER, "");
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                    return new SingleResult(null, false, String.valueOf(weChatAuthorResponse.getErrCode()), WeChatResEnum.getEnumByCode(weChatAuthorResponse.getErrCode()).getDesc());
                }
            }
        } catch (Exception ex) {
            logger.info("登录失败");
            Cookie cookie = new Cookie(WeChatConstant.LOGIN_REQ_HEADER, "");
            cookie.setMaxAge(0);
            response.addCookie(cookie);
            logger.error("登录微信异常:{}", ex.getMessage(), ex);
            return new SingleResult(null, false, StringUtils.EMPTY, ex.getMessage());
        }
        return new SingleResult(null, true, StringUtils.EMPTY, StringUtils.EMPTY);
    }

    private WeChatAuthorResponse parseResult(String res) {
        WeChatAuthorResponse weChatAuthorResponse = new WeChatAuthorResponse();
        JSONObject jsonObject = JSONObject.parseObject(res);
        if (jsonObject != null) {
            if (0 != jsonObject.getInteger("errcode")) {
                logger.error("获取auth.code2Session失败,errcode={},errmsg={}", jsonObject.getInteger("errcode"), jsonObject.getString("errmsg"));
                weChatAuthorResponse.setOpenid(jsonObject.getString("openid"));
                weChatAuthorResponse.setSessionKey(jsonObject.getString("session_key"));
                weChatAuthorResponse.setUnionId(jsonObject.getString("unionid"));
                weChatAuthorResponse.setErrCode(jsonObject.getInteger("errcode"));
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
