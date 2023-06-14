package com.example.micro.commerce.mapper;

import com.example.micro.commerce.model.response.SuccessFullResponseDto;
import com.example.micro.h2db.model.entity.Price;
import org.mapstruct.Mapper;

@Mapper
public interface CommerceMapper {
    SuccessFullResponseDto toSuccessFullResponseDto(Price price);
}
