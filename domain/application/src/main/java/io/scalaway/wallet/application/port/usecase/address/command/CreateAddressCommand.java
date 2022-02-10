/*
 * Copyright (c) 2022. Luidgi Gromat
 */

package io.scalaway.wallet.application.port.usecase.address.command;

import io.scalaway.walletservice.domain.wallets.Wallet;
import lombok.Data;

@Data
public class CreateAddressCommand {
    private Wallet wallet;
}
