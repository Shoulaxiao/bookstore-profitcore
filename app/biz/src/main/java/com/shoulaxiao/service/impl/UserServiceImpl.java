package com.shoulaxiao.service.impl;

import com.shoulaxiao.biz.mapper.UserMapperConverter;
import com.shoulaxiao.constant.WeChatConstant;
import com.shoulaxiao.dao.UserDOMapper;
import com.shoulaxiao.entity.UserDO;
import com.shoulaxiao.entity.UserDOExample;
import com.shoulaxiao.model.request.UserDTO;
import com.shoulaxiao.service.UserService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Author: shoulaxiao
 * @DateTime: 2021/3/5 23:45
 * @Description: TODO
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDOMapper userDOMapper;

    @Autowired
    private UserMapperConverter userMapperConverter;

    @Override
    public Long saveUser(UserDTO userDTO) {
        //1.查询数据库中是否存在该用户的信息
        UserDOExample userDOExample=new UserDOExample();
        UserDOExample.Criteria criteria = userDOExample.createCriteria();
        criteria.andWxIdEqualTo(userDTO.getWxId());

        List<UserDO> userDOS = userDOMapper.selectByExample(userDOExample);
        //不存在
        if (CollectionUtils.isEmpty(userDOS)){
            Date now= new Date();
            userDTO.setCreateTime(now);
            userDTO.setUpdateTime(now);
            return (long) userDOMapper.insert(userMapperConverter.dto2do(userDTO));
        }
        return userDOS.get(0).getId();
    }

    @Override
    public boolean getUserInfoAndSave(String openId) {
        String url = WeChatConstant.GET_USER_INFO_URL;
        return false;
    }
}
