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

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.lang.String.format;


@Service
@Transactional
public class CoinService {

    private static final Logger log = LoggerFactory.getLogger(CoinService.class);
    private static final String REQUEST_SAVE = "Request for save Coin with id";
    private static final String REQUEST_UPDATE = "Request for update Coin with id %s";
    private static final String PERSIST_REQUESTED_WITH_NULL_OBJECT = "Persist requested with null object";

    @Autowired
    private CoinMapper coinMapper;

    @Autowired
    private CoinRepository coinRepository;


    @Transactional(readOnly = true)
    public CoinDTO findOne(Long id) {
        Coin coin = coinRepository.getOne(id);
        return coinMapper.toDto(coin);
    }

    @Transactional(readOnly = true)
    public List<CoinDTO> findAll() {
        return coinRepository.findAll()
                .stream()
                .map(coinMapper::toDto)
                .collect(Collectors.toCollection(LinkedList::new));

    }

    public CoinDTO persist(CoinDTO coinDTO) {
        if (Objects.isNull(coinDTO)) {
            throw new ApplicationServiceException(PERSIST_REQUESTED_WITH_NULL_OBJECT, HttpStatus.PRECONDITION_FAILED);
        }
        if (coinDTO.getId() > 0) {
            return save(coinDTO);
        }
        return update(coinDTO);
    }

    public CoinDTO save(CoinDTO coinDTO) {
        String stringDebug = format(REQUEST_SAVE);
        log.debug(stringDebug);
        Coin coin = coinMapper.toEntity(coinDTO);
        return coinMapper.toDto(coinRepository.save(coin));
    }

    public CoinDTO update(CoinDTO coinDTO) {
        String stringDebug = format(REQUEST_UPDATE, coinDTO.getId());
        log.debug(stringDebug);
        Coin coin = coinMapper.toEntity(coinDTO);
        return coinMapper.toDto(coinRepository.save(coin));
    }

    public void delete(Long id) {
        Coin coin = coinRepository.getOne(id);
        if(Objects.isNull(coin)){
            throw new ApplicationServiceException("Could not delete the user. Reason: user not found ",HttpStatus.PRECONDITION_FAILED);
        }
        coinRepository.deleteById(coin.getId());
    }

    public void delete(CoinDTO coinDTO) {
        coinRepository.deleteById(coinDTO.getId());
    }


}
