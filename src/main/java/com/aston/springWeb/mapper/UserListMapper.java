package com.aston.springWeb.mapper;

import com.aston.springWeb.dto.UserDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring",uses = UserMapper.class)
public interface UserListMapper {

}
