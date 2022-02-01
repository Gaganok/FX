package com.bank.fx.component.impl;

import com.bank.fx.domain.Price;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;

/**
 * @author Oleh Kepsha
 */
class MessageConsumerTest {

    private NotMessageConsumer messageConsumer;

    @Spy
    private NotMessagePublisher publisher;

    private final static String testMessage = "106,EUR/USD,1.1000,1.2000,01-06-2020 12:01:01:001";

    @BeforeEach
    void init(){
        MockitoAnnotations.openMocks(this);
        messageConsumer = new NotMessageConsumer(publisher);
    }

    @Test
    void processPriceTest(){
        Price price = new Price();
        price.setBid(10f);
        price.setAsk(10f);

        messageConsumer.processPrice(price);

        Assertions.assertEquals(10.10f, price.getAsk());
        Assertions.assertEquals(9.90f, price.getBid());
    }

    @Test
    void toPriceTest(){
        Price price = messageConsumer.toPrice(testMessage);

        Assertions.assertEquals(106, price.getId());
        Assertions.assertEquals("EUR/USD", price.getInstrumentName());
        Assertions.assertEquals(1.1000f, price.getBid());
        Assertions.assertEquals(1.2000f, price.getAsk());
        Assertions.assertEquals("01-06-2020 12:01:01:001", price.getTimestamp());
    }

    @Test
    void publishTest() throws Exception {
        Mockito.doNothing().when(publisher).publish(any());

        Price price = new Price();
        messageConsumer.publishPrice(price);
        messageConsumer.publishPrice(price);

        Mockito.verify(publisher, times(2)).publish(price);
    }

}
