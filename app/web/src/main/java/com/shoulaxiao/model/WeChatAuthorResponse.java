package com.shoulaxiao.model;

/**
 * @Author shoulaxiao
 * @Date 2021/3/3 16:28
 * @Description TODO
 * @Version 1.0
 **/
public class WeChatAuthorResponse {
    /**
     * 用户唯一标识
     */
    private String openid;

    /**
     * 会话密钥
     */
    private String sessionKey;


    /**
     * 用户在开放平台的唯一标识符，在满足 UnionID 下发条件的情况下会返回
     */
    private String unionId;


    /**
     * 错误码
     */
    private int errCode;

    /**
     * 错误信息
     */
    private String errMsg;

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
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

    public int getErrCode() {
        return errCode;
    }

    public void setErrCode(int errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }
}
