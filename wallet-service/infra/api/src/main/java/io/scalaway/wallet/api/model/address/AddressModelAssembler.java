/*
 * Copyright (c) 2022. Luidgi Gromat
 */

package io.scalaway.wallet.api.model.address;

import io.scalaway.wallet.api.controller.AddressController;
import io.scalaway.wallet.model.addresses.Address;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

@Component
public class AddressModelAssembler extends RepresentationModelAssemblerSupport<Address, AddressModel> {

    public AddressModelAssembler(){
        super(AddressController.class, AddressModel.class);
    }


    @Override
    public AddressModel toModel(Address entity) {
        AddressModel addressModel = instantiateModel(entity);
        addressModel.setPublicKey(entity.getPublicKey());
        addressModel.setPrivateKey(entity.getPrivateKey());
        return addressModel;
    }
}
