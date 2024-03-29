package com.shoulaxiao.constant;

/**
 * @Author shoulaxiao
 * @Date 2021/3/3 11:51
 * @Description TODO
 * @Version 1.0
 **/
public class WeChatConstant {

    /**获取accesstoken链接**/
    public static final String ACCESS_TOKEN_URL="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=${APPID}&secret=${APPSECRE}";
    /**获取用户信息接口**/
    public static final String GET_USER_INFO_URL = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
    /**auth.code2Session URL链接*/
    public static String CODE2_SESSION_URL="https://api.weixin.qq.com/sns/jscode2session?appid=${APPID}&secret=${SECRET}&js_code=${JSCODE}&grant_type=authorization_code";
    /** 小程序的APPID*/
    public static final String APPID="wx73662739b03f0322";
    /**小程序 appSecret*/
    public static final String  APP_SECRET="9941941f6ad0c8fa45a1f104646ab55e";
    /**登录请求前缀*/
    public static final String LOGIN_REQ_HEADER="WX-Access-Token";
    /**用户登录session过期时间*/
    public static final long LOGIN_REQ_HEADER_EXPIRE_TIME = 3 * 24 * 60 * 60;



}
