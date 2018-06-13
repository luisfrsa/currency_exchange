package com.currency.exchange.Currency.Exchange.web.rest;


import com.currency.exchange.Currency.Exchange.exception.ApplicationResourceException;
import com.currency.exchange.Currency.Exchange.service.CoinService;
import com.currency.exchange.Currency.Exchange.service.dto.CoinDTO;
import com.currency.exchange.Currency.Exchange.web.rest.util.HeaderUtil;
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

import static java.lang.String.format;

@RestController
@RequestMapping("/api")
public class CoinResource {

    private final Logger log = LoggerFactory.getLogger(CoinResource.class);

    private static final String ENTITY_NAME = "coin";

    public static final String REST_REQUEST_FOR_SAVE = "REST request for save "+ENTITY_NAME+" %s";
    public static final String CANNOT_CREATE_WITH_ID = "A new "+ENTITY_NAME+" cannot already have an ID %d";


    @Autowired
    private CoinService coinService;


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


    @GetMapping("/coin")
    public ResponseEntity<LinkedList<CoinDTO>> findAll() throws URISyntaxException {

        return ResponseEntity
                .created(new URI("/api/coins/" ))
                .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, "a"))
                .body(coinService.findAll());
    }
}
