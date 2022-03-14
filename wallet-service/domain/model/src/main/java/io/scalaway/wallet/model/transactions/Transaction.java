/*
 * Copyright (c) 2022. Luidgi Gromat
 */

package io.scalaway.wallet.model.transactions;

import io.scalaway.wallet.model.addresses.Address;

// https://github.com/Coding-Enthusiast/BitcoinTransactionTool/blob/master/BitcoinTransactionTool/Models/UTXO.cs
public class Transaction {
    private Address address;
    private String hash;
    private Integer outIndex;
    private Integer confirmations;
    private Long amount;
}
