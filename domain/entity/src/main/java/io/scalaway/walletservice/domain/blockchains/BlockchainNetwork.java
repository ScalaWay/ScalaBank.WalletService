/*
 * Copyright (c) 2022. Luidgi Gromat
 */

package io.scalaway.walletservice.domain.blockchains;

import lombok.Data;

@Data
public class BlockchainNetwork {
    private Blockchain blockchain;
    private String id;
    private boolean test;
}
