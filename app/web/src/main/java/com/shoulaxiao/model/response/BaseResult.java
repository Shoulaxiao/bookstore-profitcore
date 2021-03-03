package com.shoulaxiao.model.response;

import java.io.Serializable;

/**
 * @Author shoulaxiao
 * @Date 2021/3/3 18:57
 * @Description TODO
 * @Version 1.0
 **/
public class BaseResult implements Serializable {
    private static final long serialVersionUID = 7136930791414986514L;

    /**
     * 服务是否执行成功
     */
    private boolean success = false;

    /**
     * 错误码
     */
    private String errorCode;


    /**
     * 错误信息
     */
    private String errorMessage;

    /**
     * 默认构造函数
     */
    public BaseResult() {
        super();
        this.success = true;
    }

    /**
     * 带参构造函数
     *
     * @param errorCode    错误码
     * @param errorMessage 错误信息
     */
    public BaseResult(String errorCode, String errorMessage) {
        this(false, errorCode, errorMessage);
    }


    public BaseResult(boolean success, String errorCode, String errorMessage) {
        super();
        this.success = success;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(success).append(",");
        sb.append(errorCode).append(",");
        sb.append(errorMessage).append(",");
        return sb.toString();
    }
}
