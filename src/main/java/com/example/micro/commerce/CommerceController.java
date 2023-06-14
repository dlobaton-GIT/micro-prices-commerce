package com.example.micro.commerce;

import com.example.micro.commerce.model.request.CommerceRequestDto;
import com.example.micro.commerce.model.response.SuccessFullResponseDto;
import com.example.micro.commerce.service.CommerceService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/v1")
public class CommerceController {

    // Use case services
    private final CommerceService commerceSvc;
    @PostMapping (value = "/get-product-info")
    public Mono<ResponseEntity<SuccessFullResponseDto>> getProductCommerceInfo(
            @RequestBody final CommerceRequestDto requestDto
    ){
        SuccessFullResponseDto response = commerceSvc.getProductCommercePrice(requestDto);

        return !Objects.isNull(response) ?
                Mono.just(ResponseEntity.ok(response)) :
                Mono.just(ResponseEntity.badRequest().build());
    }
}
