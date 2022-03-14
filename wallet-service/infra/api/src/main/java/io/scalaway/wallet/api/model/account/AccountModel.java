/*
 * Copyright (c) 2022. Luidgi Gromat
 */

package io.scalaway.wallet.api.model.account;

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
@JsonRootName(value = "account")
public class AccountModel extends RepresentationModel<AccountModel> {
    private UUID id;
    private String name;
    private String description;
    private String seed;
    private boolean locked;
}
