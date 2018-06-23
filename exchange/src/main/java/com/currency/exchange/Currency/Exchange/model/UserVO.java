package com.currency.exchange.Currency.Exchange.model;

import java.math.BigDecimal;
import java.util.List;

public class UserVO {


    private Long id;
    private String name;
    private String login;
    private String password;
    private BigDecimal money;
    private String port;
    private List<Coin> coins;

    public Long getId() {
        return id;
    }

    public UserVO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public UserVO setName(String name) {
        this.name = name;
        return this;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public UserVO setMoney(BigDecimal money) {
        this.money = money;
        return this;
    }

    public String getPort() {
        return port;
    }

    public UserVO setPort(String port) {
        this.port = port;
        return this;
    }

    public List<Coin> getCoins() {
        return coins;
    }

    public String getPassword() {
        return password;
    }

    public UserVO setPassword(String password) {
        this.password = password;
        return this;
    }

    public UserVO setCoins(List<Coin> coins) {
        this.coins = coins;
        return this;
    }

    public String getLogin() {
        return login;
    }

    public UserVO setLogin(String login) {
        this.login = login;
        return this;
    }
}
