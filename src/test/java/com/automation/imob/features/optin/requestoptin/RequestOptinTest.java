package com.automation.imob.features.optin.requestoptin;

import com.automation.imob.ImobApplicationTests;
import com.automation.imob.components.MethodRest;
import com.automation.imob.components.config.EndpointConfig;
import com.automation.imob.components.result.CheckResponse;
import com.automation.imob.config.ConfigParams;
import com.automation.imob.config.ImobFileJson;
import com.automation.imob.config.ImobPath;
import io.restassured.response.Response;
import io.restassured.specification.Argument;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.IOException;
import java.util.HashMap;
import java.util.stream.Stream;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class RequestOptinTest extends ImobApplicationTests {

    private String externalReferenceBankAddress;
    private Integer cns;
    private Integer registrationNumber;
    private String externalReferenceProject;


    @BeforeAll
    public void init(){
        externalReferenceBankAddress = getDataFaker().getExternalReference("domiciliobancario-");
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

    //@Test TODO
    public void requestOptin() throws IOException {

        //**************************** BANK ADDRESS ************************************************************

        // Create BankAddress

        // Create dynamic variables
        HashMap<String, Object> mapValuesBankAddress = new HashMap<>();
        mapValuesBankAddress.put("referenciaExterna", externalReferenceBankAddress);

        // Create Request
        EndpointConfig endpointConfigBankAddress = getEndpointConfig(ImobPath.PATH_BANK_ADDRESS);
        endpointConfigBankAddress.setBody(endpointConfigBankAddress.alterValuesInJsonBody(ImobFileJson.PATH_JSON_BANK_ADDRESS_SAVE, mapValuesBankAddress));

        // Call endpoint
        Response responseBankAddress = MethodRest.callPost(endpointConfigBankAddress);

        // Check Response
        CheckResponse.checkHttpCode(201, responseBankAddress);
        CheckResponse.checkTextInJson("Created", responseBankAddress);

        //**************************** BUILDING ************************************************************

        // Create building

        // Create dynamic variables
        HashMap<String, Object> mapValuesBuilding = new HashMap<>();
        mapValuesBuilding.put("cns", cns);
        mapValuesBuilding.put("numeroMatricula", registrationNumber);
        mapValuesBuilding.put("referenciaExternaProjeto", externalReferenceProject);
        mapValuesBuilding.put("domicilioBancario", externalReferenceBankAddress);

        // Create Request
        EndpointConfig endpointConfigBuilding = getEndpointConfig(ImobPath.PATH_BUILDING);
        endpointConfigBuilding.setBody(endpointConfigBuilding.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BUILDING_SAVE, mapValuesBuilding));

        // Call endpoint
        Response responseBuilding = MethodRest.callPost(endpointConfigBuilding);

        // Check Response
        CheckResponse.checkHttpCode(201, responseBuilding);
        CheckResponse.checkTextInJson("Created", responseBuilding);

        //**************************** REQUEST OPT-IN ************************************************************


        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_REQUEST_OPTIN);
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
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_REQUEST_OPTIN);
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
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_REQUEST_OPTIN);
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
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_REQUEST_OPTIN);
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
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_REQUEST_OPTIN);
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
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_REQUEST_OPTIN);
        endpointConfig.setBody(endpointConfig.setJsonFileBodyArray(ImobFileJson.PATH_JSON_REQUEST_OPTIN_RN005));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("105003",  response);
        CheckResponse.checkTextInJson("CNPJ DO EMPREENDIMENTO INVALIDO", response);

    }


   @DisplayName( "Testing invalid start dates")
   @ParameterizedTest
   @ValueSource(strings = {"20-10","2022-15","203-09","A"})
    public void rn006_105005(String invalidStartDate) throws IOException {

       HashMap<String, Object> mapValues = new HashMap<>();
       mapValues.put("dataDeInicio", invalidStartDate);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_REQUEST_OPTIN);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_REQUEST_OPTIN_RN006_105005,mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("105005",  response);
        CheckResponse.checkTextInJson("DATA DE INICIO INVALIDA", response);

    }
    @DisplayName( "Testing invalid end dates")
    @ParameterizedTest
    @ValueSource(strings = {"20-10","2022-15","203-09","A"})
    public void rn006_105007(String invalidEndDates) throws IOException {

        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("dataDeFim", invalidEndDates);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_REQUEST_OPTIN);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_REQUEST_OPTIN_RN006_105007,mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("105007",  response);
        CheckResponse.checkTextInJson("DATA FIM INVALIDA", response);

    }
    @Test
    public void rn007() throws IOException {

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_REQUEST_OPTIN);
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
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_REQUEST_OPTIN);
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
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_REQUEST_OPTIN);
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
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_REQUEST_OPTIN);
        endpointConfig.setBody(endpointConfig.setJsonFileBodyArray(ImobFileJson.PATH_JSON_REQUEST_OPTIN_RN013));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("105001",  response);
        CheckResponse.checkTextInJson("FINANCIADOR INVALIDO", response);

    }


}
