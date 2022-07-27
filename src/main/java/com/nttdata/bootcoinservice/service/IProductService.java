package com.nttdata.bootcoinservice.service;

import com.nttdata.bootcoinservice.model.Product;
import reactor.core.publisher.Mono;

public interface IProductService {
    Mono<Void> registerWallet(Product product);
}
