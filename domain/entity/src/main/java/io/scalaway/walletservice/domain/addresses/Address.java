/*
 * Copyright (c) 2022. Luidgi Gromat
 */

package io.scalaway.walletservice.domain.addresses;

import io.scalaway.walletservice.domain.wallets.Wallet;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private Wallet wallet;
    private String publicKey;
    private String privateKey;
}
