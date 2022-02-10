/*
 * Copyright (c) 2022. Luidgi Gromat
 */

package io.scalaway.walletservice.data.inmemory.repository;

import io.scalaway.wallet.application.port.persistence.AccountRepository;
import io.scalaway.walletservice.domain.accounts.Account;

import java.util.*;

public class InMemoryAccountRepository implements AccountRepository {
    private final Map<UUID, Account> accounts = new HashMap<>();

    // TODO: implement PreAuthorize
    @Override
    public Account getById(UUID id) {
        return this.accounts.get(id);
    }

    // TODO: implement PostAuthorize
    @Override
    public List<Account> getAll() {
        return new ArrayList<>(this.accounts.values());
    }

    // TODO: implement PreAuthorize and check if
    @Override
    public Account create(Account account) {
        account.setId(UUID.randomUUID());
        this.accounts.put(account.getId(), account);
        return account;
    }
}
