package com.shoulaxiao.client.cache;

import com.shoulaxiao.client.WechatClient;
import com.shoulaxiao.client.model.AccessToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author shoulaxiao
 * @version 1.0.0
 * @ClassName AccessTokenSingleton.java
 * @Description
 * @createTime 2021年05月28日 14:57:00
 */
@Component
public class AccessTokenSingleton {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private WechatClient wechatClient;

    /**
     * key -appid,value-token
     */
    private Map<String, AccessToken> accessTokenMap = new ConcurrentHashMap<>();

    private static volatile AccessTokenSingleton singleton = null;

    private AccessTokenSingleton() {
        singleton = this;
        singleton.wechatClient = this.wechatClient;
    }

    public static AccessTokenSingleton getSingleton() {
        if (singleton == null) {
            synchronized (AccessTokenSingleton.class) {
                if (singleton == null) {
                    singleton = new AccessTokenSingleton();
                }
            }
        }
        return singleton;
    }
}
