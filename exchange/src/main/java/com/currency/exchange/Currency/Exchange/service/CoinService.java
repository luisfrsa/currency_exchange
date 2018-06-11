package com.currency.exchange.Currency.Exchange.service;

import com.currency.exchange.Currency.Exchange.exception.ApplicationServiceException;
import com.currency.exchange.Currency.Exchange.model.Coin;
import com.currency.exchange.Currency.Exchange.repository.CoinRepository;
import com.currency.exchange.Currency.Exchange.service.dto.CoinDTO;
import com.currency.exchange.Currency.Exchange.service.mapper.CoinMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@Transactional
public class CoinService {

    private static final Logger log = LoggerFactory.getLogger(CoinService.class);
    private static final String REQUEST_SAVE = "Request for save Coin with id";
    private static final String REQUEST_UPDATE = "Request for update Coin with id %s";

    @Autowired
    private CoinMapper coinMapper;

    @Autowired
    private CoinRepository coinRepository;


    public CoinDTO persist(CoinDTO coinDTO) {
        if(Objects.isNull(coinDTO)){
            throw new ApplicationServiceException("Persist request with null object",HttpStatus.PRECONDITION_FAILED);
        }
        if(coinDTO.getId() > 0){
            return save(coinDTO);
        }
        return update(coinDTO);
    }

    public CoinDTO save(CoinDTO coinDTO) {
        String stringDebug = String.format(REQUEST_SAVE);
        log.debug(stringDebug);
        Coin coin = coinMapper.toEntity(coinDTO);
        return coinMapper.toDto(coinRepository.save(coin));
    }

    public CoinDTO update(CoinDTO coinDTO) {
        String stringDebug = String.format(REQUEST_UPDATE, coinDTO.getId());
        log.debug(stringDebug);
        Coin coin = coinMapper.toEntity(coinDTO);
        return coinMapper.toDto(coinRepository.save(coin));
    }

}
