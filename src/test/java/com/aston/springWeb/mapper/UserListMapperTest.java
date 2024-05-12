package com.aston.springWeb.mapper;

import com.aston.springWeb.config.SpringConfig;
import com.aston.springWeb.dto.UserDto;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringJUnitWebConfig
@ContextConfiguration(classes = SpringConfig.class)
class UserListMapperTest {
    @Autowired
    private UserMapper mapper;

    @Test
    void toEntityList() {
        mapper.getClass();

    }

    @Test
    void toDtoList() {

    }
}