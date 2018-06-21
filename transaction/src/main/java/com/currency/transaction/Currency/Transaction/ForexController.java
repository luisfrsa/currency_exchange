package com.currency.transaction.Currency.Transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Arrays;

@RestController
public class ForexController {

    @Autowired
    private Environment environment;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user/{value}")
    public User getWhatEver(@PathVariable BigDecimal value) {
        User user = new User();
        user.setName("Unknown");
        user.setCoins(Arrays.asList(new CoinVO().setName("Random name").setValue(value)));
        user.setPort(environment.getProperty("local.server.port"));
        return user;
    }
}