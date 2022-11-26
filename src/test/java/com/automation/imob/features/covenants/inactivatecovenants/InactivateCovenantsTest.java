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

    @Test
    public void inactivateCovenants() throws IOException {
        //Register Covenants
        HashMap<String, Object> mapValues = new HashMap<>();
        String idConvents = getDataFaker().getIdCovenant();
        mapValues.put("identificadorCovenant",idConvents);
        // Create Request
        EndpointConfig endpointConfig = new EndpointConfig();
        endpointConfig.addHeadersJson(getAccessToken());
        endpointConfig.setUrl(ConfigParams.HOST.concat(ImobPath.PATH_REGISTER_COVENANTS));
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_REGISTER_COVENANTS, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkHttpCode(201, response);
        CheckResponse.checkTextInJson("Created", response);

        //*******************************************************************

        //Inactivate Covenants
        HashMap<String, Object> mapValuesInactivateCovenats = new HashMap<>();
        mapValuesInactivateCovenats.put("identificadorCovenant", idConvents);
        // Create Request
        EndpointConfig endpointConfigInactivate = new EndpointConfig();
        endpointConfigInactivate.addHeadersJson(getAccessToken());
        endpointConfigInactivate.setUrl(ConfigParams.HOST.concat(ImobPath.PATH_INACTIVATE_COVENANTS));
        endpointConfigInactivate.setBody(endpointConfigInactivate.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_INACTIVATE_COVENANTS_INACTIVATE, mapValuesInactivateCovenats));

        // Call endpoint
        Response responseInactivate = MethodRest.callPost(endpointConfigInactivate);

        // Check Response
        CheckResponse.checkHttpCode(200, responseInactivate);
        CheckResponse.checkTextInJson("OK", responseInactivate);
    }


    @Test
    public void rn004() throws IOException {
        // Create Request
        EndpointConfig endpointConfig = new EndpointConfig();
        endpointConfig.addHeadersJson(getAccessToken());
        endpointConfig.setUrl(ConfigParams.HOST.concat(ImobPath.PATH_INACTIVATE_COVENANTS));
        endpointConfig.setBody(endpointConfig.setJsonFileBodyArray(ImobFileJson.PATH_JSON_INACTIVATE_COVENANTS_RN004));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("112001",  response);
        CheckResponse.checkTextInJson("TIPO DE OPERACAO OBRIGATORIO", response);

    }
    @Test
    public void rn005() throws IOException {
        // Create Request
        EndpointConfig endpointConfig = new EndpointConfig();
        endpointConfig.addHeadersJson(getAccessToken());
        endpointConfig.setUrl(ConfigParams.HOST.concat(ImobPath.PATH_INACTIVATE_COVENANTS));
        endpointConfig.setBody(endpointConfig.setJsonFileBodyArray(ImobFileJson.PATH_JSON_INACTIVATE_COVENANTS_RN005));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("112002",  response);
        CheckResponse.checkTextInJson("TIPO DE OPERACAO INVALIDO", response);

    }
    @Test
    public void rn006() throws IOException {
        // Create Request
        EndpointConfig endpointConfig = new EndpointConfig();
        endpointConfig.addHeadersJson(getAccessToken());
        endpointConfig.setUrl(ConfigParams.HOST.concat(ImobPath.PATH_INACTIVATE_COVENANTS));
        endpointConfig.setBody(endpointConfig.setJsonFileBodyArray(ImobFileJson.PATH_JSON_INACTIVATE_COVENANTS_RN006));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("112003",  response);
        CheckResponse.checkTextInJson("IDENTIFICADOR DO COVENANTS OBRIGATORIO", response);

    }
    @Test
    public void rn009() throws IOException {
        // Create Request
        EndpointConfig endpointConfig = new EndpointConfig();
        endpointConfig.addHeadersJson(getAccessToken());
        endpointConfig.setUrl(ConfigParams.HOST.concat(ImobPath.PATH_INACTIVATE_COVENANTS));
        endpointConfig.setBody(endpointConfig.setJsonFileBodyArray(ImobFileJson.PATH_JSON_INACTIVATE_COVENANTS_RN009));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("112021",  response);
        CheckResponse.checkTextInJson("IDENTIFICADOR DO COVENANT NAO EXISTE", response);

    }
    @Test
    public void rn010() throws IOException {

        //Register Covenants
        HashMap<String, Object> mapValues = new HashMap<>();
        String idConvents = getDataFaker().getIdCovenant();
        mapValues.put("identificadorCovenant",idConvents);
        // Create Request
        EndpointConfig endpointConfig = new EndpointConfig();
        endpointConfig.addHeadersJson(getAccessToken());
        endpointConfig.setUrl(ConfigParams.HOST.concat(ImobPath.PATH_REGISTER_COVENANTS));
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_REGISTER_COVENANTS, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkHttpCode(201, response);
        CheckResponse.checkTextInJson("Created", response);

        //*******************************************************************

        //Inactivate Covenants
        HashMap<String, Object> mapValuesInactivateCovenats = new HashMap<>();
        mapValuesInactivateCovenats.put("identificadorCovenant", idConvents);
        // Create Request
        EndpointConfig endpointConfigInactivate = new EndpointConfig();
        endpointConfigInactivate.addHeadersJson(getAccessToken());
        endpointConfigInactivate.setUrl(ConfigParams.HOST.concat(ImobPath.PATH_INACTIVATE_COVENANTS));
        endpointConfigInactivate.setBody(endpointConfigInactivate.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_INACTIVATE_COVENANTS_INACTIVATE, mapValuesInactivateCovenats));

        // Call endpoint
        Response responseInactivate = MethodRest.callPost(endpointConfigInactivate);

        // Check Response
        CheckResponse.checkHttpCode(200, responseInactivate);
        CheckResponse.checkTextInJson("OK", responseInactivate);

        //*******************************************************************

        //Inactivate Covenants Again
        HashMap<String, Object> mapValuesInactivateCovenatsAgain = new HashMap<>();
        mapValuesInactivateCovenatsAgain.put("identificadorCovenant", idConvents);
        // Create Request
        EndpointConfig endpointConfigInactivateAgain = new EndpointConfig();
        endpointConfigInactivateAgain.addHeadersJson(getAccessToken());
        endpointConfigInactivateAgain.setUrl(ConfigParams.HOST.concat(ImobPath.PATH_INACTIVATE_COVENANTS));
        endpointConfigInactivateAgain.setBody(endpointConfigInactivateAgain.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_INACTIVATE_COVENANTS_RN010,mapValuesInactivateCovenatsAgain ));

        // Call endpoint
        Response responseInactivateAgain = MethodRest.callPost(endpointConfigInactivateAgain);

        // Check Response
        CheckResponse.checkTextInJson("112022",  responseInactivateAgain);
        CheckResponse.checkTextInJson("COVENANT JA ESTA INATIVO", responseInactivateAgain);

    }
}
