/*******************************************************************************
 * Copyright 2017, Anoop Issac <samnoah>, All rights reserved.
 ******************************************************************************/
package com.java.docker.test.util.httpclient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class HttpclientLogger {
    private static final Logger logger = LoggerFactory.getLogger(HttpclientLogger.class);
    private final StringBuilder sb;
    long start = 0l;

    public HttpclientLogger() {
        sb = new StringBuilder();

    }

    public void error(Exception e) {
        if (logger.isInfoEnabled()) {
            info("Exception>>"+(ResourceUtilities.getErrorMessage(e)));
        }
    }

    public void info(String value) {
        if (logger.isInfoEnabled()) {
            sb.append("\n").append(value);
        }
    }

    public void log() {
        logger.info(sb.toString());
    }
}
