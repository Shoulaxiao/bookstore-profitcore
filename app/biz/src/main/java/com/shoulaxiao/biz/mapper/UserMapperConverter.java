package com.shoulaxiao.biz.mapper;

import com.shoulaxiao.entity.UserDO;
import com.shoulaxiao.model.request.UserDTO;
import org.mapstruct.Mapper;

/**
 * @Author: shoulaxiao
 * @DateTime: 2021/3/5 23:10
 * @Description: TODO
 */
@Mapper(componentModel = "spring")
public interface UserMapperConverter {

    UserDO dto2do(UserDTO userDTO);

}
