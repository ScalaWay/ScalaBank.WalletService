/*
 * Copyright (c) 2022. Luidgi Gromat
 */

package io.scalaway.wallet.application.service.account;

import io.scalaway.wallet.application.port.persistence.AccountRepository;
import io.scalaway.wallet.application.port.usecase.account.QueryAccountUseCase;
import io.scalaway.wallet.model.accounts.Account;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class QueryAccountService implements QueryAccountUseCase {

    private final AccountRepository accountRepository;

    public QueryAccountService(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    @Override
    public Account getAccountById(UUID id) {
        return this.accountRepository.getById(id);
    }

    @Override
    public List<Account> getAllAccounts() {
        List<Account> accounts = new ArrayList<>();
        for (Account account : this.accountRepository.getAll()){
            accounts.add(account);
        }
        return accounts;
    }
}
