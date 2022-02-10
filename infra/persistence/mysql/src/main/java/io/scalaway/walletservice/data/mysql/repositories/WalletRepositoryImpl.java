/*
 * Copyright (c) 2022. Luidgi Gromat
 */

package io.scalaway.walletservice.data.mysql.repositories;

import io.scalaway.walletservice.data.mysql.models.WalletEntity;
import io.scalaway.wallet.application.port.persistence.WalletRepository;
import io.scalaway.walletservice.domain.wallets.Wallet;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.BeanUtils;


import java.util.List;
import java.util.UUID;

public class WalletRepositoryImpl implements WalletRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Wallet getById(UUID id) {
        WalletEntity walletEntity = this.entityManager.find(WalletEntity.class, id);
        if (walletEntity == null) {
            throw new EntityNotFoundException();
        }

        this.entityManager.detach(walletEntity);
        Wallet wallet = new Wallet();
        BeanUtils.copyProperties(walletEntity, wallet);
        return wallet;
    }

    @Override
    public Wallet create(Wallet wallet) {
        return null;
    }

    @Override
    public List<Wallet> findAll() {
        return null;
    }
}
