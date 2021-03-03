package com.shoulaxiao.constant;

/**
 * @Author shoulaxiao
 * @Date 2021/3/3 11:51
 * @Description TODO
 * @Version 1.0
 **/
public class WeChatConstant {

    /**auth.code2Session URL链接*/
    public static String CODE2_SESSION_URL="https://api.weixin.qq.com/sns/jscode2session?appid=${APPID}&secret=${SECRET}&js_code=${JSCODE}&grant_type=authorization_code";
    /** 小程序的APPID*/
    public static final String APPID="wx73662739b03f0322";
    /**小程序 appSecret*/
    public static final String  APP_SECRET="9941941f6ad0c8fa45a1f104646ab55e";
    /**登录请求前缀*/
    public static final String LOGIN_REQ_HEADER="WX-Access-Token";


}
