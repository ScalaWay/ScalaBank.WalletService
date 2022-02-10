/*
 * Copyright (c) 2022. Luidgi Gromat
 */

package io.scalaway.wallet.api.model.wallet;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonRootName(value = "wallet")
public class WalletModel extends RepresentationModel<WalletModel> {
    private UUID id;
    private String name;
    private String seed;
    private String privateKey;
    private String publicKey;
}
