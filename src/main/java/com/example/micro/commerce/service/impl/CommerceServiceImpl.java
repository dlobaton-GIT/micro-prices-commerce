package com.example.micro.commerce.service.impl;

import com.example.micro.commerce.model.response.SuccessFullResponseDto;
import com.example.micro.commerce.service.CommerceService;
import com.example.micro.commerce.utils.CommerceUtils;
import com.example.micro.commerce.utils.mapper.CommerceMapper;
import com.example.micro.h2db.H2Repository;
import com.example.micro.h2db.model.entity.Price;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;

import static com.example.micro.commerce.utils.CommerceConstants.*;

@Slf4j
@Service
@Builder
public class CommerceServiceImpl  implements CommerceService {

    // Repositories
    private final H2Repository h2Repository;

    // Mapper
    private final CommerceMapper commerceMapper;

    @Override
    public SuccessFullResponseDto getProductCommercePrice(Map<String, Object> entryData) throws ParseException {
        log.info("Starting service -- GetProductCommercePrice");

        // Validate input Data
        validateInputData(entryData);

        // Call to DB
        final Price dbResponse = h2Repository.findByFilters(
                (int) entryData.get(CHAIN_ID),
                (int) entryData.get(PRODUCT_ID),
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse((String) entryData.get(APPLICATION_DATE)));

        // Return result
        log.info("End service -- GetProductCommercePrice");
        return commerceMapper.toSuccessFullResponseDto(dbResponse);
    }

    private void validateInputData(Map<String, Object> entryData) {
        String productId = String.valueOf(entryData.get(PRODUCT_ID));
        CommerceUtils.assertInteger(PRODUCT_ID, productId);

        String chainId = String.valueOf(entryData.get(CHAIN_ID));
        CommerceUtils.assertInteger(CHAIN_ID, chainId);

        String applicationDate = ((String) entryData.get(APPLICATION_DATE));
        CommerceUtils.assertDateFormat(APPLICATION_DATE, applicationDate);
    }
}
