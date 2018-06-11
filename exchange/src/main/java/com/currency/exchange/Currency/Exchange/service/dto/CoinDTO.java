package com.currency.exchange.Currency.Exchange.service.dto;

import com.currency.exchange.Currency.Exchange.model.CoinHistory;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

public class CoinDTO {
    private Long id;

    private String name;
    private BigDecimal value;
    private Set<CoinHistory> coinHistorySet;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public Set<CoinHistory> getCoinHistorySet() {
        return coinHistorySet;
    }

    public void setCoinHistorySet(Set<CoinHistory> coinHistorySet) {
        this.coinHistorySet = coinHistorySet;
    }
}
