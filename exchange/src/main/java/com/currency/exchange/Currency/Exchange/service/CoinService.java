package com.currency.exchange.Currency.Exchange.service;

import com.currency.exchange.Currency.Exchange.service.dto.CoinDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;


public interface CoinService {
    /*
    * Use for maintance as new DB, Elastic, and fast new impl
    * */
    public CoinDTO persist(CoinDTO coinDTO);

    public CoinDTO save(CoinDTO coinDTO);

    public CoinDTO update(CoinDTO coinDTO);

    public LinkedList<CoinDTO> findAll();

}
