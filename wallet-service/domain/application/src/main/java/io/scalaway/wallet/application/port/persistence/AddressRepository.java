/*
 * Copyright (c) 2022. Luidgi Gromat
 */

package io.scalaway.wallet.application.port.persistence;

import io.scalaway.wallet.model.addresses.Address;

public interface AddressRepository {
    Address create(Address address);
    Address getByPublicKey(String publicKey);
}
