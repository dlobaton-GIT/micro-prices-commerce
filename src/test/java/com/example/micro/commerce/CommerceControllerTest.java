package com.example.micro.commerce;

import com.example.micro.commerce.model.request.CommerceRequestDto;
import com.example.micro.commerce.model.response.SuccessFullResponseDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class CommerceControllerTest {

    @Autowired
    private WebTestClient webTestClient;


    @Test
    void test1() throws ParseException {

        CommerceRequestDto requestDto = CommerceRequestDto.builder()
                .applicationDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2020-06-14 10:00:00"))
                .productId(35455)
                .chainId(1)
                .build();
        webTestClient
                .post()
                .uri("/v1/get-product-info")
                .body(BodyInserters.fromValue(requestDto))
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus()
                .is2xxSuccessful()
                .expectBody(SuccessFullResponseDto.class)
                .value((res) -> {
                    assertEquals(1, res.getApplicableFee());
                    assertEquals(new BigDecimal(35.50).setScale(2, BigDecimal.ROUND_HALF_EVEN), res.getFinalPrice());
                });
    }
    @Test
    void test2() throws ParseException {

        CommerceRequestDto requestDto = CommerceRequestDto.builder()
                .applicationDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2020-06-14 16:00:00"))
                .productId(35455)
                .chainId(1)
                .build();
        webTestClient
                .post()
                .uri("/v1/get-product-info")
                .body(BodyInserters.fromValue(requestDto))
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus()
                .is2xxSuccessful()
                .expectBody(SuccessFullResponseDto.class)
                .value((res) -> {
                    assertEquals(2, res.getApplicableFee());
                    assertEquals(new BigDecimal(25.45).setScale(2, BigDecimal.ROUND_HALF_EVEN), res.getFinalPrice());
                });
    }
    @Test
    void test3() throws ParseException {

        CommerceRequestDto requestDto = CommerceRequestDto.builder()
                .applicationDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2020-06-14 21:00:00"))
                .productId(35455)
                .chainId(1)
                .build();
        webTestClient
                .post()
                .uri("/v1/get-product-info")
                .body(BodyInserters.fromValue(requestDto))
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus()
                .is2xxSuccessful()
                .expectBody(SuccessFullResponseDto.class)
                .value((res) -> {
                    assertEquals(1, res.getApplicableFee());
                    assertEquals(new BigDecimal(35.50).setScale(2, BigDecimal.ROUND_HALF_EVEN), res.getFinalPrice());
                });
    }
    @Test
    void test4() throws ParseException {

        CommerceRequestDto requestDto = CommerceRequestDto.builder()
                .applicationDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2020-06-15 10:00:00"))
                .productId(35455)
                .chainId(1)
                .build();
        webTestClient
                .post()
                .uri("/v1/get-product-info")
                .body(BodyInserters.fromValue(requestDto))
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus()
                .is2xxSuccessful()
                .expectBody(SuccessFullResponseDto.class)
                .value((res) -> {
                    assertEquals(3, res.getApplicableFee());
                    assertEquals(new BigDecimal(30.50).setScale(2, BigDecimal.ROUND_HALF_EVEN), res.getFinalPrice());
                });
    }
    @Test
    void test5() throws ParseException {

        CommerceRequestDto requestDto = CommerceRequestDto.builder()
                .applicationDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2020-06-16 21:00:00"))
                .productId(35455)
                .chainId(1)
                .build();
        webTestClient
                .post()
                .uri("/v1/get-product-info")
                .body(BodyInserters.fromValue(requestDto))
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus()
                .is2xxSuccessful()
                .expectBody(SuccessFullResponseDto.class)
                .value((res) -> {
                    assertEquals(4, res.getApplicableFee());
                    assertEquals(new BigDecimal(38.95).setScale(2, BigDecimal.ROUND_HALF_EVEN), res.getFinalPrice());
                });
    }
}
