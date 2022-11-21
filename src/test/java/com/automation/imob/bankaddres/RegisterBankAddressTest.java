package com.automation.imob.bankaddres;

import com.automation.imob.ImobApplicationTests;
import com.automation.imob.components.MethodRest;
import com.automation.imob.components.config.EndpointConfig;
import com.automation.imob.components.result.CheckResponse;
import com.automation.imob.config.ImobFileJson;
import com.automation.imob.config.ImobPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class RegisterBankAddressTest extends ImobApplicationTests {

    private static String accessToken;

    @BeforeAll
    public static void authentication(){
        EndpointConfig endpointConfig = new EndpointConfig();
        endpointConfig.addHeadersAuthToken("Basic OTg0MDE0NzIwMDAxNTA6ZmUzNTExZDMtMjliNS00MTE2LWExMDQtMzI2ZTUyZmE5MDA3");

        endpointConfig.setUrl("https://cad-stg.cerc.inf.br/oauth/token");
        Response response = MethodRest.callPost(endpointConfig);
        response.then().statusCode(200);

        accessToken = response.getBody().jsonPath().get("access_token");
    }
    @Test
    public void save() throws IOException {
        // Create Request
        EndpointConfig endpointConfig = new EndpointConfig();
        endpointConfig.addHeadersJson(accessToken);
        endpointConfig.setUrl(getConfigParams().getHost().concat(ImobPath.PATH_BANK_ADDRESS));
        endpointConfig.setBody(endpointConfig.setJsonFileBody(ImobFileJson.PATH_JSON_BANK_ADDRESS_SAVE));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkHttpCode(201, response);
    }

    @Test
    public void rn004_111001() throws IOException {
        // Create Request
        EndpointConfig endpointConfig = new EndpointConfig();
        endpointConfig.addHeadersJson(accessToken);
        endpointConfig.setBody(endpointConfig.setJsonFileBody(ImobFileJson.PATH_JSON_BANK_ADDRESS_RN004_111001));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkValueInJson("111001", "codigo", response);
        CheckResponse.checkValueInJson("TIPO DE OPERACAO OBRIGATORIO", "descricao", response);

    }

}
