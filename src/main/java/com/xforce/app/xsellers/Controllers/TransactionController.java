package com.xforce.app.xsellers.Controllers;

import com.xforce.app.xsellers.Entities.Transaction;
import com.xforce.app.xsellers.Services.TransactionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TransactionController {
    public TransactionService transactionService;


    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/empresas/{id}/transaction")
    public List<Transaction> getAllTransaction(@PathVariable("id") Long id){
        return this.transactionService.getAllTransaction();
    }

    @GetMapping("/empresas/{id}/transaction/{id}")
    @ResponseBody
    public Transaction getTransactionById(@PathVariable("id") Long id){
        return transactionService.getTransactionById(id);
    }
    @PostMapping("/empresas/{id}/transaction")
    public Transaction createPostTransactio(@RequestBody Transaction transactionPost){
        return this.transactionService.createTransaction(transactionPost) ;
    }

    @DeleteMapping("/empresas/{id}/transaction/{id}")
    public String deleteTransaction(@PathVariable Long id){
        return this.transactionService.deleteTransactionById(id);
    }

    
}
