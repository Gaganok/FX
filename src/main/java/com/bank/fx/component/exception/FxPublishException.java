package com.bank.fx.component.exception;

import lombok.NoArgsConstructor;

/**
 * @author Oleh Kepsha
 */
@NoArgsConstructor
public class FxPublishException extends Exception {
    public FxPublishException(String message) {
        super(message);
    }
}
