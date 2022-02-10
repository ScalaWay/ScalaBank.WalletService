/*
 * Copyright (c) 2022. Luidgi Gromat
 */

package io.scalaway.wallet.application.port.crypto.account;
import io.scalaway.walletservice.domain.accounts.Account;

import java.util.List;

public interface AccountFactory {
    AccountBuilder getBuilder();

    Account withSeed(String name, List<String> nmemonic, String passphrase) throws Exception;

    Account withRandomSeed(String name) throws Exception;
}
