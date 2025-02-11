package com.flink.test.exception;

public class LocationNotFoundException extends RuntimeException {
    public LocationNotFoundException(String reason) {
        super(reason);
    }
}
