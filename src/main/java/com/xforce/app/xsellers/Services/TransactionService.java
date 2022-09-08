package com.xforce.app.xsellers.Services;

import com.xforce.app.xsellers.Entities.Transaction;
import com.xforce.app.xsellers.Repositories.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {
    private TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public List<Transaction> getAllTransactionEmpresa(Long id){
        return this.transactionRepository.findByEnterpriseId(id);
    }

    public Transaction getTransactionById(Long id){
        Optional<Transaction> transactionResponse = Optional.ofNullable(transactionRepository.findById(id).orElse(null));
        return  transactionResponse.get();
    }

    public List<Transaction> getAllTransaction(){
        return this.transactionRepository.findAll();
    }

    public Transaction createTransaction(Transaction newTransaction){
        return this.transactionRepository.save(newTransaction);
    }

    public String deleteTransactionById(Long id){
        this.transactionRepository.deleteById(id);
        return "Transacción " +id +" Eliminada";
    }

    public List<Transaction> findTrxByEnterprise(Long idEmpresa, Long idTrx){
        return this.transactionRepository.findTrxByEnterprise(idEmpresa, idTrx);
    }

    public String updateTransaction(Long id, Transaction transaction) {
        Transaction transactionToUpdate = this.transactionRepository.getReferenceById(id);
        transactionToUpdate.setConceptoMovimiento(transaction.getConceptoMovimiento());
        transactionToUpdate.setMontoMovimiento(transaction.getMontoMovimiento());
        this.transactionRepository.save(transactionToUpdate);
        return "Transacción " +id +" actualizada";
    }

}
