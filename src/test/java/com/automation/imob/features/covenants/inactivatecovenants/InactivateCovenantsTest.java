package com.automation.imob.features.covenants.inactivatecovenants;

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

public class InactivateCovenantsTest extends ImobApplicationTests {

    public EndpointConfig getEndpointConfig(String path) {
        EndpointConfig endpointConfig = new EndpointConfig();
        endpointConfig.addHeadersJson(getAccessToken());
        endpointConfig.setUrl(ConfigParams.HOST.concat(path));
        return endpointConfig;
    }

    private void inactiveCovenant(String idConvents) throws IOException {
        //*********************** INACTIVE COVENANT *******************************************

        // Create dynamic variables
        HashMap<String, Object> mapValuesInactivateCovenants = new HashMap<>();
        mapValuesInactivateCovenants.put("identificadorCovenant", idConvents);

        // Create Request
        EndpointConfig endpointConfigInactiveCovenant = getEndpointConfig(ImobPath.PATH_INACTIVATE_COVENANTS);
        endpointConfigInactiveCovenant.setBody(endpointConfigInactiveCovenant.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_INACTIVATE_COVENANTS_INACTIVATE,
                mapValuesInactivateCovenants));

        // Call endpoint
        Response responseInactivate = MethodRest.callPost(endpointConfigInactiveCovenant);

        // Check Response
        CheckResponse.checkHttpCode(200, responseInactivate);
        CheckResponse.checkTextInJson("OK", responseInactivate);
    }

    private String saveCovenant() throws IOException {
        //*********************** CREATE COVENANT ********************************************

        // Create dynamic variables
        HashMap<String, Object> mapValues = new HashMap<>();
        String idConvents = getDataFaker().getIdCovenant();
        mapValues.put("identificadorCovenant", idConvents);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_REGISTER_COVENANTS);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_REGISTER_COVENANTS, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkHttpCode(201, response);
        CheckResponse.checkTextInJson("Created", response);
        return idConvents;
    }

    @Test
    public void inactivateCovenants() throws IOException {
        String idConvents = saveCovenant();
        inactiveCovenant(idConvents);
    }

    @Test
    public void rn004() throws IOException {
        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_INACTIVATE_COVENANTS);
        endpointConfig.setBody(endpointConfig.setJsonFileBodyArray(ImobFileJson.PATH_JSON_INACTIVATE_COVENANTS_RN004));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("112001", response);
        CheckResponse.checkTextInJson("TIPO DE OPERACAO OBRIGATORIO", response);

    }

    @Test
    public void rn005() throws IOException {
        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_INACTIVATE_COVENANTS);
        endpointConfig.setBody(endpointConfig.setJsonFileBodyArray(ImobFileJson.PATH_JSON_INACTIVATE_COVENANTS_RN005));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("112002", response);
        CheckResponse.checkTextInJson("TIPO DE OPERACAO INVALIDO", response);

    }

    @Test
    public void rn006() throws IOException {
        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_INACTIVATE_COVENANTS);
        endpointConfig.setBody(endpointConfig.setJsonFileBodyArray(ImobFileJson.PATH_JSON_INACTIVATE_COVENANTS_RN006));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("112003", response);
        CheckResponse.checkTextInJson("IDENTIFICADOR DO COVENANTS OBRIGATORIO", response);

    }

    @Test
    public void rn009() throws IOException {
        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_INACTIVATE_COVENANTS);
        endpointConfig.setBody(endpointConfig.setJsonFileBodyArray(ImobFileJson.PATH_JSON_INACTIVATE_COVENANTS_RN009));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("112021", response);
        CheckResponse.checkTextInJson("IDENTIFICADOR DO COVENANT NAO EXISTE", response);

    }

    @Test
    public void rn010() throws IOException {
        String idConvents = saveCovenant();
        inactiveCovenant(idConvents);

        //*******************************************************************

        //Inactivate Covenants Again
        HashMap<String, Object> mapValuesInactivateCovenants = new HashMap<>();
        mapValuesInactivateCovenants.put("identificadorCovenant", idConvents);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_INACTIVATE_COVENANTS);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_INACTIVATE_COVENANTS_RN010,
                mapValuesInactivateCovenants));

        // Call endpoint
        Response responseInactivateAgain = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("112022", responseInactivateAgain);
        CheckResponse.checkTextInJson("COVENANT JA ESTA INATIVO", responseInactivateAgain);

    }
}
