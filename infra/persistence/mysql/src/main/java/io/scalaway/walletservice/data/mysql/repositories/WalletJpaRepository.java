/*
 * Copyright (c) 2022. Luidgi Gromat
 */

package io.scalaway.walletservice.data.mysql.repositories;

import io.scalaway.walletservice.data.mysql.models.WalletEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface WalletJpaRepository extends CrudRepository<WalletEntity, Long> {

}
