package com.automation.imob.features.requestoptin;

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

public class RequestOptinTest extends ImobApplicationTests {

    //@Test TODO
    public void requestOptin() throws IOException {
        // Create Request
        EndpointConfig endpointConfig = new EndpointConfig();
        endpointConfig.addHeadersJson(getAccessToken());
        endpointConfig.setUrl(ConfigParams.HOST.concat(ImobPath.PATH_REQUEST_OPTIN));
        endpointConfig.setBody(endpointConfig.setJsonFileBody(ImobFileJson.PATH_JSON_REQUEST_OPTIN));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkHttpCode(201, response);
        CheckResponse.checkTextInJson("Created", response);
    }


    @Test
    public void rn004_105002() throws IOException {
        // Create Request
        EndpointConfig endpointConfig = new EndpointConfig();
        endpointConfig.addHeadersJson(getAccessToken());
        endpointConfig.setUrl(ConfigParams.HOST.concat(ImobPath.PATH_REQUEST_OPTIN));
        endpointConfig.setBody(endpointConfig.setJsonFileBodyArray(ImobFileJson.PATH_JSON_REQUEST_OPTIN_RN004_105002));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("105002",  response);
        CheckResponse.checkTextInJson("CNPJ DO EMPREENDIMENTO OBRIGATORIO", response);

    }
    @Test
    public void rn004_105004() throws IOException {
        // Create Request
        EndpointConfig endpointConfig = new EndpointConfig();
        endpointConfig.addHeadersJson(getAccessToken());
        endpointConfig.setUrl(ConfigParams.HOST.concat(ImobPath.PATH_REQUEST_OPTIN));
        endpointConfig.setBody(endpointConfig.setJsonFileBodyArray(ImobFileJson.PATH_JSON_REQUEST_OPTIN_RN004_105004));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("105004",  response);
        CheckResponse.checkTextInJson("DATA DE INICIO OBRIGATORIA", response);

    }
    @Test
    public void rn004_105006() throws IOException {
        // Create Request
        EndpointConfig endpointConfig = new EndpointConfig();
        endpointConfig.addHeadersJson(getAccessToken());
        endpointConfig.setUrl(ConfigParams.HOST.concat(ImobPath.PATH_REQUEST_OPTIN));
        endpointConfig.setBody(endpointConfig.setJsonFileBodyArray(ImobFileJson.PATH_JSON_REQUEST_OPTIN_RN004_105006));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("105006",  response);
        CheckResponse.checkTextInJson("DATA FIM OBRIGATORIA", response);

    }
    @Test
    public void rn004_105008() throws IOException {
        // Create Request
        EndpointConfig endpointConfig = new EndpointConfig();
        endpointConfig.addHeadersJson(getAccessToken());
        endpointConfig.setUrl(ConfigParams.HOST.concat(ImobPath.PATH_REQUEST_OPTIN));
        endpointConfig.setBody(endpointConfig.setJsonFileBodyArray(ImobFileJson.PATH_JSON_REQUEST_OPTIN_RN004_105008));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("105008",  response);
        CheckResponse.checkTextInJson("TIPO DE AGENDA OBRIGATORIO", response);

    }
    @Test
    public void rn005() throws IOException {
        // Create Request
        EndpointConfig endpointConfig = new EndpointConfig();
        endpointConfig.addHeadersJson(getAccessToken());
        endpointConfig.setUrl(ConfigParams.HOST.concat(ImobPath.PATH_REQUEST_OPTIN));
        endpointConfig.setBody(endpointConfig.setJsonFileBodyArray(ImobFileJson.PATH_JSON_REQUEST_OPTIN_RN005));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("105003",  response);
        CheckResponse.checkTextInJson("CNPJ DO EMPREENDIMENTO INVALIDO", response);

    }
    @Test
    public void rn006_105005() throws IOException {
        // Create Request
        EndpointConfig endpointConfig = new EndpointConfig();
        endpointConfig.addHeadersJson(getAccessToken());
        endpointConfig.setUrl(ConfigParams.HOST.concat(ImobPath.PATH_REQUEST_OPTIN));
        endpointConfig.setBody(endpointConfig.setJsonFileBodyArray(ImobFileJson.PATH_JSON_REQUEST_OPTIN_RN006_105005));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("105005",  response);
        CheckResponse.checkTextInJson("DATA DE INICIO INVALIDA", response);

    }
    @Test
    public void rn006_105007() throws IOException {
        // Create Request
        EndpointConfig endpointConfig = new EndpointConfig();
        endpointConfig.addHeadersJson(getAccessToken());
        endpointConfig.setUrl(ConfigParams.HOST.concat(ImobPath.PATH_REQUEST_OPTIN));
        endpointConfig.setBody(endpointConfig.setJsonFileBodyArray(ImobFileJson.PATH_JSON_REQUEST_OPTIN_RN006_105007));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("105007",  response);
        CheckResponse.checkTextInJson("DATA FIM INVALIDA", response);

    }
    @Test
    public void rn007() throws IOException {
        // Create Request
        EndpointConfig endpointConfig = new EndpointConfig();
        endpointConfig.addHeadersJson(getAccessToken());
        endpointConfig.setUrl(ConfigParams.HOST.concat(ImobPath.PATH_REQUEST_OPTIN));
        endpointConfig.setBody(endpointConfig.setJsonFileBodyArray(ImobFileJson.PATH_JSON_REQUEST_OPTIN_RN007));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("105009",  response);
        CheckResponse.checkTextInJson("TIPO DE AGENDA INVALIDO", response);

    }
    @Test
    public void rn008() throws IOException {
        // Create Request
        EndpointConfig endpointConfig = new EndpointConfig();
        endpointConfig.addHeadersJson(getAccessToken());
        endpointConfig.setUrl(ConfigParams.HOST.concat(ImobPath.PATH_REQUEST_OPTIN));
        endpointConfig.setBody(endpointConfig.setJsonFileBodyArray(ImobFileJson.PATH_JSON_REQUEST_OPTIN_RN008));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("105003",  response);
        CheckResponse.checkTextInJson("CNPJ DO EMPREENDIMENTO INVALIDO", response);

    }
    @Test
    public void rn012() throws IOException {
        // Create Request
        EndpointConfig endpointConfig = new EndpointConfig();
        endpointConfig.addHeadersJson(getAccessToken());
        endpointConfig.setUrl(ConfigParams.HOST.concat(ImobPath.PATH_REQUEST_OPTIN));
        endpointConfig.setBody(endpointConfig.setJsonFileBodyArray(ImobFileJson.PATH_JSON_REQUEST_OPTIN_RN012));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("105001",  response);
        CheckResponse.checkTextInJson("FINANCIADOR INVALIDO", response);

    }

    @Test
    public void rn013() throws IOException {
        // Create Request
        EndpointConfig endpointConfig = new EndpointConfig();
        endpointConfig.addHeadersJson(getAccessToken());
        endpointConfig.setUrl(ConfigParams.HOST.concat(ImobPath.PATH_REQUEST_OPTIN));
        endpointConfig.setBody(endpointConfig.setJsonFileBodyArray(ImobFileJson.PATH_JSON_REQUEST_OPTIN_RN013));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("105001",  response);
        CheckResponse.checkTextInJson("FINANCIADOR INVALIDO", response);

    }


}
