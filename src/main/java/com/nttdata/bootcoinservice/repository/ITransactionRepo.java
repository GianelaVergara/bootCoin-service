package com.nttdata.bootcoinservice.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import com.nttdata.bootcoinservice.model.Transaction;

@Repository
public interface ITransactionRepo extends ReactiveMongoRepository<Transaction, String> {
}
