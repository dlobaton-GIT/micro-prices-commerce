package com.example.micro.commerce.model.response;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.math.BigDecimal;
import java.util.Date;

@Value
@Builder
@Jacksonized
@JsonAutoDetect
public class SuccessFullResponseDto {
    int productId;
    int chainId;
    int applicableFee;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    Date startDate;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    Date endDate;
    BigDecimal finalPrice;

}
