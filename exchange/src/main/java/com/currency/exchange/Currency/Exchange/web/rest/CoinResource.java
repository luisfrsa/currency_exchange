package com.currency.exchange.Currency.Exchange.web.rest;


import com.currency.exchange.Currency.Exchange.exception.ApplicationResourceException;
import com.currency.exchange.Currency.Exchange.service.CoinService;
import com.currency.exchange.Currency.Exchange.service.dto.CoinDTO;
import com.currency.exchange.Currency.Exchange.web.rest.util.HeaderUtil;
import com.currency.exchange.Currency.Exchange.web.rest.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import static java.lang.String.format;

@RestController
@RequestMapping("/api")
public class CoinResource {

    private static final String ENTITY_NAME = "coin";


    public static final String REST_REQUEST_TO_GET_ALL = "REST request to get all "+ENTITY_NAME;
    public static final String REST_REQUEST_TO_GET_ONE = "REST request to get one " +ENTITY_NAME + " by id %d";
    private final Logger log = LoggerFactory.getLogger(CoinResource.class);


    public static final String REST_REQUEST_FOR_SAVE = "REST request for save "+ENTITY_NAME+" %s";
    public static final String REST_REQUEST_FOR_UPDATE = "REST request for save "+ENTITY_NAME+" %s";
    public static final String CANNOT_CREATE_WITH_ID = "A new "+ENTITY_NAME+" cannot already have an ID %d";


    @Autowired
    private CoinService coinService;

    @GetMapping("/coin/{id}")
    public ResponseEntity<CoinDTO> findOne(@PathVariable Long id)  {
        log.debug(format(REST_REQUEST_TO_GET_ONE,id));
        CoinDTO coinDTO = coinService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(coinDTO));
    }


    @GetMapping("/coin")
    public ResponseEntity<List<CoinDTO>> findAll()  {
        log.debug(REST_REQUEST_TO_GET_ALL);
        List<CoinDTO> listCoinDTO = coinService.findAll();
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(listCoinDTO));
    }


    @PostMapping("/coin")
    public ResponseEntity<CoinDTO> createCoin(@Valid @RequestBody CoinDTO coinDTO) throws URISyntaxException {
        String strLog = format(REST_REQUEST_FOR_SAVE, coinDTO.getId());
        log.debug(strLog);
        if (coinDTO.getId() != null) {
            throw new ApplicationResourceException(format(CANNOT_CREATE_WITH_ID,coinDTO.getId()), HttpStatus.BAD_REQUEST);
        }
        CoinDTO result = coinService.save(coinDTO);
        return ResponseEntity
                .created(new URI("/api/coins/" + result.getId()))
                .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
                .body(result);
    }

    @PutMapping("/coin")
    public ResponseEntity<CoinDTO> updateCoin(@Valid @RequestBody CoinDTO coinDTO) {
        String strLog = format(REST_REQUEST_FOR_UPDATE, coinDTO.getId());
        log.debug(strLog);
        CoinDTO result = coinService.save(coinDTO);
        return ResponseEntity.ok()
                .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, result.getId().toString()))
                .body(result);
    }


}
