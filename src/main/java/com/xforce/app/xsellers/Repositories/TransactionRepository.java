package com.xforce.app.xsellers.Repositories;

import com.xforce.app.xsellers.Entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository <Transaction, Long> {
    @Query(value = "SELECT * FROM transaccion WHERE transaccion.empresa_movimiento=:empresaId", nativeQuery = true)
    @Modifying(clearAutomatically = true)
    @Transactional
    List<Transaction> findByEnterpriseId(Long empresaId);

    @Query(value = "SELECT * FROM transaccion WHERE transaccion.empresa_movimiento=:empresaId AND transaccion.id_movimiento = :trxId", nativeQuery = true)
    @Modifying(clearAutomatically = true)
    @Transactional
    List<Transaction> findTrxByEnterprise(Long empresaId, Long trxId);
}
