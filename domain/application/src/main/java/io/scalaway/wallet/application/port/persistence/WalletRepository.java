/*
 * Copyright (c) 2022. Luidgi Gromat
 */

package io.scalaway.wallet.application.port.persistence;

import io.scalaway.walletservice.domain.wallets.Wallet;
import java.util.List;
import java.util.UUID;

public interface WalletRepository {
    Wallet getById(UUID uuid);
    Wallet create(Wallet wallet);
    List<Wallet> findAll();
}
