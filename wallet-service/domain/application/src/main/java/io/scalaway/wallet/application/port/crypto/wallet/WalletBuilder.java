/*
 * Copyright (c) 2022. Luidgi Gromat
 */

package io.scalaway.wallet.application.port.crypto.wallet;

import io.scalaway.wallet.model.Currency;
import io.scalaway.wallet.model.wallets.Wallet;

public interface WalletBuilder {

    WalletBuilder withSeed(String seed);
    WalletBuilder withSeedAndPassphrase(String seed, String passphrase);
    <T> WalletBuilder withNetwork(T network, boolean testnet);
    WalletBuilder withDerivationPath(String derivationPath);
    WalletBuilder withCurrency(Currency currency);
    Wallet build();
}
