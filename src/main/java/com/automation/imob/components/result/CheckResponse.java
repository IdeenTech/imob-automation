package com.automation.imob.components.result;

import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
public class CheckResponse {

    public static void checkHttpCode(Integer httpCode, Response response) {
        log.info("HttpCodeResponse: {}, HttpCodeExpected: {}", response.getStatusCode(), httpCode);
        response.then().statusCode(httpCode);
    }

    public static void checkTextInJson(String text, Response response) {
        log.info("TextExpected: {}, ResponseBody: {}", text,  response.getBody().asString());
        assertTrue(response.getBody().asString().contains(text));
    }
}
