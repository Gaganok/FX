package com.bank.fx.component.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;

/**
 * @author Oleh Kepsha
 */
public class MessageBrokerTest {

    private final NotMessageBrokerClient underTest = new NotMessageBrokerClient();

    @Mock
    private NotMessageConsumer notMessageConsumer;


    @BeforeEach
    void init(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void subscribeTest(){
        Mockito.doNothing().when(notMessageConsumer).accept(any());
        underTest.subscribe(notMessageConsumer);
        Mockito.verify(notMessageConsumer, Mockito.times(5)).accept(any());
    }
}
