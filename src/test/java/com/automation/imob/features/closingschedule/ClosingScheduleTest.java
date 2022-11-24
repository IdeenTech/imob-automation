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
import java.util.HashMap;

public class ClosingScheduleTest extends ImobApplicationTests {

    @Test
    public void closingSchedule() throws IOException {
        // Create Request
        EndpointConfig endpointConfig = new EndpointConfig();
        endpointConfig.addHeadersJson(getAccessToken());
        endpointConfig.setUrl(ConfigParams.HOST.concat(ImobPath.PATH_CLOSING_SCHEDULE));
        endpointConfig.setBody(endpointConfig.setJsonFileBodyArray(ImobFileJson.PATH_JSON_CLOSING_SCHEDULE));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkHttpCode(200, response);
        CheckResponse.checkTextInJson("OK", response);
    }


    @Test
    public void rn004_101001() throws IOException {
        // Create Request
        EndpointConfig endpointConfig = new EndpointConfig();
        endpointConfig.addHeadersJson(getAccessToken());
        endpointConfig.setUrl(ConfigParams.HOST.concat(ImobPath.PATH_CLOSING_SCHEDULE));
        endpointConfig.setBody(endpointConfig.setJsonFileBodyArray(ImobFileJson.PATH_JSON_CLOSING_SCHEDULE_RN004_101001));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("101001",  response);
        CheckResponse.checkTextInJson("TIPO DE OPERACAO OBRIGATORIO", response);

    }

    @Test
    public void rn004_101003() throws IOException {
        // Create Request
        EndpointConfig endpointConfig = new EndpointConfig();
        endpointConfig.addHeadersJson(getAccessToken());
        endpointConfig.setUrl(ConfigParams.HOST.concat(ImobPath.PATH_CLOSING_SCHEDULE));
        endpointConfig.setBody(endpointConfig.setJsonFileBodyArray(ImobFileJson.PATH_JSON_CLOSING_SCHEDULE_RN004_101003));

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
        endpointConfig.setBody(endpointConfig.setJsonFileBodyArray(ImobFileJson.PATH_JSON_CLOSING_SCHEDULE_RN004_101063));

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
        endpointConfig.setBody(endpointConfig.setJsonFileBodyArray(ImobFileJson.PATH_JSON_CLOSING_SCHEDULE_RN005));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("101002",  response);
        CheckResponse.checkTextInJson("TIPO DE OPERACAO INVALIDO", response);

    }
    @Test
    public void rn006() throws IOException {
        // Create Request
        EndpointConfig endpointConfig = new EndpointConfig();
        endpointConfig.addHeadersJson(getAccessToken());
        endpointConfig.setUrl(ConfigParams.HOST.concat(ImobPath.PATH_CLOSING_SCHEDULE));
        endpointConfig.setBody(endpointConfig.setJsonFileBodyArray(ImobFileJson.PATH_JSON_CLOSING_SCHEDULE_RN006));

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
        endpointConfig.setBody(endpointConfig.setJsonFileBodyArray(ImobFileJson.PATH_JSON_CLOSING_SCHEDULE_RN007));

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
        endpointConfig.setBody(endpointConfig.setJsonFileBodyArray(ImobFileJson.PATH_JSON_CLOSING_SCHEDULE_RN008));

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
        endpointConfig.setBody(endpointConfig.setJsonFileBodyArray(ImobFileJson.PATH_JSON_CLOSING_SCHEDULE_RN009));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("101065",  response);
        CheckResponse.checkTextInJson("MES REFERENCIA OBRIGATORIO", response);

    }
    //@Test regra ainda nao implementada TODO
    public void rn011() throws IOException {
        //create bank address
        HashMap<String, Object> mapValues = new HashMap<>();
        String referenciaExtenaDomicilio = getDataFaker().getExternalReference();
        mapValues.put("referenciaExterna", referenciaExtenaDomicilio);

        // Create Request
        EndpointConfig endpointConfig = new EndpointConfig();
        endpointConfig.addHeadersJson(getAccessToken());
        endpointConfig.setUrl(ConfigParams.HOST.concat(ImobPath.PATH_BANK_ADDRESS));
        endpointConfig.setBody(endpointConfig.alterValuesInJsonBody(ImobFileJson.PATH_JSON_BANK_ADDRESS_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkHttpCode(201, response);
        CheckResponse.checkTextInJson("Created", response);

        //****************************************************************************************

        //create building
        Integer cns =  getDataFaker().getNumberCharacters(6);
        Integer numeroMatricula =  getDataFaker().getNumberCharacters(6);
        String referenciaExternaProjeto = getDataFaker().getExternalReference();
        mapValues.put("cns",cns);
        mapValues.put("numeroMatricula",numeroMatricula);
        mapValues.put("referenciaExternaProjeto", referenciaExternaProjeto);
        mapValues.put("domicilioBancario", referenciaExtenaDomicilio);

        // Create Request
        endpointConfig.addHeadersJson(getAccessToken());
        endpointConfig.setUrl(ConfigParams.HOST.concat(ImobPath.PATH_BUILDING));
        endpointConfig.setBody(endpointConfig.alterValuesInJsonBody(ImobFileJson.PATH_JSON_BUILDING_SAVE,mapValues));

        //endpointConfig.setBody(endpointConfig.setJsonFileBodyArray(ImobFileJson.PATH_JSON_CLOSING_SCHEDULE_RN009));

        // Call endpoint
        Response responseBuilding = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkHttpCode(201, responseBuilding);
        CheckResponse.checkTextInJson("Created", responseBuilding);

        //****************************************************************************************

        //Inactivate Building
        mapValues.put("cns",cns);
        mapValues.put("numeroMatricula",numeroMatricula);
        mapValues.put("referenciaExternaProjeto", referenciaExternaProjeto);
        mapValues.put("domicilioBancario", referenciaExtenaDomicilio);

        // Create Request
        endpointConfig.addHeadersJson(getAccessToken());
        endpointConfig.setUrl(ConfigParams.HOST.concat(ImobPath.PATH_BUILDING));
        endpointConfig.setBody(endpointConfig.alterValuesInJsonBody(ImobFileJson.PATH_JSON_BUILDING_INACTIVATE,mapValues));

        // Call endpoint
        Response responseiInactivateBuilding = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkHttpCode(200, responseiInactivateBuilding);
        CheckResponse.checkTextInJson("ok", responseiInactivateBuilding);

        //****************************************************************************************

        mapValues.put("cns",cns);
        mapValues.put("numeroMatricula",numeroMatricula);
        mapValues.put("referenciaExternaProjeto", referenciaExternaProjeto);
        mapValues.put("domicilioBancario", referenciaExtenaDomicilio);

        // Create Request
        endpointConfig.addHeadersJson(getAccessToken());
        endpointConfig.setUrl(ConfigParams.HOST.concat(ImobPath.PATH_BUILDING));
        endpointConfig.setBody(endpointConfig.alterValuesInJsonBody(ImobFileJson.PATH_JSON_CLOSING_SCHEDULE_RN011,mapValues));

        // Call endpoint
        Response responseinactvate = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("101054",  responseinactvate);
        CheckResponse.checkTextInJson("EMPREENDIMENTO INATIVO", responseinactvate);

    }
    //@Test regra ainda nao implementada TODO
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
