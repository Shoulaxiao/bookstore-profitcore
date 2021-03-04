package com.shoulaxiao.enums;

/**
 * @Author shoulaxiao
 * @Date 2021/3/4 10:57
 * @Description TODO
 * @Version 1.0
 **/
public enum WeChatResEnum {


    SYSTEM_BUSY(-1, "系统繁忙，此时请开发者稍候再试"),
    SUCCESS(0, "请求成功"),
    CODE_INVALID(40029, "code无效"),
    FREQUENCY_LIMIT(45011, "频率限制，每个用户每分钟100次");

    private Integer code;

    private String desc;

    WeChatResEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static WeChatResEnum getEnumByCode(Integer code){
        if (null == code){
            return null;
        }

        for(WeChatResEnum statusEnum : values()){
            if(statusEnum.getCode().equals(code)){
                return statusEnum;
            }
        }
        return null;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
