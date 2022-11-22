package com.automation.imob.authorizeoptin;

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

public class AuthorizeOptin extends ImobApplicationTests {

    @Test
    public void authorize() throws IOException {
        // Create Request
        EndpointConfig endpointConfig = new EndpointConfig();
        endpointConfig.addHeadersJson(getAccessToken());
        endpointConfig.setUrl(ConfigParams.HOST.concat(ImobPath.PATH_AUTHORIZE_OPTIN));
        endpointConfig.setBody(endpointConfig.setJsonFileBody(ImobFileJson.PATH_JSON_AUTHORIZE_OPTIN));

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
        endpointConfig.setUrl(ConfigParams.HOST.concat(ImobPath.PATH_AUTHORIZE_OPTIN));
        endpointConfig.setBody(endpointConfig.setJsonFileBody(ImobFileJson.PATH_JSON_AUTHORIZE_OPTIN_RN004_105002));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("105002",  response);
        CheckResponse.checkTextInJson("CNPJ DO EMPREENDIMENTO OBRIGATORIO", response);

    }
    public void rn004_105004() throws IOException {
        // Create Request
        EndpointConfig endpointConfig = new EndpointConfig();
        endpointConfig.addHeadersJson(getAccessToken());
        endpointConfig.setUrl(ConfigParams.HOST.concat(ImobPath.PATH_AUTHORIZE_OPTIN));
        endpointConfig.setBody(endpointConfig.setJsonFileBody(ImobFileJson.PATH_JSON_AUTHORIZE_OPTIN_RN004_105004));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("105004",  response);
        CheckResponse.checkTextInJson("DATA DE INICIO OBRIGATORIA", response);

    }
    public void rn004_105006() throws IOException {
        // Create Request
        EndpointConfig endpointConfig = new EndpointConfig();
        endpointConfig.addHeadersJson(getAccessToken());
        endpointConfig.setUrl(ConfigParams.HOST.concat(ImobPath.PATH_AUTHORIZE_OPTIN));
        endpointConfig.setBody(endpointConfig.setJsonFileBody(ImobFileJson.PATH_JSON_AUTHORIZE_OPTIN_RN004_105006));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("105006",  response);
        CheckResponse.checkTextInJson("DATA FIM OBRIGATORIA", response);

    }
    public void rn004_105010() throws IOException {
        // Create Request
        EndpointConfig endpointConfig = new EndpointConfig();
        endpointConfig.addHeadersJson(getAccessToken());
        endpointConfig.setUrl(ConfigParams.HOST.concat(ImobPath.PATH_AUTHORIZE_OPTIN));
        endpointConfig.setBody(endpointConfig.setJsonFileBody(ImobFileJson.PATH_JSON_AUTHORIZE_OPTIN_RN004_105010));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("105010",  response);
        CheckResponse.checkTextInJson("FINANCIADOR OBRIGATORIO", response);

    }
    public void rn004_105016() throws IOException {
        // Create Request
        EndpointConfig endpointConfig = new EndpointConfig();
        endpointConfig.addHeadersJson(getAccessToken());
        endpointConfig.setUrl(ConfigParams.HOST.concat(ImobPath.PATH_AUTHORIZE_OPTIN));
        endpointConfig.setBody(endpointConfig.setJsonFileBody(ImobFileJson.PATH_JSON_AUTHORIZE_OPTIN_RN004_105016));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("105016",  response);
        CheckResponse.checkTextInJson("APROVAR OPT IN OBRIGATORIO", response);

    }
    public void rn005() throws IOException {
        // Create Request
        EndpointConfig endpointConfig = new EndpointConfig();
        endpointConfig.addHeadersJson(getAccessToken());
        endpointConfig.setUrl(ConfigParams.HOST.concat(ImobPath.PATH_AUTHORIZE_OPTIN));
        endpointConfig.setBody(endpointConfig.setJsonFileBody(ImobFileJson.PATH_JSON_AUTHORIZE_OPTIN_RN005));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("105001",  response);
        CheckResponse.checkTextInJson("FINANCIADOR INVALIDO", response);

    }
    public void rn006() throws IOException {
        // Create Request
        EndpointConfig endpointConfig = new EndpointConfig();
        endpointConfig.addHeadersJson(getAccessToken());
        endpointConfig.setUrl(ConfigParams.HOST.concat(ImobPath.PATH_AUTHORIZE_OPTIN));
        endpointConfig.setBody(endpointConfig.setJsonFileBody(ImobFileJson.PATH_JSON_AUTHORIZE_OPTIN_RN006));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("105003",  response);
        CheckResponse.checkTextInJson("CNPJ DO EMPREENDIMENTO INVALIDO", response);

    }
}
