package com.nttdata.bootcoinservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movement {

    private String id;
    private String concept;
    private Date date;
    private Double amount;
    private String customerId;
    private String productId;
    private Customer customer;
    private Product product;

}
