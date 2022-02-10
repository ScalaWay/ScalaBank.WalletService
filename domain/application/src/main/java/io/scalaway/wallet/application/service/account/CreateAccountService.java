/*
 * Copyright (c) 2022. Luidgi Gromat
 */

package io.scalaway.wallet.application.service.account;

import io.scalaway.wallet.application.port.crypto.account.AccountFactory;
import io.scalaway.wallet.application.port.persistence.AccountRepository;
import io.scalaway.wallet.application.port.usecase.account.CreateAccountUseCase;
import io.scalaway.wallet.application.port.usecase.account.command.CreateAccountCommand;
import io.scalaway.walletservice.domain.accounts.Account;

import java.util.Arrays;

public class CreateAccountService implements CreateAccountUseCase {

    private final AccountRepository accountRepository;
    private final AccountFactory accountFactory;

    public CreateAccountService(
            AccountFactory accountFactory,
            AccountRepository accountRepository
    ){
        this.accountFactory = accountFactory;
        this.accountRepository = accountRepository;
    }

    @Override
    public Account createAccount(CreateAccountCommand command) throws Exception {
        Account account;
        if (command.getSeed() == null || command.getSeed().isEmpty()){
            account = accountFactory.withRandomSeed(command.getName());
        } else {
            account = accountFactory.withSeed(
                    command.getName(),
                    Arrays.asList(command.getSeed().split(" ")),
                    command.getPassphrase());
        }

        return this.accountRepository.create(account);
    }
}
