/*
 * Copyright (c) 2022. Luidgi Gromat
 */

package io.scalaway.wallet.api.controller;

import io.scalaway.wallet.api.model.account.AccountModel;
import io.scalaway.wallet.api.model.account.CreateAccountRequest;
import io.scalaway.wallet.api.model.account.AccountModelAssembler;
import io.scalaway.wallet.application.port.usecase.account.CreateAccountUseCase;
import io.scalaway.wallet.application.port.usecase.account.QueryAccountUseCase;
import io.scalaway.wallet.application.port.usecase.account.command.CreateAccountCommand;
import io.scalaway.wallet.model.accounts.Account;
import lombok.AllArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class AccountController {

    private final CreateAccountUseCase createAccountUseCase;
    private final QueryAccountUseCase queryAccountUseCase;
    private final AccountModelAssembler accountModelAssembler;

    @PostMapping("/accounts")
    public ResponseEntity<AccountModel> createAccount(@RequestBody CreateAccountRequest request) throws Exception {
        CreateAccountCommand command = CreateAccountRequest.toCommand(request);
        Account account = this.createAccountUseCase.createAccount(command);

        return ResponseEntity
                .ok()
                .body(this.accountModelAssembler.toModel(account));
    }

    @GetMapping("/accounts/{id}")
    public ResponseEntity<AccountModel> getAccountById(@PathVariable("id") UUID id) {
        Account account = this.queryAccountUseCase.getAccountById(id);

        return new ResponseEntity<>(
                this.accountModelAssembler.toModel(account),
                HttpStatus.OK);
    }

    @GetMapping("/accounts")
    public ResponseEntity<CollectionModel<AccountModel>> getAllAccounts() {
        List<Account> accounts = this.queryAccountUseCase.getAllAccounts();

        return new ResponseEntity<>(
                this.accountModelAssembler.toCollectionModel(accounts),
                HttpStatus.OK);
    }

    @DeleteMapping("/accounts/{id}")
    public ResponseEntity<CollectionModel<AccountModel>> deleteAccount(@PathVariable("id") UUID id) {
        List<Account> accounts = this.queryAccountUseCase.getAllAccounts();

        return new ResponseEntity<>(
                this.accountModelAssembler.toCollectionModel(accounts),
                HttpStatus.OK);
    }
}
