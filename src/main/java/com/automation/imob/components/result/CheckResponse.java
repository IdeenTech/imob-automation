package com.automation.imob.components.result;

import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.hamcrest.Matchers;

@Slf4j
public class CheckResponse {

    public static void checkHttpCode(Integer httpCode, Response response) {
        response.then().statusCode(httpCode);
        log.info("HttpCodeResponse: {}, HttpCodeExpected: {}", response.getStatusCode(), httpCode);
    }

    public static void checkValueInJson(String value, String field, Response response) {
        response.then().body(field, Matchers.equalTo(value));
        log.info("ValueExpected: {}, FieldExpected: {}, ResponseBody: {}", value, field, response.getBody());
    }
}
