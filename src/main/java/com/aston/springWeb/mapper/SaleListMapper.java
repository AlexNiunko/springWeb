package com.aston.springWeb.mapper;

import com.aston.springWeb.dto.SaleDto;
import com.aston.springWeb.entity.Sale;
import org.mapstruct.Context;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring",uses = SaleMapper.class)
public interface SaleListMapper {
    List<SaleDto> mapSale(List<Sale>saleList,@Context CycleAvoidingMappingContext context);
    List<Sale>mapSaleDto(List<SaleDto>saleDtoList,@Context CycleAvoidingMappingContext context);

}
