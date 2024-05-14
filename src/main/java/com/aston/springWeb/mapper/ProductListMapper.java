package com.aston.springWeb.mapper;

import com.aston.springWeb.dto.ProductDto;
import com.aston.springWeb.entity.Product;
import org.mapstruct.Context;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring",uses = ProductMapper.class)
public interface ProductListMapper {
    List<Product>mapList(List<ProductDto> productDtoList,@Context CycleAvoidingMappingContext context);
    List<ProductDto>mapListDto(List<Product>productList,@Context CycleAvoidingMappingContext context);
}
