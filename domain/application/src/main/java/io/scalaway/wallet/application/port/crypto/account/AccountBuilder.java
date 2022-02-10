/*
 * Copyright (c) 2022. Luidgi Gromat
 */

package io.scalaway.wallet.application.port.crypto.account;

import io.scalaway.walletservice.domain.accounts.Account;

import java.util.List;

public interface AccountBuilder {
    AccountBuilder withName(String name);
    AccountBuilder withSeed(List<String> nmemonic);
    AccountBuilder withPassphrase(String passphrase);
    Account build() throws Exception;
}
