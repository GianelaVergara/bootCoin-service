package com.nttdata.bootcoinservice.service.impl;

import com.nttdata.bootcoinservice.service.ICustomerService;
import com.nttdata.bootcoinservice.model.Customer;
import reactor.core.publisher.Mono;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.circuitbreaker.resilience4j.ReactiveResilience4JCircuitBreakerFactory;

public class CustomerServiceImpl  implements ICustomerService {

    private final Logger log = LoggerFactory.getLogger(this.getClass().getName());
    @Autowired
    WebClient.Builder webClientBuilder;

    @Autowired
    ReactiveResilience4JCircuitBreakerFactory reactiveCircuitBreakerFactory;
    private String baseUri;
    @Override
    public Mono<Customer> getCustomerById(String id) {
        if (id == null || id.isEmpty() || id.trim().equals("")) {
            return Mono.empty();
        }
        return webClientBuilder.build()
                .get()
                .uri(baseUri + "/{customerId}", id)
                .retrieve()
                .bodyToMono(Customer.class);

    }

    private Mono<Customer> customerFallback(Throwable e) {
        log.info("CUSTOMER SERVICE IS BREAKER - MONO");
        return Mono.empty();
    }
}
