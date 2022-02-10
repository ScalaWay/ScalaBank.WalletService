/*
 * Copyright (c) 2022. Luidgi Gromat
 */

package io.scalaway.wallet.application.service.address;

import io.scalaway.wallet.application.port.crypto.address.AddressFactory;
import io.scalaway.wallet.application.port.persistence.WalletRepository;
import io.scalaway.wallet.application.port.usecase.address.CreateAddressUseCase;
import io.scalaway.wallet.application.port.usecase.address.command.CreateAddressCommand;
import io.scalaway.walletservice.domain.addresses.Address;

import java.util.concurrent.ExecutionException;

public class CreateAddressService implements CreateAddressUseCase {

    private final AddressFactory addressFactory;
    private final WalletRepository walletRepository;

    public CreateAddressService(
            AddressFactory addressFactory,
            WalletRepository walletRepository
    ){
        this.addressFactory = addressFactory;
        this.walletRepository = walletRepository;
    }

    @Override
    public Address createAddress(CreateAddressCommand command) throws ExecutionException, InterruptedException {
        return this.addressFactory.getLegacyAddress(command.getWallet());
    }
}
