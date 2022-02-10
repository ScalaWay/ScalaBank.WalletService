/*
 * Copyright (c) 2022. Luidgi Gromat
 */

package io.scalaway.walletservice.crypto;

import org.bitcoinj.crypto.MnemonicCode;

import java.security.SecureRandom;
import java.util.List;

public class CryptoUtil {

    private CryptoUtil(){}

    static final int DEFAULT_ENTROPY_BITS = 256;

    /**
     * Generate a random seed of 24 words (256bytes).
     * @return
     * @throws Exception
     */
    public static List<String> generateMnemonic() throws Exception {
        byte[] entropy = generateEntropy();
        MnemonicCode mnemonicCode = new MnemonicCode();
        List<String> mnemonic = mnemonicCode.toMnemonic(entropy);
        return mnemonic;
    }

    private static byte[] generateEntropy() {
        SecureRandom random = new SecureRandom();
        byte[] entropy = new byte[DEFAULT_ENTROPY_BITS / 8];
        random.nextBytes(entropy);
        return entropy;
    }
}
