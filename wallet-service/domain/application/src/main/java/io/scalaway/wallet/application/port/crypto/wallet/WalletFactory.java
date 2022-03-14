/*
 * Copyright (c) 2022. Luidgi Gromat
 */

package io.scalaway.wallet.application.port.crypto.wallet;

import io.scalaway.wallet.model.accounts.Account;
import io.scalaway.wallet.model.wallets.Wallet;

public interface WalletFactory {
    WalletBuilder getBuilder();

    Wallet withAccount(boolean testnet, Account account) throws Exception;

}
