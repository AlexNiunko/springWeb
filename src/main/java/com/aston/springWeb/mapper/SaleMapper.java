package com.aston.springWeb.mapper;

import com.aston.springWeb.dto.SaleDto;
import com.aston.springWeb.entity.Sale;
import org.mapstruct.Context;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",uses = {ProductMapper.class, UserMapper.class})
public interface SaleMapper {
    Sale map(SaleDto saleDto,@Context CycleAvoidingMappingContext context);
    SaleDto map(Sale sale,@Context CycleAvoidingMappingContext context);
}
