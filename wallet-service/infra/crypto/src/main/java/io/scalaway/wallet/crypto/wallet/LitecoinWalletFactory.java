/*
 * Copyright (c) 2022. Luidgi Gromat
 */

package io.scalaway.wallet.crypto.wallet;

import io.scalaway.wallet.application.port.crypto.wallet.WalletFactory;
import io.scalaway.wallet.model.accounts.Account;
import io.scalaway.wallet.model.wallets.Wallet;
import io.scalaway.wallet.application.port.crypto.wallet.WalletBuilder;
import org.springframework.stereotype.Component;


@Component
public class LitecoinWalletFactory implements WalletFactory {
    @Override
    public WalletBuilder getBuilder() {
        return new WalletBuilderService();
    }

    @Override
    public Wallet withAccount(boolean testnet, Account account) throws Exception {
        return null;
    }

}
