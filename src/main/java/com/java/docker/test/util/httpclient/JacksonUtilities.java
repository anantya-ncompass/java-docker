/*******************************************************************************
 * Copyright 2017, Anoop Issac <samnoah>, All rights reserved.
 ******************************************************************************/

package com.java.docker.test.util.httpclient;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class JacksonUtilities {

    private static final Logger logger = LoggerFactory.getLogger(JacksonUtilities.class);

    private static final ObjectMapper objectMapper;

    static {
        objectMapper = new ObjectMapper();
        logger.info("build single instance of objectmapper successfully");

    }

    public static String writeValueAsStringWithoutFormatting(Object object) {

        if (ResourceUtilities.isEmpty(object)) {
            return null;
        }

        try {

            return objectMapper.writeValueAsString(object);

        } catch (IOException e) {

            logger.error("writeValueAsStringWithoutFormatting>>{}", object, e);

        }

        return null;

    }

    public static String writeValueAsString(Object object) {

        if (ResourceUtilities.isEmpty(object)) {
            return null;
        }

        try {

            ObjectWriter objectWriter = objectMapper.writerWithDefaultPrettyPrinter();
            return objectWriter.writeValueAsString(object);

        } catch (IOException e) {

            logger.error("writeValueAsString>>{}", object, e);

        }

        return null;

    }

    public static <T> T readValue(String jsonText, Class<T> valueType) {
        if (ResourceUtilities.isEmpty(jsonText)) {
            return null;
        }

        try {

            ObjectReader objectReader = objectMapper.readerFor(valueType);
            return objectReader.readValue(jsonText);

        } catch (IOException e) {

            logger.error("readValue>>{}", jsonText, e);

        }

        return null;

    }

    public static <T> T readValue(byte[] jsonBytes, Class<T> valueType) {
        if (jsonBytes == null || jsonBytes.length < 1) {
            return null;
        }

        try {

            ObjectReader objectReader = objectMapper.readerFor(valueType);
            return objectReader.readValue(jsonBytes);

        } catch (IOException e) {

            logger.error("readValue>>{}", jsonBytes, e);

        }

        return null;

    }

}
