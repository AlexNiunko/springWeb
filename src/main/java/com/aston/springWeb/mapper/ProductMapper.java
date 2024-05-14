package com.aston.springWeb.mapper;

import com.aston.springWeb.dto.ProductDto;
import com.aston.springWeb.entity.Product;
import org.mapstruct.Context;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",uses = {ProductDescriptionMapper.class, SaleListMapper.class, UserListMapper.class})
public interface ProductMapper {
    Product map(ProductDto productDto, @Context CycleAvoidingMappingContext context);
    ProductDto map(Product product,@Context CycleAvoidingMappingContext context);
}
