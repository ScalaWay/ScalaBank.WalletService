/*
 * Copyright (c) 2022. Luidgi Gromat
 */

package io.scalaway.wallet.application.port.usecase.account.command;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public final class CreateAccountCommand {
    private String name;
    private String seed;
    private String passphrase;
}
