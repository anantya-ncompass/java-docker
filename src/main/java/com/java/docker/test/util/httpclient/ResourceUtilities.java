/*******************************************************************************
 * Copyright 2017, Anoop Issac <samnoah>, All rights reserved.
 ******************************************************************************/
package com.java.docker.test.util.httpclient;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.impl.client.CloseableHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.zip.GZIPInputStream;

/*
 * @author anoopi
 * @date Feb 24, 2017
 * @company samnoah
 */
public class ResourceUtilities {
    private static final Logger logger = LoggerFactory.getLogger(ResourceUtilities.class);

    public static boolean isEmpty(Object value) {
        return value == null || value.toString().equals("");
    }

    public static boolean isEmpty(Map<?, ?> map) {
        if (map == null) {
            return true;
        }
        return map.isEmpty();
    }


    public static int sizeOf(Map<?, ?> map) {
        if (map == null) {
            return 0;
        }
        return map.size();
    }


    public static String byteToString(byte[] b) {

        if (b == null || b.length == 0) {
            return null;
        }

        return new String(b, StandardCharsets.UTF_8);
    }

    public static boolean isEmpty(String value) {
        return value == null || value.equals("");
    }


    public static String getErrorMessage(Exception e) {
        if (e == null) {
            return "Internal error.";
        }

        String message = e.getMessage();
        if (isEmpty(message)) {
            return e.getClass().getSimpleName() + ": Internal error.";
        }
        return message;
    }


    public static void closeCloseable(Closeable cl) {
        try {
            if (cl != null)
                cl.close();
        } catch (Exception e) {
            logger.error("closeCloseable>>", e);
        }
    }

    public static void closeHttpURLConnection(HttpURLConnection huc) {
        try {
            if (huc != null)
                huc.disconnect();
        } catch (Exception e) {
            logger.error("closeHttpURLConnection>>", e);
        }
    }


    public static byte[] getResponseBody(HttpResponse httpResponse, String ContentEncoding)
            throws IllegalStateException, IOException {
        if (httpResponse == null) {
            return null;
        }
        HttpEntity he = httpResponse.getEntity();
        if (he == null) {
            return null;
        }
        InputStream is = null;
        GZIPInputStream gzis = null;
        try {
            is = he.getContent();
            if ("gzip".equals(ContentEncoding)) {
                gzis = new GZIPInputStream(is);
                return IOUtils.toByteArray(gzis);
            } else {
                return IOUtils.toByteArray(is);
            }
        } catch (Exception e) {
            logger.error("getResponseBodyException>>", e);
        } finally {
            ResourceUtilities.closeCloseable(is);
            ResourceUtilities.closeCloseable(gzis);
        }
        return null;
    }

    public static void closeCloseableHttpClient(CloseableHttpClient closeableHttpClient) {
        try {
            if (closeableHttpClient != null) {
                closeableHttpClient.close();
            }
        } catch (Exception e) {
            logger.error("closeCloseableHttpClientException>>", e);
        }
    }

    public static void closeCloseableHttpResponse(CloseableHttpResponse closeableHttpResponse) {
        try {
            if (closeableHttpResponse != null) {
                closeableHttpResponse.close();
            }
        } catch (Exception e) {
            logger.error("closeCloseableHttpResponseException>>", e);
        }
    }


}
