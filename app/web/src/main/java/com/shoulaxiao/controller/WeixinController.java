package com.shoulaxiao.controller;

import com.shoulaxiao.client.AbstractHttpRequest;
import com.shoulaxiao.client.method.HttpRequestGetHandler;
import com.shoulaxiao.constant.WeChatConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(HttpServletRequest request, HttpServletResponse response) {
        try {
            String code = request.getParameter("code");
            AbstractHttpRequest httpHandler=new HttpRequestGetHandler();
            String url = WeChatConstant.CODE2_SESSION_URL
                    .replace("${APPID}",WeChatConstant.APPID)
                    .replace("${SECRET}",WeChatConstant.APP_SECRET)
                    .replace("${JSCODE}",code);
            String res=httpHandler.doSend(url,"");
        } catch (Exception ex) {
            logger.error("登录微信异常:{}", ex.getMessage(), ex);
        }
        return null;
    }
}
