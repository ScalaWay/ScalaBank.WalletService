/*
 * Copyright (c) 2022. Luidgi Gromat
 */

package io.scalaway.wallet.model.wallets;

import io.scalaway.wallet.model.Currency;
import io.scalaway.wallet.model.accounts.Account;
import io.scalaway.wallet.model.blockchains.BlockchainNetwork;
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
