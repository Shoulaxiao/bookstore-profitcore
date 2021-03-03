package com.shoulaxiao.client;

import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * @Author shoulaxiao
 * @Date 2021/3/3 12:07
 * @Description TODO
 * @Version 1.0
 **/
public abstract class AbstractHttpRequest{


    /**
     * 发送请求
     * @param url 请求url
     * @param request 请求参数
     * @return 请求结果
     */
    public abstract String doSend(String url, String request);

}
