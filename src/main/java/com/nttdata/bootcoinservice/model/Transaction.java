package com.nttdata.bootcoinservice.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@Data
@Document(collection = "products")
public class Transaction {

    @Id
    private String id;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date;
    private String currency;
    private Double purchasePrice;
    private Double salePrice;

}
