/*******************************************************************************
 * Copyright 2017, Anoop Issac <samnoah>, All rights reserved.
 ******************************************************************************/
package com.java.docker.test.util.httpclient;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class HttpGetUtilities {
    private static final Logger logger = LoggerFactory.getLogger(HttpGetUtilities.class);

    private static void addRequestHeaders(HttpGet httpGet, HashMap<String, String> requestHeaders,
                                          HttpclientLogger httpclientLogger) {
        httpclientLogger.info("request headers size>>" + ResourceUtilities.sizeOf(requestHeaders));
        if (ResourceUtilities.isEmpty(requestHeaders)) {
            return;
        }
        for (Map.Entry<String, String> entry : requestHeaders.entrySet()) {
            httpGet.setHeader(entry.getKey(), entry.getValue());
        }
    }

    public static HttpclientResult GET(String url, HashMap<String, String> requestHeaders) {
        HttpclientResult httpclientResult = new HttpclientResult();
        HttpclientLogger httpclientLogger = new HttpclientLogger();
        CloseableHttpClient closeableHttpClient = null;
        CloseableHttpResponse closeableHttpResponse = null;
        try {
            httpclientLogger.info("GET>>"+(url));
            closeableHttpClient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet(url);
            addRequestHeaders(httpGet, requestHeaders, httpclientLogger);
            closeableHttpResponse = closeableHttpClient.execute(httpGet);
            int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
            String reasonPhrase = closeableHttpResponse.getStatusLine().getReasonPhrase();
            httpclientLogger.info("statusCode>>" + statusCode + ">>" + reasonPhrase);
            httpclientResult.setStatusCode(statusCode);
            httpclientResult.setReasonPhrase(reasonPhrase);
            httpclientResult.addHeaders(closeableHttpResponse.getAllHeaders());
            byte[] responseBody = ResourceUtilities.getResponseBody(closeableHttpResponse,
                    httpclientResult.getHeaderValue("Content-Encoding"));
            httpclientResult.setResponse(responseBody);
            httpclientLogger.info("isResponse>>" + httpclientResult.isResponse());
        } catch (Exception e) {
            httpclientResult.setException(e);
            logger.error("GET>>", e);
            httpclientLogger.error(e);
        } finally {
            ResourceUtilities.closeCloseableHttpResponse(closeableHttpResponse);
            ResourceUtilities.closeCloseableHttpClient(closeableHttpClient);
            httpclientLogger.log();
        }
        return httpclientResult;
    }

    public static HttpclientResult GET(String url) {
        HttpclientResult httpclientResult = new HttpclientResult();
        HttpclientLogger httpclientLogger = new HttpclientLogger();
        CloseableHttpClient closeableHttpClient = null;
        CloseableHttpResponse closeableHttpResponse = null;
        try {
            httpclientLogger.info("GET>>"+(url));
            closeableHttpClient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet(url);
            closeableHttpResponse = closeableHttpClient.execute(httpGet);
            int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
            String reasonPhrase = closeableHttpResponse.getStatusLine().getReasonPhrase();
            httpclientLogger.info("statusCode>>" + statusCode + ">>" + reasonPhrase);
            httpclientResult.setStatusCode(statusCode);
            httpclientResult.setReasonPhrase(reasonPhrase);
            httpclientResult.addHeaders(closeableHttpResponse.getAllHeaders());
            byte[] responseBody = ResourceUtilities.getResponseBody(closeableHttpResponse,
                    httpclientResult.getHeaderValue("Content-Encoding"));
            httpclientResult.setResponse(responseBody);
            httpclientLogger.info("isResponse>>" + httpclientResult.isResponse());
        } catch (Exception e) {
            httpclientResult.setException(e);
            logger.error("GET>>", e);
            httpclientLogger.error(e);
        } finally {
            ResourceUtilities.closeCloseableHttpResponse(closeableHttpResponse);
            ResourceUtilities.closeCloseableHttpClient(closeableHttpClient);
            httpclientLogger.log();
        }
        return httpclientResult;
    }
}
