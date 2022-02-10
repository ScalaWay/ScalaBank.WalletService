/*
 * Copyright (c) 2022. Luidgi Gromat
 */

package io.scalaway.wallet.api.config;

import io.scalaway.wallet.application.port.crypto.account.AccountFactory;
import io.scalaway.wallet.application.port.crypto.address.AddressFactory;
import io.scalaway.wallet.application.port.crypto.wallet.WalletFactoryProvider;
import io.scalaway.wallet.application.port.usecase.account.CreateAccountUseCase;
import io.scalaway.wallet.application.port.usecase.account.QueryAccountUseCase;
import io.scalaway.wallet.application.port.usecase.address.CreateAddressUseCase;
import io.scalaway.wallet.application.port.usecase.wallet.CreateWalletUseCase;
import io.scalaway.wallet.application.port.usecase.wallet.QueryWalletUseCase;
import io.scalaway.wallet.application.service.account.CreateAccountService;
import io.scalaway.wallet.application.service.account.QueryAccountService;
import io.scalaway.wallet.application.service.address.CreateAddressService;
import io.scalaway.wallet.application.service.wallet.CreateWalletService;
import io.scalaway.wallet.application.service.wallet.QueryWalletService;
import io.scalaway.walletservice.data.inmemory.repository.InMemoryAccountRepository;
import io.scalaway.walletservice.data.inmemory.repository.InMemoryAddressRepository;
import io.scalaway.walletservice.data.inmemory.repository.InMemoryWalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * https://dev.to/stack-labs/how-to-test-configuration-class-in-spring-boot-16ai
 */
@Configuration
public class ApplicationConfiguration {

    //region Factories
    @Autowired
    private AccountFactory accountFactory;

    @Autowired
    private AddressFactory addressFactory;

    @Autowired
    private WalletFactoryProvider walletFactoryProvider;
    //endregion

    //region Persistence
    @Bean
    public InMemoryWalletRepository inMemoryWalletRepository(){
        return new InMemoryWalletRepository();
    }

    @Bean
    public InMemoryAccountRepository inMemoryAccountRepository(){
        return new InMemoryAccountRepository();
    }

    @Bean
    public InMemoryAddressRepository inMemoryAddressRepository(){
        return new InMemoryAddressRepository();
    }
    //endregion

    //region Wallet Use-cases
    @Bean
    public QueryWalletUseCase queryWalletUseCase(){
        return new QueryWalletService(this.inMemoryWalletRepository());
    }

    @Bean
    public CreateWalletUseCase createWalletUseCase(){
        return new CreateWalletService(
                this.walletFactoryProvider,
                this.inMemoryWalletRepository(),
                this.queryAccountUseCase());
    }
    //endregion

    //region Address Use-cases
    @Bean
    public CreateAddressUseCase createAddressUseCase(){
        return new CreateAddressService(
                this.addressFactory,
                this.inMemoryWalletRepository());
    }
    //endregion

    //region Account Use-cases
    @Bean
    public QueryAccountUseCase queryAccountUseCase(){
        return new QueryAccountService(this.inMemoryAccountRepository());
    }

    @Bean
    public CreateAccountUseCase createAccountUseCase(){
        return new CreateAccountService(
                this.accountFactory,
                this.inMemoryAccountRepository());
    }
    //endregion
}
