/*
 * Copyright (c) 2022. Luidgi Gromat
 */

package io.scalaway.wallet.application.port.usecase.wallet;

import io.scalaway.wallet.application.port.usecase.wallet.command.CreateWalletCommand;
import io.scalaway.walletservice.domain.wallets.Wallet;

public interface CreateWalletUseCase {

    Wallet createWallet(CreateWalletCommand command) throws Exception;

}
