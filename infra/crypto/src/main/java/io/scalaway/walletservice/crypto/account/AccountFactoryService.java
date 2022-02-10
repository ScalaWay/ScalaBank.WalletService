/*
 * Copyright (c) 2022. Luidgi Gromat
 */

package io.scalaway.walletservice.crypto.account;

import io.scalaway.walletservice.crypto.CryptoUtil;
import io.scalaway.wallet.application.port.crypto.account.AccountBuilder;
import io.scalaway.wallet.application.port.crypto.account.AccountFactory;
import io.scalaway.walletservice.domain.accounts.Account;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AccountFactoryService implements AccountFactory {
    @Override
    public AccountBuilder getBuilder() {
        return new AccountBuilderService();
    }

    @Override
    public Account withSeed(String name, List<String> nmemonic, String passphrase) throws Exception {
        return getBuilder()
                .withName(name)
                .withSeed(nmemonic)
                .withPassphrase(passphrase)
                .build();
    }

    @Override
    public Account withRandomSeed(String name) throws Exception {
        return getBuilder()
                .withName(name)
                .withSeed(CryptoUtil.generateMnemonic())
                .build();
    }
}
