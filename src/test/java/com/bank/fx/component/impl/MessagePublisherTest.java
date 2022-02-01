package com.bank.fx.component.impl;

import com.bank.fx.component.RestClient;
import com.bank.fx.component.exception.FxPublishException;
import com.bank.fx.domain.Price;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;

/**
 * @author Oleh Kepsha
 */
class MessagePublisherTest {

    private NotMessagePublisher publisher;

    @Mock
    private RestClient restClient;

    @BeforeEach
    void init(){
        MockitoAnnotations.openMocks(this);
        publisher = new NotMessagePublisher(restClient);
    }

    @Test
    void publishFailTest() throws Exception {
        Mockito.when(restClient.sendPrice(any())).thenReturn(false);
        Assertions.assertThrowsExactly(FxPublishException.class, () -> publisher.publish(new Price()));
    }
}
