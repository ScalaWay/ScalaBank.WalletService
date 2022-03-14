/*
 * Copyright (c) 2022. Luidgi Gromat
 */

package io.scalaway.wallet.crypto;

import org.bitcoinj.core.NetworkParameters;
import org.bitcoinj.params.MainNetParams;
import org.bitcoinj.params.TestNet3Params;

// TODO : remove from here
public class Constant {

    /**
     * The constant BITCOIN_MAINNET.
     */
    public static final NetworkParameters BITCOIN_MAINNET = MainNetParams.get();

    /**
     * The constant BITCOIN_TESTNET.
     */
    public static final NetworkParameters BITCOIN_TESTNET = TestNet3Params.get();

}
