/*
 * Copyright (c) 2022. Luidgi Gromat
 */

package io.scalaway.walletservice.crypto.address;

import io.scalaway.wallet.application.port.crypto.address.AddressBuilder;
import io.scalaway.walletservice.domain.addresses.Address;
import io.scalaway.walletservice.domain.blockchains.BlockchainNetwork;
import io.scalaway.walletservice.domain.wallets.Wallet;
import org.bitcoinj.core.ECKey;
import org.bitcoinj.core.LegacyAddress;
import org.bitcoinj.core.NetworkParameters;
import org.bitcoinj.crypto.ChildNumber;
import org.bitcoinj.crypto.DeterministicHierarchy;
import org.bitcoinj.crypto.DeterministicKey;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

@Component
public class AddressBuilderService implements AddressBuilder {

    private DeterministicKey deterministicKey;
    private Wallet wallet;
    private int accountIndex = 0;
    private int addressIndex = 0;

    @Override
    public AddressBuilder withWallet(Wallet wallet) {
        this.wallet = wallet;
        this.derivePath();
        return this;
    }

    @Override
    public Address build() {
        // TODO : validation
        Address address = new Address();
        address.setWallet(this.wallet);
        address.setPublicKey(this.serializePublicKeyToBase58());
        address.setPrivateKey(this.getWIF());
        return address;
    }

    private void derivePath(){
        NetworkParameters networkParameters = NetworkParameters.fromID(this.wallet.getBlockchainNetwork().getId());
        Assert.notNull(networkParameters, "Failed to load network parameters.");

        DeterministicKey masterPrivateKey = DeterministicKey.deserializeB58(
                this.wallet.getPrivateKey(),
                networkParameters);

        DeterministicHierarchy deterministicHierarchy = new DeterministicHierarchy(masterPrivateKey);
        List<ChildNumber> parentPath = new ArrayList<>();
        parentPath.add(new ChildNumber(this.accountIndex));
        this.deterministicKey = deterministicHierarchy.deriveChild(parentPath,
                false,
                true,
                new ChildNumber(addressIndex));
    }

    private String serializePublicKeyToBase58() {
        BlockchainNetwork blockchainNetwork = this.wallet.getBlockchainNetwork();
        NetworkParameters networkParameters = NetworkParameters.fromID(blockchainNetwork.getId());
        Assert.notNull(networkParameters, "Failed to load network parameters.");

        return LegacyAddress
                .fromKey(networkParameters,
                        ECKey.fromPrivate(this.deterministicKey.getPrivKey()))
                .toBase58();
    }

    public String getWIF(){
        BlockchainNetwork blockchainNetwork = this.wallet.getBlockchainNetwork();
        NetworkParameters networkParameters = NetworkParameters.fromID(blockchainNetwork.getId());
        return this.deterministicKey.getPrivateKeyAsWiF(networkParameters);
    }

}
