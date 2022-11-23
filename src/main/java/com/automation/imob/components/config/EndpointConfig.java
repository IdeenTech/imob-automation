package com.automation.imob.components.config;

import com.automation.imob.components.util.JsonUtil;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class EndpointConfig {

    private String url;
    private HashMap<String, Object> headers;
    private HashMap<String, Object> params;
    private HashMap<String, Object> formParams;
    private String body;

    public void addHeaders(String key, Object value) {
        this.getHeaders().put(key, value);
    }

    public void addHeadersAuthToken(String basicToken) {
        addHeaders("Authorization", basicToken);
        addHeaders("Content-Type", "multipart/form-data");
        addHeaders("Accept", "*/*");
    }

    public void addHeadersJson(String accessToken) {
        addHeaders("Authorization", accessToken);
        addHeaders("Content-Type", "application/json");
        addHeaders("Accept", "*/*");
    }

    public void addParams(String key, Object value) {
        this.getParams().put(key, value);
    }

    public void addFormParams(String key, Object value) {
        this.getFormParams().put(key, value);
    }

    public String setJsonFileBody(String pathFileName) throws IOException {
        return JsonUtil.readFileJson(pathFileName);
    }
    public String setJsonFileBodyArray(String pathFileName) throws IOException {
        return JsonUtil.readFileJsonArray(pathFileName);
    }

    public String alterValuesInJsonBody(String pathFileName, Map<String, Object> mapValues) throws IOException {
        JSONObject json = JsonUtil.getJsonValues(pathFileName);
        for(Map.Entry<String, Object> item: mapValues.entrySet()){
            json.put(item.getKey(), item.getValue());
        }
        return json.toString();
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

    public HashMap<String, Object> getFormParams() {
        if (formParams == null) {
            formParams = new HashMap<String, Object>();
        }
        return formParams;
    }


    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
