/*
 * Copyright (c) 2022. Luidgi Gromat
 */

package io.scalaway.wallet.application.port.crypto.address;

import io.scalaway.wallet.model.addresses.Address;
import io.scalaway.wallet.model.wallets.Wallet;

public interface AddressBuilder {

    AddressBuilder withWallet(Wallet wallet);
    Address build();

}
