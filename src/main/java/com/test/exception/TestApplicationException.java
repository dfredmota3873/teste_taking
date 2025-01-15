package com.test.exception;

import java.io.Serializable;

public class TestApplicationException extends Exception implements Serializable
{
    private static final long serialVersionUID = 1L;

    public TestApplicationException() {
        super();
    }
    public TestApplicationException(String msg) {
        super(msg);
    }
    public TestApplicationException(String msg, Exception e)  {
        super(msg, e);
    }
}
