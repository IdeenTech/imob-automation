package com.automation.imob.features.closingschedule;

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

public class ClosingScheduleTest extends ImobApplicationTests {

    @Test
    public void closingschedule() throws IOException {
        // Create Request
        EndpointConfig endpointConfig = new EndpointConfig();
        endpointConfig.addHeadersJson(getAccessToken());
        endpointConfig.setUrl(ConfigParams.HOST.concat(ImobPath.PATH_CLOSING_SCHEDULE));
        endpointConfig.setBody(endpointConfig.setJsonFileBody(ImobFileJson.PATH_JSON_CLOSING_SCHEDULE));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkHttpCode(201, response);
        CheckResponse.checkTextInJson("Created", response);
    }


    @Test
    public void rn004_101001() throws IOException {
        // Create Request
        EndpointConfig endpointConfig = new EndpointConfig();
        endpointConfig.addHeadersJson(getAccessToken());
        endpointConfig.setUrl(ConfigParams.HOST.concat(ImobPath.PATH_CLOSING_SCHEDULE));
        endpointConfig.setBody(endpointConfig.setJsonFileBody(ImobFileJson.PATH_JSON_CLOSING_SCHEDULE_RN004_101001));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("101001",  response);
        CheckResponse.checkTextInJson("TIPO DE OPERACAO OBRIGATORIO", response);

    }

    @Test
    public void rn004_103003() throws IOException {
        // Create Request
        EndpointConfig endpointConfig = new EndpointConfig();
        endpointConfig.addHeadersJson(getAccessToken());
        endpointConfig.setUrl(ConfigParams.HOST.concat(ImobPath.PATH_CLOSING_SCHEDULE));
        endpointConfig.setBody(endpointConfig.setJsonFileBody(ImobFileJson.PATH_JSON_CLOSING_SCHEDULE_RN004_101003));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("101003",  response);
        CheckResponse.checkTextInJson("REFERENCIA EXTERNA PROJETO OBRIGATORIA", response);

    }

    @Test
    public void rn004_101063() throws IOException {
        // Create Request
        EndpointConfig endpointConfig = new EndpointConfig();
        endpointConfig.addHeadersJson(getAccessToken());
        endpointConfig.setUrl(ConfigParams.HOST.concat(ImobPath.PATH_CLOSING_SCHEDULE));
        endpointConfig.setBody(endpointConfig.setJsonFileBody(ImobFileJson.PATH_JSON_CLOSING_SCHEDULE_RN004_101063));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("101063",  response);
        CheckResponse.checkTextInJson("MANUTENCAO DO EMPREENDIMENTO FINALIZADA OBRIGATORIO", response);

    }
    @Test
    public void rn005() throws IOException {
        // Create Request
        EndpointConfig endpointConfig = new EndpointConfig();
        endpointConfig.addHeadersJson(getAccessToken());
        endpointConfig.setUrl(ConfigParams.HOST.concat(ImobPath.PATH_CLOSING_SCHEDULE));
        endpointConfig.setBody(endpointConfig.setJsonFileBody(ImobFileJson.PATH_JSON_CLOSING_SCHEDULE_RN005));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("113001",  response);
        CheckResponse.checkTextInJson("TIPO DE OPERACAO INVALIDO", response);

    }
    @Test
    public void rn006() throws IOException {
        // Create Request
        EndpointConfig endpointConfig = new EndpointConfig();
        endpointConfig.addHeadersJson(getAccessToken());
        endpointConfig.setUrl(ConfigParams.HOST.concat(ImobPath.PATH_CLOSING_SCHEDULE));
        endpointConfig.setBody(endpointConfig.setJsonFileBody(ImobFileJson.PATH_JSON_CLOSING_SCHEDULE_RN006));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("101064",  response);
        CheckResponse.checkTextInJson("MANUTENCAO DO EMPREENDIMENTO FINALIZADA INVALIDO", response);

    }
    @Test
    public void rn007() throws IOException {
        // Create Request
        EndpointConfig endpointConfig = new EndpointConfig();
        endpointConfig.addHeadersJson(getAccessToken());
        endpointConfig.setUrl(ConfigParams.HOST.concat(ImobPath.PATH_CLOSING_SCHEDULE));
        endpointConfig.setBody(endpointConfig.setJsonFileBody(ImobFileJson.PATH_JSON_CLOSING_SCHEDULE_RN007));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("101066",  response);
        CheckResponse.checkTextInJson("MES REFERENCIA INVALIDO", response);

    }
    @Test
    public void rn008() throws IOException {
        // Create Request
        EndpointConfig endpointConfig = new EndpointConfig();
        endpointConfig.addHeadersJson(getAccessToken());
        endpointConfig.setUrl(ConfigParams.HOST.concat(ImobPath.PATH_CLOSING_SCHEDULE));
        endpointConfig.setBody(endpointConfig.setJsonFileBody(ImobFileJson.PATH_JSON_CLOSING_SCHEDULE_RN008));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("101044",  response);
        CheckResponse.checkTextInJson("REFERENCIA EXTERNA PROJETO NAO EXISTE", response);

    }

    @Test
    public void rn009() throws IOException {
        // Create Request
        EndpointConfig endpointConfig = new EndpointConfig();
        endpointConfig.addHeadersJson(getAccessToken());
        endpointConfig.setUrl(ConfigParams.HOST.concat(ImobPath.PATH_CLOSING_SCHEDULE));
        endpointConfig.setBody(endpointConfig.setJsonFileBody(ImobFileJson.PATH_JSON_CLOSING_SCHEDULE_RN009));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("101065",  response);
        CheckResponse.checkTextInJson("MES REFERENCIA OBRIGATORIO", response);

    }
    @Test
    public void rn011() throws IOException {
        // Create Request
        EndpointConfig endpointConfig = new EndpointConfig();
        endpointConfig.addHeadersJson(getAccessToken());
        endpointConfig.setUrl(ConfigParams.HOST.concat(ImobPath.PATH_CLOSING_SCHEDULE));
        endpointConfig.setBody(endpointConfig.setJsonFileBody(ImobFileJson.PATH_JSON_CLOSING_SCHEDULE_RN011));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("101054",  response);
        CheckResponse.checkTextInJson("EMPREENDIMENTO INATIVO", response);

    }
    @Test
    public void rn012() throws IOException {
        // Create Request
        EndpointConfig endpointConfig = new EndpointConfig();
        endpointConfig.addHeadersJson(getAccessToken());
        endpointConfig.setUrl(ConfigParams.HOST.concat(ImobPath.PATH_CLOSING_SCHEDULE));
        endpointConfig.setBody(endpointConfig.setJsonFileBody(ImobFileJson.PATH_JSON_CLOSING_SCHEDULE_RN012));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("100016",  response);
        CheckResponse.checkTextInJson("OPERADOR NAO TEM PERMISSAO PARA ATUALIZAR O REGISTRO", response);

    }




}