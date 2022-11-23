package com.automation.imob.features.grantoptin;

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

public class GrantOptinTest extends ImobApplicationTests {
    @Test
    public void grantOptin() throws IOException {
        // Create Request
        EndpointConfig endpointConfig = new EndpointConfig();
        endpointConfig.addHeadersJson(getAccessToken());
        endpointConfig.setUrl(ConfigParams.HOST.concat(ImobPath.PATH_GRANT_OPTIN));
        endpointConfig.setBody(endpointConfig.setJsonFileBody(ImobFileJson.PATH_JSON_GRANT_OPTIN));

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
        endpointConfig.setUrl(ConfigParams.HOST.concat(ImobPath.PATH_GRANT_OPTIN));
        endpointConfig.setBody(endpointConfig.setJsonFileBody(ImobFileJson.PATH_JSON_GRANT_OPTIN_RN004_105002));

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
        endpointConfig.setUrl(ConfigParams.HOST.concat(ImobPath.PATH_GRANT_OPTIN));
        endpointConfig.setBody(endpointConfig.setJsonFileBody(ImobFileJson.PATH_JSON_GRANT_OPTIN_RN004_105004));

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
        endpointConfig.setUrl(ConfigParams.HOST.concat(ImobPath.PATH_GRANT_OPTIN));
        endpointConfig.setBody(endpointConfig.setJsonFileBody(ImobFileJson.PATH_JSON_GRANT_OPTIN_RN004_105006));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("105006",  response);
        CheckResponse.checkTextInJson("DATA FIM OBRIGATORIA", response);

    }
    @Test
    public void rn004_105010() throws IOException {
        // Create Request
        EndpointConfig endpointConfig = new EndpointConfig();
        endpointConfig.addHeadersJson(getAccessToken());
        endpointConfig.setUrl(ConfigParams.HOST.concat(ImobPath.PATH_GRANT_OPTIN));
        endpointConfig.setBody(endpointConfig.setJsonFileBody(ImobFileJson.PATH_JSON_GRANT_OPTIN_RN004_105010));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("105010",  response);
        CheckResponse.checkTextInJson("FINANCIADOR OBRIGATORIO", response);

    }
    @Test
    public void rn004_105011() throws IOException {
        // Create Request
        EndpointConfig endpointConfig = new EndpointConfig();
        endpointConfig.addHeadersJson(getAccessToken());
        endpointConfig.setUrl(ConfigParams.HOST.concat(ImobPath.PATH_GRANT_OPTIN));
        endpointConfig.setBody(endpointConfig.setJsonFileBody(ImobFileJson.PATH_JSON_GRANT_OPTIN_RN004_105011));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("105011",  response);
        CheckResponse.checkTextInJson("TIPO DE LIBERACAO OBRIGATORIO", response);

    }
    @Test
    public void rn005() throws IOException {
        // Create Request
        EndpointConfig endpointConfig = new EndpointConfig();
        endpointConfig.addHeadersJson(getAccessToken());
        endpointConfig.setUrl(ConfigParams.HOST.concat(ImobPath.PATH_GRANT_OPTIN));
        endpointConfig.setBody(endpointConfig.setJsonFileBody(ImobFileJson.PATH_JSON_GRANT_OPTIN_RN005));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("105001",  response);
        CheckResponse.checkTextInJson("FINANCIADOR INVALIDO", response);

    }
    @Test
    public void rn006() throws IOException {
        // Create Request
        EndpointConfig endpointConfig = new EndpointConfig();
        endpointConfig.addHeadersJson(getAccessToken());
        endpointConfig.setUrl(ConfigParams.HOST.concat(ImobPath.PATH_GRANT_OPTIN));
        endpointConfig.setBody(endpointConfig.setJsonFileBody(ImobFileJson.PATH_JSON_GRANT_OPTIN_RN006));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("105003",  response);
        CheckResponse.checkTextInJson("CNPJ DO EMPREENDIMENTO INVALIDO", response);

    }
    @Test
    public void rn007_105005() throws IOException {
        // Create Request
        EndpointConfig endpointConfig = new EndpointConfig();
        endpointConfig.addHeadersJson(getAccessToken());
        endpointConfig.setUrl(ConfigParams.HOST.concat(ImobPath.PATH_GRANT_OPTIN));
        endpointConfig.setBody(endpointConfig.setJsonFileBody(ImobFileJson.PATH_JSON_GRANT_OPTIN_RN007_105005));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("105005",  response);
        CheckResponse.checkTextInJson("DATA DE INICIO INVALIDA", response);

    }
    @Test
    public void rn007_105007() throws IOException {
        // Create Request
        EndpointConfig endpointConfig = new EndpointConfig();
        endpointConfig.addHeadersJson(getAccessToken());
        endpointConfig.setUrl(ConfigParams.HOST.concat(ImobPath.PATH_GRANT_OPTIN));
        endpointConfig.setBody(endpointConfig.setJsonFileBody(ImobFileJson.PATH_JSON_GRANT_OPTIN_RN007_105007));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("105007",  response);
        CheckResponse.checkTextInJson("DATA FIM INVALIDA", response);

    }
    @Test
    public void rn008() throws IOException {
        // Create Request
        EndpointConfig endpointConfig = new EndpointConfig();
        endpointConfig.addHeadersJson(getAccessToken());
        endpointConfig.setUrl(ConfigParams.HOST.concat(ImobPath.PATH_GRANT_OPTIN));
        endpointConfig.setBody(endpointConfig.setJsonFileBody(ImobFileJson.PATH_JSON_GRANT_OPTIN_RN008));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("105012",  response);
        CheckResponse.checkTextInJson("TIPO DE LIBERACAO INVALIDO", response);

    }
    @Test
    public void rn009() throws IOException {
        // Create Request
        EndpointConfig endpointConfig = new EndpointConfig();
        endpointConfig.addHeadersJson(getAccessToken());
        endpointConfig.setUrl(ConfigParams.HOST.concat(ImobPath.PATH_GRANT_OPTIN));
        endpointConfig.setBody(endpointConfig.setJsonFileBody(ImobFileJson.PATH_JSON_GRANT_OPTIN_RN009));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("105001",  response);
        CheckResponse.checkTextInJson("FINANCIADOR INVALIDO", response);

    }
    @Test
    public void rn010() throws IOException {
        // Create Request
        EndpointConfig endpointConfig = new EndpointConfig();
        endpointConfig.addHeadersJson(getAccessToken());
        endpointConfig.setUrl(ConfigParams.HOST.concat(ImobPath.PATH_GRANT_OPTIN));
        endpointConfig.setBody(endpointConfig.setJsonFileBody(ImobFileJson.PATH_JSON_GRANT_OPTIN_RN010));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("105003",  response);
        CheckResponse.checkTextInJson("CNPJ DO EMPREENDIMENTO INVALIDO", response);

    }
    @Test
    public void rn011() throws IOException {
        // Create Request
        EndpointConfig endpointConfig = new EndpointConfig();
        endpointConfig.addHeadersJson(getAccessToken());
        endpointConfig.setUrl(ConfigParams.HOST.concat(ImobPath.PATH_GRANT_OPTIN));
        endpointConfig.setBody(endpointConfig.setJsonFileBody(ImobFileJson.PATH_JSON_GRANT_OPTIN_RN011));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("105013",  response);
        CheckResponse.checkTextInJson("QUADRAS/TORRES OBRIGATORIO", response);

    }
    @Test
    public void rn012() throws IOException {
        // Create Request
        EndpointConfig endpointConfig = new EndpointConfig();
        endpointConfig.addHeadersJson(getAccessToken());
        endpointConfig.setUrl(ConfigParams.HOST.concat(ImobPath.PATH_GRANT_OPTIN));
        endpointConfig.setBody(endpointConfig.setJsonFileBody(ImobFileJson.PATH_JSON_GRANT_OPTIN_RN012));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("105014",  response);
        CheckResponse.checkTextInJson("QUADRAS/TORRES INVALIDO", response);

    }
}
