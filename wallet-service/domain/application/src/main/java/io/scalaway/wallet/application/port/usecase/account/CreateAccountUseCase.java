/*
 * Copyright (c) 2022. Luidgi Gromat
 */

package io.scalaway.wallet.application.port.usecase.account;

import io.scalaway.wallet.application.port.usecase.account.command.CreateAccountCommand;
import io.scalaway.wallet.model.accounts.Account;

public interface CreateAccountUseCase {
    Account createAccount(CreateAccountCommand command) throws Exception;
}
