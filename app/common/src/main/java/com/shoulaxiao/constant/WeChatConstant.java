package com.shoulaxiao.constant;

/**
 * @Author shoulaxiao
 * @Date 2021/3/3 11:51
 * @Description TODO
 * @Version 1.0
 **/
public class WeChatConstant {

    /**
     * auth.code2Session URL链接
     */
    public static String CODE2_SESSION_URL="https://api.weixin.qq.com/sns/jscode2session?appid=${APPID}&secret=${SECRET}&js_code=${JSCODE}&grant_type=authorization_code";


    /**
     * 小程序的APPID
     */
    public static final String APPID="";


    /**
     * 小程序 appSecret
     */
    public static final String  APP_SECRET="";


}
