package com.automation.imob.features.bankaddres;

import com.automation.imob.ImobApplicationTests;
import com.automation.imob.components.MethodRest;
import com.automation.imob.components.config.EndpointConfig;
import com.automation.imob.components.result.CheckResponse;
import com.automation.imob.config.ConfigParams;
import com.automation.imob.config.ImobFileJson;
import com.automation.imob.config.ImobPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashMap;

public class RegisterBankAddressTest extends ImobApplicationTests {

    public EndpointConfig getEndpointConfig(String path) {
        EndpointConfig endpointConfig = new EndpointConfig();
        endpointConfig.addHeadersJson(getAccessToken());
        endpointConfig.setUrl(ConfigParams.HOST.concat(path));
        return endpointConfig;
    }

    @Test
    public void save() throws IOException {

        // Create dynamics variables
        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("referenciaExterna", getDataFaker().getExternalReference("domiciliobancario-"));

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BANK_ADDRESS);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonBody(ImobFileJson.PATH_JSON_BANK_ADDRESS_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkHttpCode(201, response);
        CheckResponse.checkTextInJson("Created", response);
    }

    @Test
    public void rn004_111001() throws IOException {

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BANK_ADDRESS);
        endpointConfig.setBody(endpointConfig.setJsonFileBody(ImobFileJson.PATH_JSON_BANK_ADDRESS_RN004_111001));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("111001", response);
        CheckResponse.checkTextInJson("TIPO DE OPERACAO OBRIGATORIO", response);

    }


}
