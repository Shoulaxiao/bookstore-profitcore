package com.shoulaxiao.client;

/**
 * @Author shoulaxiao
 * @Date 2021/3/3 12:07
 * @Description TODO
 * @Version 1.0
 **/
public abstract class AbstractHttpRequest {


    /**
     * 发送请求
     *
     * @param url     请求url
     * @param request 请求参数
     * @return 请求结果
     */
    public abstract String doSend(String url, String request);

}
