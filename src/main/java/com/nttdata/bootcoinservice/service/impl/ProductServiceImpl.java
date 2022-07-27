package com.nttdata.bootcoinservice.service.impl;

import com.nttdata.bootcoinservice.service.ICustomerService;
import com.nttdata.bootcoinservice.model.Product;
import com.nttdata.bootcoinservice.model.Customer;
import com.nttdata.bootcoinservice.config.KafkaStringConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import java.util.Date;


public class ProductServiceImpl {
    @Autowired
    ICustomerService customerService;

    @Override
    public Mono<Void> registerWallet(Product product) {
        product.setTypeWallet(Product.gettypeWallet);
        product.setAmount(0.0);
        product.setStartDate(new Date());
        return Mono.justOrEmpty(product)
                .defaultIfEmpty(new Product(new Customer()))
                .map(Product::getCustomer)
                .flatMap(customer -> customerService.getCustomerById(customer.getId()))
                .doOnNext(product::setCustomer);

    }
}
