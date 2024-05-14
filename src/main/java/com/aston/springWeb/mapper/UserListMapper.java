package com.aston.springWeb.mapper;

import com.aston.springWeb.dto.UserDto;
import com.aston.springWeb.entity.User;
import org.mapstruct.Context;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring",uses = UserMapper.class)
public interface UserListMapper {
    List<User> mapUserDtoList(List<UserDto>userDtoList,@Context CycleAvoidingMappingContext context);
    List<UserDto>mapUserList(List<User>userList,@Context CycleAvoidingMappingContext context);

}
