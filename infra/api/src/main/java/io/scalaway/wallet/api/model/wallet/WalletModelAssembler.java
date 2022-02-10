/*
 * Copyright (c) 2022. Luidgi Gromat
 */

package io.scalaway.wallet.api.model.wallet;

import io.scalaway.wallet.api.controller.WalletController;
import io.scalaway.walletservice.domain.wallets.Wallet;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

@Component
public class WalletModelAssembler
        extends RepresentationModelAssemblerSupport<Wallet, WalletModel> {

    public WalletModelAssembler(){
        super(WalletController.class, WalletModel.class);
    }

    @Override
    public WalletModel toModel(Wallet entity) {
        WalletModel walletModel = instantiateModel(entity);
        walletModel.setId(entity.getId());
        walletModel.setName(entity.getName());
        walletModel.setPublicKey(entity.getPublicKey());
        walletModel.setPrivateKey(entity.getPrivateKey());
        return walletModel;
    }
}
