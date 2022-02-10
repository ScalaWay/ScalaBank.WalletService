/*
 * Copyright (c) 2022. Luidgi Gromat
 */

package io.scalaway.wallet.application.port.usecase.wallet;

import io.scalaway.walletservice.domain.wallets.Wallet;

public interface DeleteWalletUseCase<TWallet extends Wallet, TId> {

    void deleteWalletById(TId id);

}
