/*
 * Copyright (c) 2022. Luidgi Gromat
 */

package io.scalaway.wallet.model.addresses;

import io.scalaway.wallet.model.wallets.Wallet;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private Wallet wallet;
    private String publicKey;
    private String privateKey;
}
