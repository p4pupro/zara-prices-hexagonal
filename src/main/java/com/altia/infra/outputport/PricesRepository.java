package com.altia.infra.outputport;

import com.altia.infra.entity.PriceEntity;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface PricesRepository extends JpaRepository<PriceEntity, Long> {

  @Query(value = " select p from PriceEntity p where p.productId = :productId "
      + " and  p.brandId = :brandId and :date BETWEEN p.startDate and p.endDate ")
  List<PriceEntity> findPrice(@Param("productId") Long productId, @Param("brandId") Long brandId, @Param("date") LocalDateTime date);
}
