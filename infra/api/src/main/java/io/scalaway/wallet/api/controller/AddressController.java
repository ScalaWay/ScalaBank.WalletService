/*
 * Copyright (c) 2022. Luidgi Gromat
 */

package io.scalaway.wallet.api.controller;

import io.scalaway.wallet.api.model.address.AddressModel;
import io.scalaway.wallet.api.model.address.AddressModelAssembler;
import io.scalaway.wallet.api.model.address.CreateAddressRequest;
import io.scalaway.wallet.application.port.usecase.address.CreateAddressUseCase;
import io.scalaway.wallet.application.port.usecase.address.command.CreateAddressCommand;
import io.scalaway.wallet.application.port.usecase.wallet.QueryWalletUseCase;
import io.scalaway.walletservice.domain.addresses.Address;
import io.scalaway.walletservice.domain.wallets.Wallet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class AddressController {

    @Autowired
    private QueryWalletUseCase queryWalletUseCase;

    @Autowired
    private CreateAddressUseCase createAddressUseCase;

    @Autowired
    private AddressModelAssembler addressModelAssembler;

    @PostMapping("/address")
    public ResponseEntity<AddressModel> createAddress(@RequestBody CreateAddressRequest request) throws Exception {
        //Wallet wallet = queryWalletUseCase.getById(request.getWalletId());
        Wallet wallet = queryWalletUseCase.findAll().get(0);

        CreateAddressCommand createAddressCommand = new CreateAddressCommand();
        createAddressCommand.setWallet(wallet);

        Address address = createAddressUseCase.createAddress(createAddressCommand);

        return ResponseEntity
                .ok()
                .body(this.addressModelAssembler.toModel(address));
    }


}
