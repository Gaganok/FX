package com.bank.fx.component.impl;

import com.bank.fx.component.MessagePublisher;
import com.bank.fx.domain.Price;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

/**
 * @author Oleh Kepsha
 */
@Component
@AllArgsConstructor
public class NotMessageConsumer implements Consumer<String> {

    private final MessagePublisher messagePublisher;

    public void processPrice(Price price){
        price.setBid(price.getBid() * 0.99f);
        price.setAsk(price.getAsk() * 1.01f);
    }

    public Price toPrice(String message){
        String[] messageElements = message.split(",");
        Price price = new Price();

        price.setId(Integer.parseInt(messageElements[0]));
        price.setInstrumentName(messageElements[1]);
        price.setBid(Float.parseFloat(messageElements[2]));
        price.setAsk(Float.parseFloat(messageElements[3]));
        price.setTimestamp(messageElements[4]);

        return price;
    }

    public void publishPrice(Price price){
        try {
            messagePublisher.publish(price);
        } catch (Exception exception) {
            //handle exception
        }
    }

    @Override
    public void accept(String message) {
        Price price = toPrice(message);
        processPrice(price);
        publishPrice(price);
    }

}
