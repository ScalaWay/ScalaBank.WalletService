/*
 * Copyright (c) 2022. Luidgi Gromat
 */

package io.scalaway.wallet.crypto.wallet;

import io.scalaway.wallet.application.port.crypto.wallet.WalletFactory;
import io.scalaway.wallet.crypto.Constant;
import io.scalaway.wallet.model.accounts.Account;
import io.scalaway.wallet.model.wallets.Wallet;
import io.scalaway.wallet.application.port.crypto.wallet.WalletBuilder;
import org.bitcoinj.core.NetworkParameters;
import org.springframework.stereotype.Component;

@Component
public class BitcoinWalletFactory implements WalletFactory {

    // https://river.com/learn/terms/d/derivation-path/
    final String DERIVATION_PATH = "M/44H/0H/0H/0";
    final String TESTNET_DERIVATION_PATH = "M/44H/1H/0H/0";

    @Override
    public WalletBuilder getBuilder() {
        return new WalletBuilderService();
    }

    @Override
    public Wallet withAccount(boolean testnet, Account account) throws Exception {
        NetworkParameters network = testnet ? Constant.BITCOIN_TESTNET : Constant.BITCOIN_MAINNET;
        String derivationPath = testnet ? TESTNET_DERIVATION_PATH : DERIVATION_PATH;

        return getBuilder()
                .withNetwork(network, true)
                .withSeed(account.getSeed())
                .withDerivationPath(derivationPath)
                .build();
    }

}
