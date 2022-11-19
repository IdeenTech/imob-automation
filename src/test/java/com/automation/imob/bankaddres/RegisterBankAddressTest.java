package com.automation.imob.bankaddres;

import com.automation.imob.ImobApplicationTests;
import com.automation.imob.components.MethodRest;
import com.automation.imob.components.config.EndpointConfig;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class RegisterBankAddressTest extends ImobApplicationTests {

    @Test
    public void save() throws IOException {
        EndpointConfig endpointConfig = new EndpointConfig();
        endpointConfig.addHeaders("Authorization", getConfigParams().getBasicToken());
        endpointConfig.addHeaders("Content-Type", "application/json");
        endpointConfig.setUrl(getConfigParams().getHost().concat("/domiciliobancario"));
        endpointConfig.setBody(endpointConfig.setJsonFileBody("json/bankaddres/save.json"));

        Response response = MethodRest.callPost(endpointConfig);
        response.then().statusCode(201);

    }

}
