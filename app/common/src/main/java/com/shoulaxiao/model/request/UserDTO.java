package com.shoulaxiao.model.request;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: shoulaxiao
 * @DateTime: 2021/3/5 23:19
 * @Description: TODO
 */
public class UserDTO implements Serializable {
    private static final long serialVersionUID = 8327622768926371631L;
    private Long id;

    /**
     *   微信昵称
     */
    private String nickAme;

    /**
     *   微信个人ID
     */
    private String wxId;

    /**
     *   性别，0-未知，1-男性，2-女性
     */
    private Integer gender;

    /**
     *   邮箱
     */
    private String email;

    /**
     *   头像地址
     */
    private String avatarUrl;

    /**
     *   国家
     */
    private String country;

    /**
     *   省份
     */
    private String province;

    /**
     *   城市
     */
    private String city;

    /**
     *   语言，en-英文，zh_CN-简体中文，zh_TW-繁体中文
     */
    private String language;

    /**
     *   手机号
     */
    private String telephone;

    /**
     *   身份证号
     */
    private String idCard;

    /**
     *   创建时间
     */
    private Date createTime;

    /**
     *   更新时间
     */
    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickAme() {
        return nickAme;
    }

    public void setNickAme(String nickAme) {
        this.nickAme = nickAme;
    }

    public String getWxId() {
        return wxId;
    }

    public void setWxId(String wxId) {
        this.wxId = wxId;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
