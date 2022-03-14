/*
 * Copyright (c) 2022. Luidgi Gromat
 */

package io.scalaway.wallet.api.model.address;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;

import java.util.UUID;

@Data
public class CreateAddressRequest {

    @JsonDeserialize
    private UUID walletId;
}
