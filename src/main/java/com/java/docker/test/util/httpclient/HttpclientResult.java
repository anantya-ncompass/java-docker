/*******************************************************************************
 * Copyright 2017, Anoop Issac <samnoah>, All rights reserved.
 ******************************************************************************/
package com.java.docker.test.util.httpclient;

import org.apache.http.Header;

import java.util.HashMap;
import java.util.Map;

public class HttpclientResult {
    private Exception exception;
    private int statusCode;
    private byte[] response;
    private String reasonPhrase;
    private Map<String, String> headers;

    public void addHeaders(Header[] hs) {
        if (hs == null) {
            return;
        }
        headers = new HashMap<String, String>();
        for (Header header : hs) {
            headers.put(header.getName(), header.getValue());
        }
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public String getHeaderValue(String headerName) {
        if (headers == null) {
            return null;
        }
        return headers.get(headerName);
    }

    public String getReasonPhrase() {
        return reasonPhrase;
    }

    public void setReasonPhrase(String reasonPhrase) {
        this.reasonPhrase = reasonPhrase;
    }

    public byte[] getResponse() {
        return response;
    }

    public boolean isResponse() {
        return response != null && response.length != 0;
    }

    public void setResponse(byte[] response) {
        this.response = response;
    }

    public String getResponseString() {
        return ResourceUtilities.byteToString(response);
    }

    @SuppressWarnings("unchecked")
    public HashMap<String, Object> getResponseMap() {
        return JacksonUtilities.readValue(response, HashMap.class);

    }

    public boolean is100xx() {
        return statusCode >= 100 && statusCode <= 199;
    }

    public boolean is200xx() {
        return statusCode >= 200 && statusCode <= 299;
    }

    public boolean is300xx() {
        return statusCode >= 300 && statusCode <= 399;
    }

    public boolean is400xx() {
        return statusCode >= 400 && statusCode <= 499;
    }

    public boolean is500xx() {
        return statusCode >= 500 && statusCode <= 599;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }

    public boolean isSuccess() {
        return exception == null;
    }

    public boolean isSuccessN200xx() {
        return isSuccess() && is200xx();
    }

    public String getErrorMessage() {
        if (exception != null) {
            return ResourceUtilities.getErrorMessage(exception);
        }
        return "";
    }
}
