package com.altia.infra.outputadapter.h2repository;

import com.altia.domain.Price;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public final class PriceMapper {

  private Long brandId;
  private Long productId;
  private Long priceList;
  private LocalDateTime date;
  private BigDecimal price;

  public static PriceResponse toResponse(Price price) {
    return PriceResponse.builder()
        .brandId(price.getBrandId())
        .starDate(price.getStartDate())
        .endDate(price.getEndDate())
        .priceList(price.getPriceList())
        .productId(price.getProductId())
        .price(price.getPrice())
        .build();
  }
}
