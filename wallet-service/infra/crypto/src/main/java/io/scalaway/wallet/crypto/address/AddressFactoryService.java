/*
 * Copyright (c) 2022. Luidgi Gromat
 */

package io.scalaway.wallet.crypto.address;

import io.scalaway.wallet.application.port.crypto.address.AddressBuilder;
import io.scalaway.wallet.application.port.crypto.address.AddressFactory;
import io.scalaway.wallet.model.addresses.Address;
import io.scalaway.wallet.model.wallets.Wallet;
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
