package com.example.redbook.payload;

import java.time.LocalDateTime;
import java.util.Date;

public class ErrorDetail {
    private Date timestamp;
    private String error;

    public ErrorDetail(Date timestamp, String error, String trace) {
        this.timestamp = timestamp;
        this.error = error;
        this.trace = trace;
    }

    private String trace;

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getTrace() {
        return trace;
    }

    public void setTrace(String trace) {
        this.trace = trace;
    }
}
