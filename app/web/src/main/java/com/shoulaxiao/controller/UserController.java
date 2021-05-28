package com.shoulaxiao.controller;

import com.shoulaxiao.model.request.UserDTO;
import com.shoulaxiao.model.response.SingleResult;
import com.shoulaxiao.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/api/user")
public class UserController {


    @Resource
    private UserService userService;

    public SingleResult<Long> saveUserInfo(@RequestBody UserDTO userDTO){
        if (!validateUserInfo(userDTO)){
          return new SingleResult<>(null,false,StringUtils.EMPTY,"保存用户失败");
        }
        Long id=userService.saveUser(userDTO);
       return new SingleResult<>(id,true,StringUtils.EMPTY,StringUtils.EMPTY);
    }

    private boolean validateUserInfo(UserDTO userDTO) {
        return !StringUtils.isEmpty(userDTO.getWxId());
    }

}
