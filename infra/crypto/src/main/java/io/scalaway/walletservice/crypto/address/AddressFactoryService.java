/*
 * Copyright (c) 2022. Luidgi Gromat
 */

package io.scalaway.walletservice.crypto.address;

import io.scalaway.wallet.application.port.crypto.address.AddressBuilder;
import io.scalaway.wallet.application.port.crypto.address.AddressFactory;
import io.scalaway.walletservice.domain.addresses.Address;
import io.scalaway.walletservice.domain.wallets.Wallet;
import org.springframework.stereotype.Component;


@Component
public class AddressFactoryService implements AddressFactory {

    @Override
    public AddressBuilder getBuilder() {
        return new AddressBuilderService();
    }

    @Override
    public Address getLegacyAddress(Wallet wallet) {
        return getBuilder()
                .withWallet(wallet)
                .build();
    }

    @Override
    public Address getSegWitAddress(Wallet wallet) {
        return null;
    }
}
