package com.bank.fx.component.impl;

import com.bank.fx.component.MessagePublisher;
import com.bank.fx.component.RestClient;
import com.bank.fx.component.exception.FxPublishException;
import com.bank.fx.domain.Price;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Oleh Kepsha
 */
@Slf4j
@Component
@NoArgsConstructor
@AllArgsConstructor
public class NotMessagePublisher implements MessagePublisher {

    @Autowired
    private RestClient restClient;

    @Override
    public void publish(Price price) throws Exception {
        if(!restClient.sendPrice(price)){
            //Do a retry || circuit break || throw exception
            throw new FxPublishException("Price publishing failed");
        }
    }
}
