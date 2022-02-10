/*
 * Copyright (c) 2022. Luidgi Gromat
 */

package io.scalaway.walletservice.data.mysql.models;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class WalletEntity {

    @Id
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

}
