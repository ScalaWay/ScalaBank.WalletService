/*
 * Copyright (c) 2022. Luidgi Gromat
 */

package io.scalaway.wallet.application.port.crypto.address;

import io.scalaway.walletservice.domain.addresses.Address;
import io.scalaway.walletservice.domain.wallets.Wallet;

public interface AddressBuilder {

    AddressBuilder withWallet(Wallet wallet);
    Address build();

}
