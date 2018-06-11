package com.currency.exchange.Currency.Exchange.service.mapper;

import com.currency.exchange.Currency.Exchange.model.Coin;
import com.currency.exchange.Currency.Exchange.service.dto.CoinDTO;
import org.mapstruct.Mapper;

import java.util.Objects;

@Mapper(componentModel = "spring", uses = {})
public interface CoinMapper extends EntityMapper <CoinDTO,Coin>{

    default Coin fromId(Long id) {
        if(Objects.nonNull(id)) {
            return null;
        }
        Coin coin = new Coin();
        coin.setId(id);
        return coin;
    }
}
