package com.example.micro.commerce;

import com.example.micro.commerce.model.response.SuccessFullResponseDto;
import com.example.micro.commerce.service.CommerceService;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.text.ParseException;
import java.util.Map;
import java.util.Objects;

import static com.example.micro.commerce.utils.CommerceConstants.*;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/v1")
public class CommerceController {

    // Use case services
    private final CommerceService commerceSvc;
    @GetMapping(value = "/get-product-info")
    public Mono<ResponseEntity<SuccessFullResponseDto>> getProductCommerceInfo(
            @RequestParam(value = PRODUCT_ID) int productId,
            @RequestParam(value = CHAIN_ID) int chainId,
            @RequestParam(value = APPLICATION_DATE)
            @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss") String applicationDate
    ) throws ParseException {
        Map<String, Object> entryData = Map.of(
                PRODUCT_ID, productId,
                CHAIN_ID, chainId,
                APPLICATION_DATE, applicationDate);

        SuccessFullResponseDto response = commerceSvc.getProductCommercePrice(entryData);

        return !Objects.isNull(response) ?
                Mono.just(ResponseEntity.ok(response)) :
                Mono.just(ResponseEntity.badRequest().build());
    }
}
