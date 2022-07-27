package com.nttdata.bootcoinservice.service;

import com.nttdata.bootcoinservice.model.Customer;
import reactor.core.publisher.Mono;

public interface ICustomerService {
    Mono<Customer> getCustomerById(String id);
}
