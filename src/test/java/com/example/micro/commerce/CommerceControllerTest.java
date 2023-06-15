package com.example.micro.commerce;

import com.example.micro.commerce.model.response.SuccessFullResponseDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;

import static com.example.micro.commerce.utils.CommerceConstants.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class CommerceControllerTest {

    @Autowired
    private WebTestClient webTestClient;


    @Test
    void test1() throws ParseException {
        webTestClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path("/v1/get-product-info")
                        .queryParam(PRODUCT_ID, 35455)
                        .queryParam(CHAIN_ID, 1)
                        .queryParam(APPLICATION_DATE, "2020-06-14 10:00:00")
                        .build())
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus()
                .is2xxSuccessful()
                .expectBody(SuccessFullResponseDto.class)
                .value((res) -> {
                    assertEquals(1, res.getApplicableFee());
                    assertEquals(new BigDecimal("35.50").setScale(2, RoundingMode.HALF_EVEN), res.getFinalPrice());
                });
    }
    @Test
    void test2() throws ParseException {
        webTestClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path("/v1/get-product-info")
                        .queryParam(PRODUCT_ID, 35455)
                        .queryParam(CHAIN_ID, 1)
                        .queryParam(APPLICATION_DATE, "2020-06-14 16:00:00")
                        .build())
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus()
                .is2xxSuccessful()
                .expectBody(SuccessFullResponseDto.class)
                .value((res) -> {
                    assertEquals(2, res.getApplicableFee());
                    assertEquals(new BigDecimal("25.45").setScale(2, RoundingMode.HALF_EVEN), res.getFinalPrice());
                });
    }
    @Test
    void test3() throws ParseException {        webTestClient
            .get()
            .uri(uriBuilder -> uriBuilder
                    .path("/v1/get-product-info")
                    .queryParam(PRODUCT_ID, 35455)
                    .queryParam(CHAIN_ID, 1)
                    .queryParam(APPLICATION_DATE, "2020-06-14 21:00:00")
                    .build())
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus()
            .is2xxSuccessful()
            .expectBody(SuccessFullResponseDto.class)
            .value((res) -> {
                assertEquals(1, res.getApplicableFee());
                assertEquals(new BigDecimal("35.50").setScale(2, RoundingMode.HALF_EVEN), res.getFinalPrice());
            });
    }
    @Test
    void test4() throws ParseException {
        webTestClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path("/v1/get-product-info")
                        .queryParam(PRODUCT_ID, 35455)
                        .queryParam(CHAIN_ID, 1)
                        .queryParam(APPLICATION_DATE, "2020-06-15 10:00:00")
                        .build())
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus()
                .is2xxSuccessful()
                .expectBody(SuccessFullResponseDto.class)
                .value((res) -> {
                    assertEquals(3, res.getApplicableFee());
                    assertEquals(new BigDecimal("30.50").setScale(2, RoundingMode.HALF_EVEN), res.getFinalPrice());
                });
    }
    @Test
    void test5() throws ParseException {
        webTestClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path("/v1/get-product-info")
                        .queryParam(PRODUCT_ID, 35455)
                        .queryParam(CHAIN_ID, 1)
                        .queryParam(APPLICATION_DATE, "2020-06-16 21:00:00")
                        .build())
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus()
                .is2xxSuccessful()
                .expectBody(SuccessFullResponseDto.class)
                .value((res) -> {
                    assertEquals(4, res.getApplicableFee());
                    assertEquals(new BigDecimal("38.95").setScale(2, RoundingMode.HALF_EVEN), res.getFinalPrice());
                });
    }
}
