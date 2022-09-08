package com.xforce.app.xsellers.Controllers;

import com.xforce.app.xsellers.Entities.Empresas;
import com.xforce.app.xsellers.Entities.Transaction;
import com.xforce.app.xsellers.Services.EmpresasService;
import com.xforce.app.xsellers.Services.TransactionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TransactionController {
    public TransactionService transactionService;
    public EmpresasService empresaService;


    public TransactionController(TransactionService transactionService, EmpresasService empresaService) {
        this.transactionService = transactionService;
        this.empresaService = empresaService;
    }

    @GetMapping("/empresas/{id}/transaction")
    public List<Transaction> getAllTransaction(@PathVariable("id") Long id){
        return this.transactionService.getAllTransactionEmpresa(id);
    }

    @GetMapping("/empresas/{id}/transaction/{trxId}")
    @ResponseBody
    public List<Transaction> getTransactionById(@PathVariable("id") Long id,@PathVariable("trxId") Long trxId ){
        return transactionService.findTrxByEnterprise(id, trxId);
    }
    @PostMapping("/empresas/{id}/transaction")
    public Transaction createPostTransactio(@PathVariable("id") Long id,@RequestBody Transaction transactionPost){
        Empresas empresa  = empresaService.getEmpresa(id);
        transactionPost.setEmpresaMovimiento(empresa);
        return this.transactionService.createTransaction(transactionPost) ;
    }

    /*@DeleteMapping("/empresas/{id}/transaction/{id}")
    public String deleteTransaction(@PathVariable Long id){
        return this.transactionService.deleteTransactionById(id);
    }
    */
    
}
