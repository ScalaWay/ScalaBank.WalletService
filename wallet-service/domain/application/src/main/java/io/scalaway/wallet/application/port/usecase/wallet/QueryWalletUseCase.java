/*
 * Copyright (c) 2022. Luidgi Gromat
 */

package io.scalaway.wallet.application.port.usecase.wallet;

import io.scalaway.wallet.model.wallets.Wallet;

import java.util.List;
import java.util.UUID;

public interface QueryWalletUseCase {

    Wallet getById(UUID id);

    List<Wallet> findAll();

}
