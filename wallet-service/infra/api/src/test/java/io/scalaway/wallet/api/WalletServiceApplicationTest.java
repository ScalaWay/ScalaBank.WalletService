/*
 * Copyright (c) 2022. Luidgi Gromat
 */

package io.scalaway.wallet.api;

import io.scalaway.wallet.api.controller.AccountController;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * https://spring.io/guides/gs/testing-web/
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class WalletServiceApplicationTest {

    @Autowired
    AccountController accountController;

    @Test
    public void contextLoads() {
        Assertions.assertThat(accountController).isNotNull();
    }
}
