/*
 * Copyright (c) 2022. Luidgi Gromat
 */

package io.scalaway.walletservice.crypto.account;

import io.scalaway.wallet.application.port.crypto.account.AccountBuilder;
import io.scalaway.walletservice.domain.accounts.Account;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

import java.util.List;

@Component
public class AccountBuilderService implements AccountBuilder {

    private List<String> seed;
    private String passphrase = "";
    private String name;

    @Override
    public AccountBuilder withName(String name) {
        // TODO : validation
        this.name = name;
        return this;
    }

    @Override
    public AccountBuilder withSeed(List<String> nmemonic) {
        // TODO : validation
        this.seed = nmemonic;
        return this;
    }

    @Override
    public AccountBuilder withPassphrase(String passphrase) {
        // TODO: validation
        this.passphrase = passphrase;
        return this;
    }

    @Override
    public Account build() throws Exception {
        if (this.seed == null) throw new Exception();
        if (this.name == null) throw new Exception();

        Account account = new Account();
        account.setName(this.name);
        account.setPassphrase(this.passphrase);

        String seed = String.join(" ", this.seed);
        account.setSeed(seed);

        return account;
    }
}
