package com.currency.exchange.Currency.Exchange.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;
import java.util.Set;


@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},allowGetters = true)
@Entity(name="coin")
@Table(name = "coin")
public class Coin implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotBlank
    private String name;

    @NotNull
    @Column(name = "value", precision=10, scale=2, nullable = false)
    private BigDecimal value;

    @OneToMany
    private Set<CoinHistory> coinHistorySet;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public static class CoinBuilder {

        private final String name;
        private BigDecimal value;
        private Set<CoinHistory> coinHistorySet;


        public CoinBuilder(String name) {
            if(Objects.isNull(name)){
                throw new IllegalArgumentException("Coin name can not be null");
            }
            this.name = name;
        }

        public CoinBuilder setValue(BigDecimal value) {
            this.value = value;
            return this;
        }

        public CoinBuilder setCoinHistorySet(Set<CoinHistory> coinHistorySet) {
            this.coinHistorySet = coinHistorySet;
            return this;
        }
    }

}
