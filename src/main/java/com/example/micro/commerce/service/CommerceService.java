package com.example.micro.commerce.service;

import com.example.micro.commerce.model.request.CommerceRequestDto;
import com.example.micro.commerce.model.response.SuccessFullResponseDto;

public interface CommerceService {
    SuccessFullResponseDto getProductCommercePrice(CommerceRequestDto requestDto);
}
