package com.nttdata.bootcoinservice.controller;

import com.nttdata.bootcoinservice.service.ITransactionService;
import com.nttdata.bootcoinservice.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/transaction")
public class TransactionController {
    @Autowired
    ITransactionService iTransactionService;

    @GetMapping(value = "")
    public Flux<Transaction> getAllProducts() {
        return iTransactionService.getTransactions();
    }

    @GetMapping(value = "/{id}")
    public Mono<Transaction> getProduct(@PathVariable String id) {
        return iTransactionService.getTransaction(id);
    }

    @PostMapping(value = "")
    public Mono<Transaction> createProduct(@RequestBody Transaction transaction) {
        return iTransactionService.insertTransaction(transaction);
    }

    @PostMapping(value = "/update/{id}")
    public Mono<Transaction> modifyProduct(@RequestBody Transaction transaction, @PathVariable String id) {
        return iTransactionService.updateTransaction(transaction, id);
    }

    @PostMapping(value = "/delete/{id}")
    public Mono<Void> removeProduct(@PathVariable String id) {
        return iTransactionService.deleteTransaction(id);
    }
}
