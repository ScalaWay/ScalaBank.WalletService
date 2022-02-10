/*
 * Copyright (c) 2022. Luidgi Gromat
 */

package io.scalaway.walletservice.domain.transactions;

import io.scalaway.walletservice.domain.addresses.Address;

// https://github.com/Coding-Enthusiast/BitcoinTransactionTool/blob/master/BitcoinTransactionTool/Models/UTXO.cs
public class Transaction {
    private Address address;
    private String hash;
    private Integer outIndex;
    private Integer confirmations;
    private Long amount;
}
