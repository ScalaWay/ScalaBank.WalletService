/*
 * Copyright (c) 2022. Luidgi Gromat
 */

package io.scalaway.wallet.crypto.wallet;

import io.scalaway.wallet.model.Currency;
import io.scalaway.wallet.model.blockchains.BlockchainNetwork;
import io.scalaway.wallet.model.wallets.Wallet;
import io.scalaway.wallet.application.port.crypto.wallet.WalletBuilder;
import org.bitcoinj.core.NetworkParameters;
import org.bitcoinj.crypto.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class WalletBuilderService implements WalletBuilder {
    private String derivationPath;
    private Currency currency;
    private BlockchainNetwork blockchainNetwork;
    private int accountIndex = 0;

    private DeterministicHierarchy deterministicHierarchy;
    private DeterministicKey deterministicKey;

    @Override
    public <T> WalletBuilder withNetwork(T network, boolean testnet) {
        NetworkParameters networkParameters = (NetworkParameters) network;
        this.blockchainNetwork = new BlockchainNetwork();
        this.blockchainNetwork.setTest(testnet);
        this.blockchainNetwork.setId(networkParameters.getId());
        return this;
    }

    @Override
    public WalletBuilder withDerivationPath(String derivationPath) {
        this.derivationPath = derivationPath;
        return this;
    }

    @Override
    public WalletBuilder withCurrency(Currency currency) {
        this.currency = currency;
        return this;
    }

    @Override
    public WalletBuilder withSeed(String seed){
        DeterministicKey deterministicKey = HDKeyDerivation.createMasterPrivateKey(MnemonicCode.toSeed(Arrays.asList(" ", seed), ""));
        this.deterministicHierarchy = new DeterministicHierarchy(deterministicKey);
        return this;
    }

    @Override
    public WalletBuilder withSeedAndPassphrase(String seed, String passphrase) {
        DeterministicKey deterministicKey = HDKeyDerivation.createMasterPrivateKey(MnemonicCode.toSeed(Arrays.asList(" ", seed), passphrase));
        this.deterministicHierarchy = new DeterministicHierarchy(deterministicKey);
        return this;
    }

    @Override
    public Wallet build() {
        // TODO : validation
        this.derivePath();
        Wallet wallet = new Wallet();
        wallet.setCurrency(this.currency);
        wallet.setBlockchainNetwork(this.blockchainNetwork);
        wallet.setPublicKey(this.publicKeyBase58());
        wallet.setPrivateKey(this.privateKeyBase58());
        return wallet;
    }

    private void derivePath(){
        List<ChildNumber> parentPath = new ArrayList<>();
        parentPath.add(new ChildNumber(this.accountIndex));

        this.deterministicKey = this.deterministicHierarchy.deriveChild(
                parentPath,
                false,
                true,
                new ChildNumber(0));
    }

    private String publicKeyBase58() {
        NetworkParameters networkParameters = NetworkParameters.fromID(this.blockchainNetwork.getId());
        return this.deterministicKey.serializePubB58(networkParameters);
    }

    private String privateKeyBase58() {
        NetworkParameters networkParameters = NetworkParameters.fromID(this.blockchainNetwork.getId());
        return this.deterministicKey.serializePrivB58(networkParameters);
    }

}
