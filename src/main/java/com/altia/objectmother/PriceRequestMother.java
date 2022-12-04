package com.altia.objectmother;


import com.altia.infra.inputport.PriceRequest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PriceRequestMother {

  private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

  public static PriceRequest firstPriceRequest() {
    return new PriceRequest(1L,35455L, LocalDateTime.parse("2020-06-14 10:00:00", dateTimeFormatter));
  }

  public static PriceRequest secondPriceRequest() {
    return new PriceRequest(1L,35455L, LocalDateTime.parse("2020-06-14 16:00:00", dateTimeFormatter));
  }

  public static PriceRequest threePriceRequest() {
    return new PriceRequest(1L,35455L, LocalDateTime.parse("2020-06-14 21:00:00", dateTimeFormatter));
  }

  public static PriceRequest fourPriceRequest() {
    return new PriceRequest(1L,35455L, LocalDateTime.parse("2020-06-15 10:00:00", dateTimeFormatter));
  }

  public static PriceRequest fivePriceRequest() {
    return new PriceRequest(1L,35455L, LocalDateTime.parse("2020-06-15 21:00:00", dateTimeFormatter));
  }
}
