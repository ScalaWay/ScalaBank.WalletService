/*
 * Copyright (c) 2022. Luidgi Gromat
 */

package io.scalaway.wallet.application.port.usecase.account;

import io.scalaway.wallet.model.accounts.Account;

import java.util.List;
import java.util.UUID;

public interface QueryAccountUseCase {
    Account getAccountById(UUID id);

    List<Account> getAllAccounts();
}
