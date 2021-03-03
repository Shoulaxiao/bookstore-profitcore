package com.shoulaxiao.client.method;

import com.shoulaxiao.client.AbstractHttpRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author shoulaxiao
 * @Date 2021/3/3 12:52
 * @Description TODO
 * @Version 1.0
 **/
public class HttpRequestGetHandler extends AbstractHttpRequest {

    @Resource
    private RestTemplate restTemplate;

    private final static Logger logger = LoggerFactory.getLogger(HttpRequestGetHandler.class);

    @Override
    public String doSend(String url, String request) {
        try {
            return restTemplate.getForObject(url, String.class);
        } catch (Exception e) {
            logger.error("调用异常，{}", e.getMessage(), e);
        }
        return null;
    }
}
