package com.nttdata.bootcoinservice.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private String id;
    private Date startDate;
    private String number;
    private String type;
    private Double creditLimit;
    private Date expirationDate;
    private String securityCode;
    private Double commissionAmount;
    private Integer singleDayMovement;
    private Double creditAmount;
    private Integer paymentDay;
    private Integer maxMovementLimit;
    private String customerId;

    private Customer customer;

    private String typeWallet;
    private String phoneNumber;
    private String phoneImei;
    private String email;
    private Double amount;
}
