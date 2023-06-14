package com.example.micro.commerce.mapper.impl;

import com.example.micro.commerce.mapper.CommerceMapper;
import com.example.micro.commerce.model.response.SuccessFullResponseDto;
import com.example.micro.h2db.model.entity.Price;
import org.springframework.stereotype.Service;

@Service
public class CommerceMapperImpl implements CommerceMapper {
    @Override
    public SuccessFullResponseDto toSuccessFullResponseDto(Price price) {
        return SuccessFullResponseDto.builder()
                .applicableFee(price.getPrice_list())
                .startDate(price.getStart_date())
                .endDate(price.getEnd_date())
                .chainId(price.getBrand_id())
                .finalPrice(price.getPrice())
                .productId(price.getProduct_id())
                .build();
    }
}
