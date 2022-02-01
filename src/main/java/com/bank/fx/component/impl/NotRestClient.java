package com.bank.fx.component.impl;

import com.bank.fx.component.RestClient;
import com.bank.fx.domain.Price;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author Oleh Kepsha
 */
@Component
@Slf4j
public class NotRestClient implements RestClient {
    @Override
    public boolean sendPrice(Price price) {
        log.info("POST: localhost:7777/api/price :: Price Id: " + price.getId());
        return true;
    }
}
