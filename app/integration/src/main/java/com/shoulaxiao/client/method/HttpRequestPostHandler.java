package com.shoulaxiao.client.method;

import com.google.common.collect.Maps;
import com.shoulaxiao.client.AbstractHttpRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * @Author shoulaxiao
 * @Date 2021/3/3 12:44
 * @Description TODO
 * @Version 1.0
 **/
public class HttpRequestPostHandler extends AbstractHttpRequest {

    @Autowired
    private RestTemplate restTemplate;

    private final static Logger logger = LoggerFactory.getLogger(HttpRequestPostHandler.class);

    @Override
    public String doSend(String url, String request) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        Map<String, Object> map = Maps.newHashMap();

        HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(map, headers);
        logger.info("开始调用，请求url={}，的请求参数request={}", url, requestEntity);
        try {
            String response = restTemplate.postForObject(url, requestEntity, String.class);
            logger.info("调用结果返回res=：{}", response);
            return response;
        } catch (Exception ex) {
            logger.error("调用异常{}", ex.getMessage(), ex);
        }
        return null;
    }
}

