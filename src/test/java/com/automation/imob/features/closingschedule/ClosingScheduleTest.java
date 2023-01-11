package com.automation.imob.features.closingschedule;

import com.automation.imob.ImobApplicationTests;
import com.automation.imob.components.MethodRest;
import com.automation.imob.components.config.EndpointConfig;
import com.automation.imob.components.result.CheckResponse;
import com.automation.imob.config.ConfigParams;
import com.automation.imob.config.ImobFileJson;
import com.automation.imob.config.ImobPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.io.IOException;
import java.util.HashMap;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ClosingScheduleTest extends ImobApplicationTests {

    private String externalReferencePayAddress;
    private Integer cns;
    private Integer registrationNumber;
    private String externalReferenceProject;

    @BeforeAll
    public void init(){
        externalReferencePayAddress = getDataFaker().getExternalReference("domiciliobancario-");
        cns = getDataFaker().getNumberCharacters(6);
        registrationNumber = getDataFaker().getNumberCharacters(6);
        externalReferenceProject = getDataFaker().getExternalReference("refereciaexternaprojeto-");
    }


    public EndpointConfig getEndpointConfig(String path) {
        EndpointConfig endpointConfig = new EndpointConfig();
        endpointConfig.addHeadersJson(getAccessToken());
        endpointConfig.setUrl(ConfigParams.HOST.concat(path));
        return endpointConfig;
    }


    @Test
    public void closingSchedule() throws IOException {

        //**************************** PAY ADDRESS ************************************************************

        // Create PayAddress

        // Create dynamic variables
        HashMap<String, Object> mapValuesPayAddress = new HashMap<>();
        mapValuesPayAddress.put("referenciaExterna", externalReferencePayAddress);

        // Create Request
        EndpointConfig endpointConfigPayAddress = getEndpointConfig(ImobPath.PATH_PAY_ADDRESS);
        endpointConfigPayAddress.setBody(endpointConfigPayAddress.alterValuesInJsonBody(ImobFileJson.PATH_JSON_PAY_ADDRESS_SAVE, mapValuesPayAddress));

        // Call endpoint
        Response responsePayAddress = MethodRest.callPost(endpointConfigPayAddress);

        // Check Response
        CheckResponse.checkHttpCode(201, responsePayAddress);
        CheckResponse.checkTextInJson("Created", responsePayAddress);

        //**************************** BUILDING ************************************************************

        // Create building

        // Create dynamic variables
        HashMap<String, Object> mapValuesBuilding = new HashMap<>();
        mapValuesBuilding.put("cns", cns);
        mapValuesBuilding.put("numeroMatricula", registrationNumber);
        mapValuesBuilding.put("referenciaExternaProjeto", externalReferenceProject);
        mapValuesBuilding.put("domicilioBancario", externalReferencePayAddress);

        // Create Request
        EndpointConfig endpointConfigBuilding = getEndpointConfig(ImobPath.PATH_BUILDING);
        endpointConfigBuilding.setBody(endpointConfigBuilding.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BUILDING_SAVE, mapValuesBuilding));

        // Call endpoint
        Response responseBuilding = MethodRest.callPost(endpointConfigBuilding);

        // Check Response
        CheckResponse.checkHttpCode(201, responseBuilding);
        CheckResponse.checkTextInJson("Created", responseBuilding);

        //**************************** CLOSE SCHEDULE ************************************************************

        HashMap<String, Object> mapValuesCloseSchedule = new HashMap<>();
        mapValuesCloseSchedule.put("referenciaExternaProjeto", externalReferenceProject);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_CLOSING_SCHEDULE);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_CLOSING_SCHEDULE,mapValuesCloseSchedule));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkHttpCode(200, response);
        CheckResponse.checkTextInJson("OK", response);
    }


    @Test
    public void rn004_101001() throws IOException {

        HashMap<String, Object> mapValuesCloseSchedule = new HashMap<>();
        mapValuesCloseSchedule.put("referenciaExternaProjeto", externalReferenceProject);
        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_CLOSING_SCHEDULE);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_CLOSING_SCHEDULE_RN004_101001,mapValuesCloseSchedule));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("101001", response);
        CheckResponse.checkTextInJson("TIPO DE OPERACAO OBRIGATORIO", response);

    }

    @Test
    public void rn004_101003() throws IOException {

        HashMap<String, Object> mapValuesCloseSchedule = new HashMap<>();
        mapValuesCloseSchedule.put("referenciaExternaProjeto", externalReferenceProject);
        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_CLOSING_SCHEDULE);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_CLOSING_SCHEDULE_RN004_101003,mapValuesCloseSchedule));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("101003", response);
        CheckResponse.checkTextInJson("REFERENCIA EXTERNA PROJETO OBRIGATORIA", response);

    }

    @Test
    public void rn004_101063() throws IOException {

        HashMap<String, Object> mapValuesCloseSchedule = new HashMap<>();
        mapValuesCloseSchedule.put("referenciaExternaProjeto", externalReferenceProject);
        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_CLOSING_SCHEDULE);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_CLOSING_SCHEDULE_RN004_101063,mapValuesCloseSchedule));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("101063", response);
        CheckResponse.checkTextInJson("MANUTENCAO DO EMPREENDIMENTO FINALIZADA OBRIGATORIO", response);

    }

    @Test
    public void rn005() throws IOException {
        HashMap<String, Object> mapValuesCloseSchedule = new HashMap<>();
        mapValuesCloseSchedule.put("referenciaExternaProjeto", externalReferenceProject);
        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_CLOSING_SCHEDULE);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_CLOSING_SCHEDULE_RN005,mapValuesCloseSchedule));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("101002", response);
        CheckResponse.checkTextInJson("TIPO DE OPERACAO INVALIDO", response);

    }

    @Test
    public void rn006() throws IOException {
        HashMap<String, Object> mapValuesCloseSchedule = new HashMap<>();
        mapValuesCloseSchedule.put("referenciaExternaProjeto", externalReferenceProject);
        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_CLOSING_SCHEDULE);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_CLOSING_SCHEDULE_RN006,mapValuesCloseSchedule));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("101064", response);
        CheckResponse.checkTextInJson("MANUTENCAO DO EMPREENDIMENTO FINALIZADA INVALIDO", response);

    }

    @Test
    public void rn007() throws IOException {
        HashMap<String, Object> mapValuesCloseSchedule = new HashMap<>();
        mapValuesCloseSchedule.put("referenciaExternaProjeto", externalReferenceProject);
        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_CLOSING_SCHEDULE);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_CLOSING_SCHEDULE_RN007,mapValuesCloseSchedule));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("101066", response);
        CheckResponse.checkTextInJson("MES REFERENCIA INVALIDO", response);

    }

    @Test
    public void rn008() throws IOException {
        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_CLOSING_SCHEDULE);
        endpointConfig.setBody(endpointConfig.setJsonFileBodyArray(ImobFileJson.PATH_JSON_CLOSING_SCHEDULE_RN008));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("101044", response);
        CheckResponse.checkTextInJson("REFERENCIA EXTERNA PROJETO NAO EXISTE", response);

    }

    @Test
    public void rn009() throws IOException {
        HashMap<String, Object> mapValuesCloseSchedule = new HashMap<>();
        mapValuesCloseSchedule.put("referenciaExternaProjeto", externalReferenceProject);
        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_CLOSING_SCHEDULE);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_CLOSING_SCHEDULE_RN009,mapValuesCloseSchedule));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("101065", response);
        CheckResponse.checkTextInJson("MES REFERENCIA OBRIGATORIO", response);

    }

    @Test
    public void rn011() throws IOException {

        //**************************** Pay ADDRESS ************************************************************

        // Create PayAddress

        // Create dynamic variables
        HashMap<String, Object> mapValuesPayAddress = new HashMap<>();
        String externalReferencePayAddress = getDataFaker().getExternalReference("domiciliobancario-");
        mapValuesPayAddress.put("referenciaExterna", externalReferencePayAddress);

        // Create Request
        EndpointConfig endpointConfigPayAddress = getEndpointConfig(ImobPath.PATH_PAY_ADDRESS);
        endpointConfigPayAddress.setBody(endpointConfigPayAddress.alterValuesInJsonBody(ImobFileJson.PATH_JSON_PAY_ADDRESS_SAVE, mapValuesPayAddress));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfigPayAddress);

        // Check Response
        CheckResponse.checkHttpCode(201, response);
        CheckResponse.checkTextInJson("Created", response);

        //**************************** BUILDING ************************************************************

        // Create building

        // Create dynamic variables
        HashMap<String, Object> mapValuesBuilding = new HashMap<>();
        Integer cns = getDataFaker().getNumberCharacters(6);
        Integer registrationNumber = getDataFaker().getNumberCharacters(6);
        String externalReferenceProject = getDataFaker().getExternalReference("empreendimento-");
        mapValuesBuilding.put("cns", cns);
        mapValuesBuilding.put("numeroMatricula", registrationNumber);
        mapValuesBuilding.put("referenciaExternaProjeto", externalReferenceProject);
        mapValuesBuilding.put("domicilioBancario", externalReferencePayAddress);

        // Create Request
        EndpointConfig endpointConfigBuilding = getEndpointConfig(ImobPath.PATH_BUILDING);
        endpointConfigBuilding.setBody(endpointConfigBuilding.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BUILDING_SAVE, mapValuesBuilding));

        // Call endpoint
        Response responseBuilding = MethodRest.callPost(endpointConfigBuilding);

        // Check Response
        CheckResponse.checkHttpCode(201, responseBuilding);
        CheckResponse.checkTextInJson("Created", responseBuilding);

        // Inactive building

        // Create dynamic variables
        HashMap<String, Object> mapValuesInactivateBuilding = new HashMap<>();
        mapValuesInactivateBuilding.put("cns", cns);
        mapValuesInactivateBuilding.put("numeroMatricula", registrationNumber);
        mapValuesInactivateBuilding.put("referenciaExternaProjeto", externalReferenceProject);
        mapValuesInactivateBuilding.put("domicilioBancario", externalReferencePayAddress);

        // Create Request
        endpointConfigBuilding.setBody(endpointConfigBuilding.alterValuesInJsonArrayBody((ImobFileJson.PATH_JSON_BUILDING_INACTIVATE), mapValuesInactivateBuilding));

        // Call endpoint
        Response responseInactivateBuilding = MethodRest.callPost(endpointConfigBuilding);

        // Check Response
        CheckResponse.checkHttpCode(200, responseInactivateBuilding);
        CheckResponse.checkTextInJson("OK", responseInactivateBuilding);

        //******************************* CLOSE SCHEDULE *********************************************************

        HashMap<String, Object> mapValuesClosingSchedule = new HashMap<>();

        mapValuesClosingSchedule.put("cns", cns);
        mapValuesClosingSchedule.put("numeroMatricula", registrationNumber);
        mapValuesClosingSchedule.put("referenciaExternaProjeto", externalReferenceProject);
        mapValuesClosingSchedule.put("domicilioBancario", externalReferencePayAddress);

        // Create Request
        endpointConfigBuilding.setBody(endpointConfigBuilding.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_CLOSING_SCHEDULE_RN011, mapValuesClosingSchedule));

        // Call endpoint
        Response responseInactivate = MethodRest.callPost(endpointConfigBuilding);

        // Check Response
        CheckResponse.checkTextInJson("101054", responseInactivate);
        CheckResponse.checkTextInJson("EMPREENDIMENTO INATIVO", responseInactivate);

    }

    //@Test regra ainda nao implementada TODO
    public void rn012() throws IOException {
        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_CLOSING_SCHEDULE);
        endpointConfig.setBody(endpointConfig.setJsonFileBody(ImobFileJson.PATH_JSON_CLOSING_SCHEDULE_RN012));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("100016", response);
        CheckResponse.checkTextInJson("OPERADOR NAO TEM PERMISSAO PARA ATUALIZAR O REGISTRO", response);

    }


}
