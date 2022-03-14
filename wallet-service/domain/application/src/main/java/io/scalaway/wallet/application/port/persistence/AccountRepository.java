/*
 * Copyright (c) 2022. Luidgi Gromat
 */

package io.scalaway.wallet.application.port.persistence;

import io.scalaway.wallet.model.accounts.Account;

import java.util.List;
import java.util.UUID;

public interface AccountRepository {
    Account getById(UUID id);
    List<Account> getAll();
    Account create(Account account);

}
