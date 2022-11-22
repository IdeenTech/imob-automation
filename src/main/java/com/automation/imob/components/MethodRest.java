package com.automation.imob.components;

import com.automation.imob.components.config.EndpointConfig;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

import static io.restassured.config.EncoderConfig.encoderConfig;

@Slf4j
public class MethodRest {

    public static Response callGet(EndpointConfig endpointConfig) {
        RequestSpecification requestSpecification = createRequest(endpointConfig);
        Response response = requestSpecification.when().get(endpointConfig.getUrl());
        log.info("=== Result: {}, Endpoint: {} ===", response.statusCode(), endpointConfig.getUrl());
        return response;
    }

    public static Response callPut(EndpointConfig endpointConfig) {
        RequestSpecification requestSpecification = createRequest(endpointConfig);
        Response response = requestSpecification.when().put(endpointConfig.getUrl());
        log.info("=== Result: {}, Endpoint: {} ===", response.statusCode(), endpointConfig.getUrl());
        return response;
    }

    public static Response callPost(EndpointConfig endpointConfig) {
        RequestSpecification requestSpecification = createRequest(endpointConfig);
        Response response = requestSpecification.when().post(endpointConfig.getUrl());
        log.info("=== Result: {}, Endpoint: {} ===", response.statusCode(), endpointConfig.getUrl());
        return response;
    }

    public static Response callDelete(EndpointConfig endpointConfig) {
        RequestSpecification requestSpecification = createRequest(endpointConfig);
        Response response = requestSpecification.when().delete(endpointConfig.getUrl());
        log.info("=== Result: {}, Endpoint: {} ===", response.statusCode(), endpointConfig.getUrl());
        return response;
    }

    private static RequestSpecification createRequest(EndpointConfig endpointConfig) {
        RequestSpecification requestSpecification = RestAssured.given()
                .config(RestAssured.config().encoderConfig(encoderConfig().encodeContentTypeAs("multipart/form-data", ContentType.
                        TEXT)));
        createHeaders(endpointConfig, requestSpecification);
        createParams(endpointConfig, requestSpecification);
        createBody(endpointConfig, requestSpecification);
        createMultipartFormParam(endpointConfig, requestSpecification);
        return requestSpecification;
    }

    private static void createBody(EndpointConfig endpointConfig, RequestSpecification requestSpecification) {
        if (endpointConfig.getBody() != null) {
            requestSpecification.body(endpointConfig.getBody());
        }
    }

    private static void createParams(EndpointConfig endpointConfig, RequestSpecification requestSpecification) {
        if (!endpointConfig.getParams().isEmpty()) {
            for (Map.Entry<String, Object> param : endpointConfig.getParams().entrySet()) {
                requestSpecification.param(param.getKey(), param.getValue());
            }
        }
    }

    private static void createMultipartFormParam(EndpointConfig endpointConfig, RequestSpecification requestSpecification) {
        if (!endpointConfig.getFormParams().isEmpty()) {
            for (Map.Entry<String, Object> formParam : endpointConfig.getFormParams().entrySet()) {
                requestSpecification.multiPart(formParam.getKey(), formParam.getValue());
            }
        }
    }

    private static void createHeaders(EndpointConfig endpointConfig, RequestSpecification requestSpecification) {
        if (!endpointConfig.getHeaders().isEmpty()) {
            for (Map.Entry<String, Object> header : endpointConfig.getHeaders().entrySet()) {
                requestSpecification.header(header.getKey(), header.getValue());
            }
        }
    }
}
