/*
 * Copyright (c) 2022. Luidgi Gromat
 */

package io.scalaway.walletservice.data.mysql.models;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
public abstract class AddressEntity {

    @Id
    @Getter
    @Setter
    private long id;
}
