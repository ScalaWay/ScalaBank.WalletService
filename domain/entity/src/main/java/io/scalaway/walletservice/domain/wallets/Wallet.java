/*
 * Copyright (c) 2022. Luidgi Gromat
 */

package io.scalaway.walletservice.domain.wallets;

import io.scalaway.walletservice.domain.Currency;
import io.scalaway.walletservice.domain.accounts.Account;
import io.scalaway.walletservice.domain.blockchains.BlockchainNetwork;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Wallet {
    private UUID id;
    private WalletType walletType;
    private String name;
    private String description;
    private Account account;
    private Currency currency;
    private float balance;
    private BlockchainNetwork blockchainNetwork;
    private String privateKey;
    private String publicKey;
}
