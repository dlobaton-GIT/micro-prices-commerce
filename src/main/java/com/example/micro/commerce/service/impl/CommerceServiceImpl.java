package com.example.micro.commerce.service.impl;

import com.example.micro.commerce.mapper.CommerceMapper;
import com.example.micro.commerce.model.request.CommerceRequestDto;
import com.example.micro.commerce.model.response.SuccessFullResponseDto;
import com.example.micro.commerce.service.CommerceService;
import com.example.micro.h2db.H2Repository;
import com.example.micro.h2db.model.entity.Price;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@Builder
public class CommerceServiceImpl  implements CommerceService {

    // Repositories
    private final H2Repository h2Repository;

    // Mapper
    private final CommerceMapper commerceMapper;

    @Override
    public SuccessFullResponseDto getProductCommercePrice(CommerceRequestDto requestDto) {
        log.info("Starting service -- GetProductCommercePrice");

        final Price dbResponse = h2Repository.findByFilters(requestDto.getChainId(), requestDto.getProductId(), requestDto.getApplicationDate());

        log.info("End service -- GetProductCommercePrice");
        return commerceMapper.toSuccessFullResponseDto(dbResponse);
    }
}
