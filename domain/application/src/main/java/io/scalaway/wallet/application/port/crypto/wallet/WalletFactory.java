/*
 * Copyright (c) 2022. Luidgi Gromat
 */

package io.scalaway.wallet.application.port.crypto.wallet;

import io.scalaway.walletservice.domain.accounts.Account;
import io.scalaway.walletservice.domain.wallets.Wallet;

public interface WalletFactory {
    WalletBuilder getBuilder();

    Wallet withAccount(boolean testnet, Account account) throws Exception;

}
