package com.shoulaxiao.service;


import com.shoulaxiao.model.request.UserDTO;

/**
 * @Author: shoulaxiao
 * @DateTime: 2021/3/5 23:05
 * @Description: TODO 用户数据操作服务
 */
public interface UserService {

    /**
     * 插入用户
     * @param userDTO 用户信息
     * @return 保存的主键
     */
    Long saveUser(UserDTO userDTO);

}
