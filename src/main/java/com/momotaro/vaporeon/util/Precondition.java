package com.momotaro.vaporeon.util;

import org.springframework.http.HttpStatus;

public final class Precondition {
    private Precondition() {
    }

    public static void checkArgument(boolean condition, String errorMessage) {
        if (!condition) {
            throw new ApplicationException(errorMessage);
        }
    }

    public static void checkArgument(boolean condition, String errorCode, String errorMessage) {
        if (!condition) {
            throw new ApplicationException(errorCode, errorMessage);
        }
    }

    public static void checkArgument(boolean condition, HttpStatus httpStatus, String errorCode,
                                     String errorMessage) {
        if (!condition) {
            throw new ApplicationException(httpStatus, errorCode, errorMessage);
        }
    }
}
