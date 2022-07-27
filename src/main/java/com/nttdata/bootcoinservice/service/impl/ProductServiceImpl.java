package com.nttdata.bootcoinservice.service.impl;

import com.nttdata.bootcoinservice.service.ICustomerService;
import com.nttdata.bootcoinservice.model.Product;
import com.nttdata.bootcoinservice.model.Customer;
import com.nttdata.bootcoinservice.config.KafkaStringConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import java.util.Date;
import org.springframework.cloud.circuitbreaker.resilience4j.ReactiveResilience4JCircuitBreakerFactory;

public class ProductServiceImpl {
    @Autowired
    ICustomerService customerService;
    private static final String CIRCUIT_BREAKER_SERVICE_CUSTOMER = "cbServiceCustomer";

    @Autowired
    ReactiveResilience4JCircuitBreakerFactory reactiveCircuitBreakerFactory;
    @Override
    public Mono<Void> registerWallet(Product product) {
        product.setTypeWallet(Product.gettypeWallet);
        product.setAmount(0.0);
        product.setStartDate(new Date());
        return Mono.justOrEmpty(product)
                .defaultIfEmpty(new Product(new Customer()))
                .map(Product::getCustomer)
                .flatMap(customer -> customerService.getCustomerById(customer.getId()))
                .doOnNext(product::setCustomer)
                .transform(it ->
                        reactiveCircuitBreakerFactory.create(CIRCUIT_BREAKER_SERVICE_CUSTOMER)
                                .run(it, this::customerFallback)
                );
    }
    private Mono<Customer> customerFallback(Throwable e) {
        log.info("CUSTOMER SERVICE IS BREAKER - MONO");
        return Mono.empty();
    }
}
