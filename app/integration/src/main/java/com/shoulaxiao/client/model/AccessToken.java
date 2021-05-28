package com.shoulaxiao.client.model;

import lombok.Data;

import java.util.Date;

/**
 * @author shoulaxiao
 * @version 1.0.0
 * @ClassName AccessToken.java
 * @Description
 * @createTime 2021年05月28日 14:59:00
 */
@Data
public class AccessToken {

    private String accessToken;

    private Date expireTime;
}
