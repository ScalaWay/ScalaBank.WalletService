/*
 * Copyright (c) 2022. Luidgi Gromat
 */

package io.scalaway.wallet.application.service.wallet;

import io.scalaway.wallet.application.port.persistence.WalletRepository;
import io.scalaway.wallet.application.port.usecase.wallet.QueryWalletUseCase;
import io.scalaway.walletservice.domain.wallets.Wallet;

import java.util.List;
import java.util.UUID;

public class QueryWalletService implements QueryWalletUseCase {

    private final WalletRepository walletRepository;

    public QueryWalletService(WalletRepository walletRepository){
        this.walletRepository = walletRepository;
    }

    @Override
    public Wallet getById(UUID id) {
        return this.walletRepository.getById(id);
    }

    @Override
    public List<Wallet> findAll() {
        return this.walletRepository.findAll();
    }
}
