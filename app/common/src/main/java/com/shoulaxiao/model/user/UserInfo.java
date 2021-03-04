package com.shoulaxiao.model.user;

/**
 * @Author shoulaxiao
 * @Date 2021/3/4 11:21
 * @Description TODO
 * @Version 1.0
 **/
public class UserInfo {
    /**
     * 用户唯一标识
     */
    private String openId;

    /**会话密钥*/
    private String sessionKey;

    /**
     * 返回值
     */
    private String unionId;

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }
}
