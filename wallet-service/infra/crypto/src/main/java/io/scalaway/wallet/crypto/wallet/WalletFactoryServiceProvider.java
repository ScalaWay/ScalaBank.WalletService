/*
 * Copyright (c) 2022. Luidgi Gromat
 */

package io.scalaway.wallet.crypto.wallet;

import io.scalaway.wallet.application.port.crypto.wallet.WalletFactory;
import io.scalaway.wallet.application.port.crypto.wallet.WalletFactoryProvider;
import io.scalaway.wallet.model.Currency;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

@Component
public class WalletFactoryServiceProvider implements WalletFactoryProvider {

    static final Map<Currency, Callable> handlers = new HashMap<>();
    static {
        handlers.put(Currency.BTC, BitcoinWalletFactory::new);
        handlers.put(Currency.LTC, LitecoinWalletFactory::new);
    }

    @Override
    public WalletFactory forCurrency(Currency currency) throws Exception {
        return (WalletFactory) handlers.get(currency).call();
    }
}
