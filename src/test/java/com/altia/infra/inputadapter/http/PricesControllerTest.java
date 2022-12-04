package com.altia.infra.inputadapter.http;

import com.altia.objectmother.PriceRequestMother;
import com.altia.objectmother.PriceResponseMother;
import com.altia.infra.inputport.PriceRequest;
import com.altia.infra.inputport.PriceServicePort;
import com.altia.infra.outputadapter.h2repository.PriceResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


@ExtendWith(MockitoExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@AutoConfigureMockMvc
  class PricesControllerTest {

  @Autowired
  private PriceServicePort priceServicePort;
  private MockMvc mockMvc;
  private ObjectMapper mapper;

  @BeforeEach
  void before() {
    mockMvc = MockMvcBuilders.standaloneSetup(new PriceController(priceServicePort)).build();
    mapper = new ObjectMapper();
    mapper.registerModule(new JavaTimeModule());
  }


  @ParameterizedTest
  @MethodSource("paramSource")
  void should_return_price(final PriceRequest priceRequest, final PriceResponse priceResponse) throws Exception {
    //given
    /* PriceRequest PriceResponse by ParameterizedTest */

    //when
    RequestBuilder requestBuilder = MockMvcRequestBuilders
        .get("/api/v1/prices")
        .contentType(MediaType.APPLICATION_JSON_VALUE)
        .accept(MediaType.APPLICATION_JSON_VALUE)
        .content(mapper.writeValueAsString(priceRequest));

    //then
    this.mockMvc.perform(requestBuilder)
        .andDo(MockMvcResultHandlers.print())
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$.brandId").value(priceResponse.getBrandId()))
        .andExpect(MockMvcResultMatchers.jsonPath("$.priceList").value(priceResponse.getPriceList()))
        .andExpect(MockMvcResultMatchers.jsonPath("$.productId").value(priceResponse.getProductId()))
        .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(priceResponse.getPrice()));
  }

  private static Stream<Arguments> paramSource() {
    return Stream.of(
        Arguments.of(PriceRequestMother.firstPriceRequest(), PriceResponseMother.firstPriceResponse()),
        Arguments.of(PriceRequestMother.secondPriceRequest(), PriceResponseMother.secondPriceResponse()),
        Arguments.of(PriceRequestMother.threePriceRequest(), PriceResponseMother.threePriceResponse()),
        Arguments.of(PriceRequestMother.fourPriceRequest(), PriceResponseMother.fourPriceResponse()),
        Arguments.of(PriceRequestMother.fivePriceRequest(), PriceResponseMother.fivePriceResponse())
    );
  }
}
