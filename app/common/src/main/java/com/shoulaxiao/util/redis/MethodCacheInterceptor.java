package com.shoulaxiao.util.redis;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.util.List;

/**
 * @Author shoulaxiao
 * @Date 2021/3/3 16:02
 * @Description TODO Redis缓存过滤器
 * @Version 1.0
 **/
public class MethodCacheInterceptor implements MethodInterceptor {

    private RedisClient redisClient;

    /**
     * 禁用缓存的类名列表
     */
    private List<String> targetNamesList;
    /**
     * 禁用缓存的方法列表
     */
    private List<String> methodNamesList;
    /**
     * 缓存默认的过期时间
     */
    private String defaultCacheExpireTime;

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        Object value = null;

        String targetName = methodInvocation.getThis().getClass().getName();
        String methodName = methodInvocation.getMethod().getName();
        if (!isAddCache(targetName, methodName)) {
            // 跳过缓存返回结果
            return methodInvocation.proceed();
        }
        Object[] arguments = methodInvocation.getArguments();
        String key = getCacheKey(targetName, methodName, arguments);
        try {
            // 判断是否有缓存
            if (redisClient.exists(key)) {
                return redisClient.get(key);
            }
            // 写入缓存
            value = methodInvocation.proceed();
            if (value != null) {
                final String tkey = key;
                final Object tvalue = value;
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        redisClient.set(tkey, tvalue, Long.parseLong(defaultCacheExpireTime));
                    }
                }).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (value == null) {
                return methodInvocation.proceed();
            }
        }
        return value;
    }

    private boolean isAddCache(String targetName, String methodName) {
        boolean flag = true;
        if (targetNamesList.contains(targetName)
                || methodNamesList.contains(methodName) || targetName.contains("$$EnhancerBySpringCGLIB$$")) {
            flag = false;
        }
        return flag;
    }

    /**
     * 创建缓存key
     *
     * @param targetName
     * @param methodName
     * @param arguments
     */
    private String getCacheKey(String targetName, String methodName,
                               Object[] arguments) {
        StringBuffer sbu = new StringBuffer();
        sbu.append(targetName).append("_").append(methodName);
        if ((arguments != null) && (arguments.length != 0)) {
            for (int i = 0; i < arguments.length; i++) {
                sbu.append("_").append(arguments[i]);
            }
        }
        return sbu.toString();
    }

    public void setRedisClient(RedisClient redisClient) {
        this.redisClient = redisClient;
    }

    public void setTargetNamesList(List<String> targetNamesList) {
        this.targetNamesList = targetNamesList;
    }

    public void setMethodNamesList(List<String> methodNamesList) {
        this.methodNamesList = methodNamesList;
    }

    public void setDefaultCacheExpireTime(String defaultCacheExpireTime) {
        this.defaultCacheExpireTime = defaultCacheExpireTime;
    }
}
