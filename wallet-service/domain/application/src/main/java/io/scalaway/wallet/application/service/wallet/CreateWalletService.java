/*
 * Copyright (c) 2022. Luidgi Gromat
 */

package io.scalaway.wallet.application.service.wallet;

import io.scalaway.wallet.application.port.crypto.wallet.WalletFactory;
import io.scalaway.wallet.application.port.crypto.wallet.WalletFactoryProvider;
import io.scalaway.wallet.application.port.persistence.WalletRepository;
import io.scalaway.wallet.application.port.usecase.account.QueryAccountUseCase;
import io.scalaway.wallet.application.port.usecase.wallet.CreateWalletUseCase;
import io.scalaway.wallet.application.port.usecase.wallet.command.CreateWalletCommand;
import io.scalaway.wallet.model.accounts.Account;
import io.scalaway.wallet.model.wallets.Wallet;

public class CreateWalletService implements CreateWalletUseCase {

    private final WalletFactoryProvider walletFactoryProvider;
    private final WalletRepository walletRepository;
    private final QueryAccountUseCase queryAccountUseCase;

    public CreateWalletService(
            WalletFactoryProvider walletFactoryProvider,
            WalletRepository walletRepository,
            QueryAccountUseCase queryAccountUseCase){
        this.walletFactoryProvider = walletFactoryProvider;
        this.walletRepository = walletRepository;
        this.queryAccountUseCase = queryAccountUseCase;
    }

    @Override
    public Wallet createWallet(CreateWalletCommand command) throws Exception {
        Account account = queryAccountUseCase.getAllAccounts().get(0);

        WalletFactory walletFactory = this.walletFactoryProvider.forCurrency(command.getCurrency());
        Wallet wallet = walletFactory.withAccount(true, account);
        wallet.setName(command.getName());

        return this.walletRepository.create(wallet);
    }

}
