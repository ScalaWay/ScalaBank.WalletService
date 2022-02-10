/*
 * Copyright (c) 2022. Luidgi Gromat
 */

package io.scalaway.wallet.api.model.account;

import io.scalaway.wallet.api.controller.AccountController;
import io.scalaway.walletservice.domain.accounts.Account;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class AccountModelAssembler extends RepresentationModelAssemblerSupport<Account, AccountModel> {

    public AccountModelAssembler() {
        super(AccountController.class, AccountModel.class);
    }

    @Override
    public AccountModel toModel(Account entity) {
        AccountModel accountModel = instantiateModel(entity);
        accountModel.setId(entity.getId());
        accountModel.setName(entity.getName());
        accountModel.setDescription(entity.getDescription());
        accountModel.setSeed(entity.getSeed());
        accountModel.setLocked(entity.isLocked());
        return accountModel;
    }

    @Override
    public CollectionModel<AccountModel> toCollectionModel(Iterable<? extends Account> entities)
    {
        CollectionModel<AccountModel> accountModels = super.toCollectionModel(entities);
        accountModels.add(linkTo(methodOn(AccountController.class).getAllAccounts()).withSelfRel());
        return accountModels;
    }
}