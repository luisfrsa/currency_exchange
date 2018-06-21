package com.currency.exchange.Currency.Exchange.service.mapper;

import com.currency.exchange.Currency.Exchange.model.Coin;
import com.currency.exchange.Currency.Exchange.model.CoinHistory;
import com.currency.exchange.Currency.Exchange.service.dto.CoinDTO;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-06-21T00:37:35-0300",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_171 (Oracle Corporation)"
)
@Component
public class CoinMapperImpl implements CoinMapper {

    @Override
    public Coin toEntity(CoinDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Coin coin = new Coin();

        coin.setId( dto.getId() );
        coin.setName( dto.getName() );
        coin.setValue( dto.getValue() );
        Set<CoinHistory> set = dto.getCoinHistorySet();
        if ( set != null ) {
            coin.setCoinHistorySet( new HashSet<CoinHistory>( set ) );
        }
        else {
            coin.setCoinHistorySet( null );
        }

        return coin;
    }

    @Override
    public CoinDTO toDto(Coin entity) {
        if ( entity == null ) {
            return null;
        }

        CoinDTO coinDTO = new CoinDTO();

        coinDTO.setId( entity.getId() );
        coinDTO.setName( entity.getName() );
        coinDTO.setValue( entity.getValue() );
        Set<CoinHistory> set = entity.getCoinHistorySet();
        if ( set != null ) {
            coinDTO.setCoinHistorySet( new HashSet<CoinHistory>( set ) );
        }
        else {
            coinDTO.setCoinHistorySet( null );
        }

        return coinDTO;
    }

    @Override
    public List<Coin> toEntity(List<CoinDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Coin> list = new ArrayList<Coin>( dtoList.size() );
        for ( CoinDTO coinDTO : dtoList ) {
            list.add( toEntity( coinDTO ) );
        }

        return list;
    }

    @Override
    public List<CoinDTO> toDto(List<Coin> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<CoinDTO> list = new ArrayList<CoinDTO>( entityList.size() );
        for ( Coin coin : entityList ) {
            list.add( toDto( coin ) );
        }

        return list;
    }
}
