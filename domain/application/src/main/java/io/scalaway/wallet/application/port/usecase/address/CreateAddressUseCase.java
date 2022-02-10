/*
 * Copyright (c) 2022. Luidgi Gromat
 */

package io.scalaway.wallet.application.port.usecase.address;

import io.scalaway.wallet.application.port.usecase.address.command.CreateAddressCommand;
import io.scalaway.walletservice.domain.addresses.Address;

import java.util.concurrent.ExecutionException;

public interface CreateAddressUseCase {
    Address createAddress(CreateAddressCommand command) throws ExecutionException, InterruptedException;
}
