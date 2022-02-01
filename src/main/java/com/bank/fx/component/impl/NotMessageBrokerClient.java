package com.bank.fx.component.impl;

import com.bank.fx.component.MessageBrokerClient;
import com.bank.fx.util.MessageGenerator;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

/**
 * @author Oleh Kepsha
 */
@Component
public class NotMessageBrokerClient implements MessageBrokerClient<String> {

    @Override
    public void subscribe(Consumer<String> messageConsumer) {
        for (int i = 0; i < 5; ++i)
            messageConsumer.accept(MessageGenerator.generate(i));
    }

}
