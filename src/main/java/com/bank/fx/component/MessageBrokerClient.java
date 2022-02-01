package com.bank.fx.component;

import java.util.function.Consumer;

/**
 * @author Oleh Kepsha
 */
public interface MessageBrokerClient <T> {
    void subscribe(Consumer<T> messageConsumer);
}
