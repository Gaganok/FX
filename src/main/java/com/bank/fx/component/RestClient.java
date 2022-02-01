package com.bank.fx.component;

import com.bank.fx.domain.Price;

/**
 * @author Oleh Kepsha
 */
public interface RestClient {
    boolean sendPrice(Price price);
}
