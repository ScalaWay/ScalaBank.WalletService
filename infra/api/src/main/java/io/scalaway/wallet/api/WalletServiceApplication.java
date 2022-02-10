/*
 * Copyright (c) 2022. Luidgi Gromat
 */

package io.scalaway.wallet.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication()
@ComponentScan({"io.scalaway.wallet.api", "io.scalaway.walletservice.crypto"})
public class WalletServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(WalletServiceApplication.class, args);
    }

}