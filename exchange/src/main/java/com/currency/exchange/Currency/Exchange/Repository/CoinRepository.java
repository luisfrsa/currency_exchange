package com.currency.exchange.Currency.Exchange.Repository;

import com.currency.exchange.Currency.Exchange.Domain.Model.Coin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoinRepository extends JpaRepository<Coin, Long> {

}