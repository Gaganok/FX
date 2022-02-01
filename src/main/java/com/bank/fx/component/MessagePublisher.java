package com.bank.fx.component;

import com.bank.fx.domain.Price;

/**
 * @author Oleh Kepsha
 */
public interface MessagePublisher {
    void publish(Price price) throws Exception;
}
