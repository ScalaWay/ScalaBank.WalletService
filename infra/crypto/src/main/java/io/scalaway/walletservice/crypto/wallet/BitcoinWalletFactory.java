/*
 * Copyright (c) 2022. Luidgi Gromat
 */

package io.scalaway.walletservice.crypto.wallet;

import io.scalaway.wallet.application.port.crypto.wallet.WalletFactory;
import io.scalaway.walletservice.domain.accounts.Account;
import io.scalaway.walletservice.domain.wallets.Wallet;
import io.scalaway.wallet.application.port.crypto.wallet.WalletBuilder;
import org.bitcoinj.core.NetworkParameters;
import org.springframework.stereotype.Component;

import static io.scalaway.walletservice.crypto.Constant.BITCOIN_MAINNET;
import static io.scalaway.walletservice.crypto.Constant.BITCOIN_TESTNET;

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
        NetworkParameters network = testnet ? BITCOIN_TESTNET : BITCOIN_MAINNET;
        String derivationPath = testnet ? TESTNET_DERIVATION_PATH : DERIVATION_PATH;

        return getBuilder()
                .withNetwork(network, true)
                .withSeed(account.getSeed())
                .withDerivationPath(derivationPath)
                .build();
    }

}
