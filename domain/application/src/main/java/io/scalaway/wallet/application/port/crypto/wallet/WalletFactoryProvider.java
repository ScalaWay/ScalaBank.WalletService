/*
 * Copyright (c) 2022. Luidgi Gromat
 */

package io.scalaway.wallet.application.port.crypto.wallet;

import io.scalaway.walletservice.domain.Currency;

public interface WalletFactoryProvider {
    WalletFactory forCurrency(Currency currency) throws Exception;
}
