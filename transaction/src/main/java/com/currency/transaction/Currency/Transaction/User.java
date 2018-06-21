package com.currency.transaction.Currency.Transaction;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
@Entity(name = "user")
@Table(name = "user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotBlank
    private String name;

    @Transient
    private List<CoinVO> coins;

    private String port;

    public Long getId() {
        return id;
    }

    public User setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }


    public String getPort() {
        return port;
    }

    public User setPort(String port) {
        this.port = port;
        return this;
    }

    public List<CoinVO> getCoins() {
        return coins;
    }

    public User setCoins(List<CoinVO> coins) {
        this.coins = coins;
        return this;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
}
