/*
 * Copyright (c) 2022. Luidgi Gromat
 */

package io.scalaway.wallet.api.model.wallet;

import lombok.Data;

import java.util.UUID;

@Data
public final class CreateWalletRequest {
    private UUID accountId;
    private String name;
    private String currency;
}
