package com.example.micro.commerce.model.request;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

@Value
@Builder
@Jacksonized
@JsonAutoDetect
public class CommerceRequestDto {
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    Date applicationDate;
    int productId;
    int chainId;
}
