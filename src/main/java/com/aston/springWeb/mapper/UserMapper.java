package com.aston.springWeb.mapper;

import com.aston.springWeb.dto.UserDto;
import com.aston.springWeb.entity.User;
import org.mapstruct.Context;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",uses = {ProductMapper.class, SaleListMapper.class})
public interface UserMapper {
    User map(UserDto userDto,@Context CycleAvoidingMappingContext context);
    UserDto map(User user,@Context CycleAvoidingMappingContext context);

}
