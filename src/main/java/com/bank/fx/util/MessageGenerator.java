package com.bank.fx.util;

import lombok.experimental.UtilityClass;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

/**
 * @author Oleh Kepsha
 */
@UtilityClass
public class MessageGenerator {

    private final Pair[] PAIRS = {
            new Pair("EUR/USD", 1.1000f),
            new Pair("GBP/USD", 1.2500f),
            new Pair("EUR/JPY", 119.61f)
    };

    private final int MAX_RANGE = 20;
    private final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern( "dd-MM-yyyy HH:mm:ss:SSS");

    private final Random random = new Random();


    public String generate(Integer id){
        Pair pair = PAIRS[random.nextInt(PAIRS.length)];
        float randomRangeModifier = (float) (random.nextInt(MAX_RANGE)) / 100;
        Float bid = pair.range - randomRangeModifier;
        Float ask = pair.range + randomRangeModifier;

        return id + "," + pair.instrument + "," + bid + "," + ask + "," + getTimestamp();
    }

    private String getTimestamp(){
        return dateFormat.format(ZonedDateTime.now());
    }

    private static class Pair {

        public final String instrument;
        public final Float range;

        Pair(String instrument, Float range){
            this.instrument = instrument;
            this.range = range;
        }
    }
}
