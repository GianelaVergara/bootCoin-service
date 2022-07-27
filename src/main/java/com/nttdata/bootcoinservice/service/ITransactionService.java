package com.nttdata.bootcoinservice.service;

import com.nttdata.bootcoinservice.model.Transaction;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

public interface ITransactionService {
    Flux<Transaction> getTransactions();

    Mono<Transaction> getTransaction(String id);

    Mono<Transaction> insertTransaction(Transaction transaction);

    Mono<Transaction> updateTransaction(Transaction transaction, String id);

    Mono<Void> deleteTransaction(String id);
}
