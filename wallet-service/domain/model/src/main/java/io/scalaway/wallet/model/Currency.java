/*
 * Copyright (c) 2022. Luidgi Gromat
 */

package io.scalaway.wallet.model;

import lombok.Getter;
import lombok.Setter;

/**
 * The enum Currency.
 */
public enum Currency {
    BTC("BTC"),
    BCH("BCH"),
    LTC("LTC"),
    ETH("ETH"),
    XRP("XRP");

    private final String currency;

    Currency(final String currency) {
        this.currency = currency;
    }

    /**
     * Gets currency.
     *
     * @return the currency
     */
    public String getCurrency() {
        return this.currency;
    }
}