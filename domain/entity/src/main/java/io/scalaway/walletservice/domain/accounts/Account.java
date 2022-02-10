/*
 * Copyright (c) 2022. Luidgi Gromat
 */

package io.scalaway.walletservice.domain.accounts;

import io.scalaway.walletservice.domain.users.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class Account {

    public Account(UUID id, String name, AccountType accountType){
        this.id = id;
        this.name = name;
        this.accountType = accountType;
    }

    private UUID id;

    private AccountType accountType;

    /**
     * User owning the cryptocurrencies account.
     */
    private User user;

    /**
     * Account name.
     */
    private String name;

    /**
     * Account description.
     */
    private String description;

    /**
     * Space separated list of words used for build a deterministic master key.
     */
    private String seed;

    private String passphrase;

    public boolean isLocked(){
        return (passphrase != null && !passphrase.isEmpty());
    }
}
