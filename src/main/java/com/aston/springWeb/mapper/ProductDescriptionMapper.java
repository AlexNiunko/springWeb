package com.aston.springWeb.mapper;

import com.aston.springWeb.dto.ProductDescriptionDto;
import com.aston.springWeb.entity.ProductDescription;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductDescriptionMapper {
    ProductDescription map(ProductDescriptionDto productDescriptionDto);
    ProductDescriptionDto map(ProductDescription productDescription);

}
