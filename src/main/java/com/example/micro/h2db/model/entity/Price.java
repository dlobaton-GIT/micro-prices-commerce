package com.example.micro.h2db.model.entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
@Data
@Entity
@Table(name="Prices")
@Jacksonized
@JsonAutoDetect
public class Price {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private int brand_id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date start_date;
    @Temporal(TemporalType.TIMESTAMP)
    private Date end_date;
    private int price_list;
    private int product_id;
    private int priority;
    private BigDecimal price;
    private String currency;
}
