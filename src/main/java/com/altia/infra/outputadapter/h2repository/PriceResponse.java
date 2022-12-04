package com.altia.infra.outputadapter.h2repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PriceResponse {
  private Long brandId;
  private Long productId;
  private Long priceList;
  private LocalDateTime starDate;
  private LocalDateTime endDate;
  private BigDecimal price;
}
