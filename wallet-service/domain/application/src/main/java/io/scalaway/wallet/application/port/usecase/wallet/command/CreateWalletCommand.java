/*
 * Copyright (c) 2022. Luidgi Gromat
 */

package io.scalaway.wallet.application.port.usecase.wallet.command;

import io.scalaway.wallet.model.Currency;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public final class CreateWalletCommand {
    private UUID accountId;
    private String name;
    private Currency currency;
}
