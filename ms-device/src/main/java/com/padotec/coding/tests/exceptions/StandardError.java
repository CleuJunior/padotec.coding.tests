package com.padotec.coding.tests.exceptions;

import java.io.Serializable;
import java.time.Instant;

public class StandardError implements Serializable {
    private static final long serialVersionUID = 1L;

    private final Instant timestamp;
    private final Integer status;
    private final String error;
    private final String path;

    private StandardError(Instant timestamp, Integer status, String error, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.path = path;
    }

    public static StandardError of(Instant timestamp, Integer status, String error, String path) {
        return new StandardError(timestamp, status, error, path);
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public Integer getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public String getPath() {
        return path;
    }
}
