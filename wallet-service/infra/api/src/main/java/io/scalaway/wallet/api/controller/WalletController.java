/*
 * Copyright (c) 2022. Luidgi Gromat
 */

package io.scalaway.wallet.api.controller;

import io.scalaway.wallet.api.model.wallet.CreateWalletRequest;
import io.scalaway.wallet.api.model.wallet.WalletModel;
import io.scalaway.wallet.api.model.wallet.WalletModelAssembler;
import io.scalaway.wallet.application.port.usecase.wallet.CreateWalletUseCase;
import io.scalaway.wallet.application.port.usecase.wallet.QueryWalletUseCase;
import io.scalaway.wallet.application.port.usecase.wallet.command.CreateWalletCommand;
import io.scalaway.wallet.model.Currency;
import io.scalaway.wallet.model.wallets.Wallet;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class WalletController {

    private final CreateWalletUseCase createWalletUseCase;
    private final QueryWalletUseCase queryWalletUseCase;
    private final WalletModelAssembler walletModelAssembler;

    public WalletController(
            QueryWalletUseCase queryWalletUseCase,
            CreateWalletUseCase createWalletUseCase,
            WalletModelAssembler walletModelAssembler
    ){
        this.queryWalletUseCase = queryWalletUseCase;
        this.createWalletUseCase = createWalletUseCase;
        this.walletModelAssembler = walletModelAssembler;
    }

    @PostMapping("/wallets")
    public ResponseEntity<WalletModel> createWallet(@RequestBody CreateWalletRequest request) throws Exception {
        // TODO : mapping
        CreateWalletCommand createWalletCommand = new CreateWalletCommand();
        createWalletCommand.setAccountId(request.getAccountId());
        createWalletCommand.setName(request.getName());
        createWalletCommand.setCurrency(Currency.valueOf(request.getCurrency()));

        Wallet wallet = this.createWalletUseCase.createWallet(createWalletCommand);

        return ResponseEntity
                .ok()
                .body(this.walletModelAssembler.toModel(wallet));
    }

    /**
     * Get a single wallet by id.
     * @param id
     * @return
     */
    @GetMapping("/wallets/{id}")
    public Wallet getWalletById(@PathVariable("id") UUID id) {
        return queryWalletUseCase.getById(id);
    }

    // Get all wallets for user
    @GetMapping("/wallets")
    public List<Wallet> getAllWallets() {
        return queryWalletUseCase.findAll();
    }

}
