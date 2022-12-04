package com.altia.objectmother;

import com.altia.infra.outputadapter.h2repository.PriceResponse;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PriceResponseMother {

  private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH:mm:ss");

  public static PriceResponse firstPriceResponse() {
    return PriceResponse.builder()
        .productId(35455L)
        .brandId(1L)
        .priceList(1L)
        .starDate(LocalDateTime.parse("2020-06-14-00:00:00", dateTimeFormatter))
        .endDate(LocalDateTime.parse("2020-12-31-23:59:59", dateTimeFormatter))
        .price(BigDecimal.valueOf(35.50))
        .build();
  }

  public static PriceResponse secondPriceResponse() {
    return PriceResponse.builder()
        .productId(35455L)
        .brandId(1L)
        .priceList(2L)
        .starDate(LocalDateTime.parse("2020-06-14-15:00:00", dateTimeFormatter))
        .endDate(LocalDateTime.parse("2020-06-14-18:30:00", dateTimeFormatter))
        .price(BigDecimal.valueOf(25.45))
        .build();
  }

  public static PriceResponse threePriceResponse() {
    return PriceResponse.builder()
        .productId(35455L)
        .brandId(1L)
        .priceList(1L)
        .starDate(LocalDateTime.parse("2020-06-14-00:00:00", dateTimeFormatter))
        .endDate(LocalDateTime.parse("2020-12-31-23:59:59", dateTimeFormatter))
        .price(BigDecimal.valueOf(35.50))
        .build();
  }

  public static PriceResponse fourPriceResponse() {
    return PriceResponse.builder()
        .productId(35455L)
        .brandId(1L)
        .priceList(3L)
        .starDate(LocalDateTime.parse("2020-06-15-00:00:00", dateTimeFormatter))
        .endDate(LocalDateTime.parse("2020-06-15-11:00:00", dateTimeFormatter))
        .price(BigDecimal.valueOf(30.50))
        .build();
  }

  public static PriceResponse fivePriceResponse() {
    return PriceResponse.builder()
        .productId(35455L)
        .brandId(1L)
        .priceList(4L)
        .starDate(LocalDateTime.parse("2020-06-15-16:00:00", dateTimeFormatter))
        .endDate(LocalDateTime.parse("2020-12-31-23:59:59", dateTimeFormatter))
        .price(BigDecimal.valueOf(38.95))
        .build();
  }
}
