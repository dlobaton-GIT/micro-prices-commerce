package com.example.micro.h2db;

import com.example.micro.h2db.model.entity.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;

public interface H2Repository extends JpaRepository<Price, Long> {
    @Query(value = "SELECT * FROM Prices p WHERE p.brand_id=?1 AND p.product_id=?2 AND p.start_date <= ?3 AND p.end_date >= ?3 ORDER BY p.priority DESC LIMIT 1",
    nativeQuery = true)
    Price findByFilters(int chainId, int productId, Date applicationDate);
}
