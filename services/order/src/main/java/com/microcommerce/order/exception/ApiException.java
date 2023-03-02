package com.microcommerce.order.exception;

import java.text.MessageFormat;

public class ApiException extends RuntimeException {
    public ApiException(String message) {
        super(message);
    }

    public ApiException(String format, Object... args) {
        super(MessageFormat.format(format, args));
    }

}
