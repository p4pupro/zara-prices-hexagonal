package com.altia.infra.entity;

import com.altia.domain.Price;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PRICES")
public class PriceEntity {
  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  @Column( name = "ID")
  private Long id;

  @Column( name = "BRAND_ID")
  private Long  brandId;

  @Column( name = "START_DATE")
  private LocalDateTime startDate;

  @Column( name = "END_DATE")
  private LocalDateTime endDate;

  @Column( name = "PRICE_LIST")
  private Long priceList;

  @Column( name = "PRODUCT_ID")
  private Long productId;

  @Column( name = "PRIORITY")
  private Long priority;

  @Column( name = "PRICE")
  private BigDecimal price;

  @Column( name = "CURR")
  private String currency;

  public Price toDomain() {
    return Price.builder()
        .brandId(brandId)
        .startDate(startDate)
        .endDate(endDate)
        .priceList(priceList)
        .productId(productId)
        .priority(priority)
        .price(price)
        .currency(currency)
        .build();
  }
}

