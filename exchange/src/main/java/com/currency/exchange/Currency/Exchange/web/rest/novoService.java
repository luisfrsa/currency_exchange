package com.currency.exchange.Currency.Exchange.web.rest;

import com.currency.exchange.Currency.Exchange.model.UserVO;
import com.currency.exchange.Currency.Exchange.repository.CoinRepository;
import com.currency.exchange.Currency.Exchange.service.dto.CoinDTO;
import com.currency.exchange.Currency.Exchange.service.mapper.CoinMapper;
import com.currency.exchange.Currency.Exchange.web.rest.proxy.TransactionServiceProxy;
import com.currency.exchange.Currency.Exchange.web.rest.util.HeaderUtil;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.stream.Collectors;

//@Service change meee
@RestController
public class novoService {
    
    
    @Autowired
    private TransactionServiceProxy proxy;
    @Autowired
    private CoinMapper coinMapper;

    @Autowired
    private CoinRepository coinRepository;

    @GetMapping("/micro/id/{id}")
    public UserVO convertCurrency(@PathVariable String id) {

        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("id", id);

        ResponseEntity<UserVO> responseEntity = new RestTemplate()
                .getForEntity("http://localhost:8000/user/{id}", UserVO.class, uriVariables);

        UserVO user = responseEntity.getBody();
        return user;
    }


    @GetMapping("/micro2/id/{id}")
    public UserVO convertCurrencyFeign(@PathVariable BigDecimal id)  {

        UserVO response = proxy.getWhatEver(id);
        return response;
    }

    @GetMapping("/findone")
    public ResponseEntity<LinkedList<CoinDTO>> findAll() throws URISyntaxException {

        return ResponseEntity
                .created(new URI("/api/coins/" ))
                .body(coinRepository.findAll().stream().map(coinMapper::toDto).collect(Collectors.toCollection(LinkedList::new)));
    }
}

