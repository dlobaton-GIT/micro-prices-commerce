package com.example.micro.commerce.service;

import com.example.micro.commerce.model.response.SuccessFullResponseDto;

import java.text.ParseException;
import java.util.Map;

public interface CommerceService {
    SuccessFullResponseDto getProductCommercePrice(Map<String, Object> entryData) throws ParseException;
}
