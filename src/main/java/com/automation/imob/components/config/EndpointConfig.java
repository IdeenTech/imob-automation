package com.automation.imob.components.config;

import com.automation.imob.components.util.JsonUtil;

import java.io.IOException;
import java.util.HashMap;

public class EndpointConfig {

    private String url;
    private HashMap<String, Object> headers;
    private HashMap<String, Object> params;
    private String body;

    public void addHeaders(String key, Object value) {
        this.getHeaders().put(key, value);
    }

    public void addParams(String key, Object value) {
        this.getParams().put(key, value);
    }

    public String setJsonFileBody(String pathFileName) throws IOException {
        return JsonUtil.readFileJson(pathFileName);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public HashMap<String, Object> getHeaders() {
        if (headers == null) {
            headers = new HashMap<String, Object>();
        }
        return headers;
    }

    public HashMap<String, Object> getParams() {
        if (params == null) {
            params = new HashMap<String, Object>();
        }
        return params;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
