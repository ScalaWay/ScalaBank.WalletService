/*
 * Copyright (c) 2022. Luidgi Gromat
 */

package io.scalaway.wallet.application.port.usecase.wallet;

import io.scalaway.wallet.model.wallets.Wallet;

public interface DeleteWalletUseCase<TWallet extends Wallet, TId> {

    void deleteWalletById(TId id);

}
