package com.currency.transaction.Currency.Transaction;

import java.math.BigDecimal;

public class CoinVO {

    private Long id;
    private String name;
    private BigDecimal value;

    public Long getId() {
        return id;
    }

    public CoinVO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public CoinVO setName(String name) {
        this.name = name;
        return this;
    }

    public BigDecimal getValue() {
        return value;
    }

    public CoinVO setValue(BigDecimal value) {
        this.value = value;
        return this;
    }
}
