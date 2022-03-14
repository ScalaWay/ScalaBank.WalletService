/*
 * Copyright (c) 2022. Luidgi Gromat
 */

package io.scalaway.walletservice.data.inmemory.repository;

import io.scalaway.wallet.application.port.persistence.AddressRepository;
import io.scalaway.wallet.model.addresses.Address;

import java.util.HashMap;
import java.util.Map;

public class InMemoryAddressRepository implements AddressRepository {

    private final Map<String, Address> addresses = new HashMap<>();

    @Override
    public Address create(Address address) {
        this.addresses.put(address.getPublicKey(), address);
        return address;
    }

    @Override
    public Address getByPublicKey(String publicKey) {
        return this.addresses.get(publicKey);
    }

}
