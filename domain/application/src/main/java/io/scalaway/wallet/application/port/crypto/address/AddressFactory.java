/*
 * Copyright (c) 2022. Luidgi Gromat
 */

package io.scalaway.wallet.application.port.crypto.address;

import io.scalaway.walletservice.domain.addresses.Address;
import io.scalaway.walletservice.domain.wallets.Wallet;

import java.util.concurrent.ExecutionException;

public interface AddressFactory {
    AddressBuilder getBuilder();
    Address getLegacyAddress(Wallet wallet) throws ExecutionException, InterruptedException;
    Address getSegWitAddress(Wallet wallet);
}
