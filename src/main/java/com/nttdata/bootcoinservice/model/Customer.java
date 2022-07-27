package com.nttdata.bootcoinservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    private String id;
    private String name;
    private String lastName;
    private Date dateBorn;
    private String address;
    private String phone;
    private String typeDoc;   //1 DNI, 2 RUC
    private String numberDoc;
    private List<Product> products;
}
