/*
 * Copyright (c) 2022. Luidgi Gromat
 */

package io.scalaway.walletservice.data.inmemory.repository;

import io.scalaway.wallet.application.port.persistence.WalletRepository;
import io.scalaway.wallet.model.wallets.Wallet;

import java.util.*;

public class InMemoryWalletRepository implements WalletRepository {

    private final Map<UUID, Wallet> wallets = new HashMap<>();

    @Override
    public Wallet getById(UUID id) {
        return this.wallets.get(id);
    }

    @Override
    public Wallet create(Wallet wallet) {
        wallet.setId(UUID.randomUUID());
        this.wallets.put(wallet.getId(), wallet);
        return wallet;
    }

    @Override
    public List<Wallet> findAll() {
        return new ArrayList<>(this.wallets.values());
    }
}
