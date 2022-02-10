/*
 * Copyright (c) 2022. Luidgi Gromat
 */

package io.scalaway.wallet.api.controller;

import io.scalaway.wallet.api.model.account.AccountModelAssembler;
import io.scalaway.wallet.application.port.usecase.account.QueryAccountUseCase;
import io.scalaway.walletservice.domain.accounts.Account;

import io.scalaway.walletservice.domain.accounts.AccountType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.hateoas.MediaTypes;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.UUID;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(AccountController.class)
@Import({ AccountModelAssembler.class })
public class AccountControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private QueryAccountUseCase queryAccountUseCase;

    @Test
    public void createAccount_Valid_AccountModel(){

    }

    @Test
    public void createAccount_AccountAlreadyExists_ThrowException(){

    }



    @Test
    public void getAccountById_ValidIdAndUser_AccountModel() throws Exception {
        // Arrange
        UUID uuid = UUID.randomUUID();
        given(queryAccountUseCase.getAccountById(uuid)).willReturn(
                new Account(uuid, "Test", AccountType.CLOUD));

        mockMvc.perform(get("/api/v1/accounts/" + uuid).accept(MediaTypes.HAL_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void getAllAccounts() throws Exception {
        // Arrange
        given(queryAccountUseCase.getAccountById(UUID.randomUUID())).willReturn(
                new Account());

        mockMvc.perform(get("/api/v1/accounts").accept(MediaTypes.HAL_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }
}
