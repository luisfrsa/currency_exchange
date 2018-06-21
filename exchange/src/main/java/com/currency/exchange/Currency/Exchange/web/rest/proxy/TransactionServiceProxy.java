package com.currency.exchange.Currency.Exchange.web.rest.proxy;


import com.currency.exchange.Currency.Exchange.model.UserVO;
import com.currency.exchange.Currency.Exchange.service.dto.CoinDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;

@FeignClient(name="transaction")
@RibbonClient(name="transaction")
public interface TransactionServiceProxy {

    @GetMapping("/user/{value}")
    public UserVO getWhatEver(@PathVariable("value") BigDecimal value);

}
