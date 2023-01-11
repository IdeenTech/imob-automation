package com.automation.imob.features.optin.authorizeoptin;

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
public class AuthorizeOptinTest extends ImobApplicationTests {

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


   // @Test O AUTORIZAR COM SUCESSO ESTÁ COM ERRO, AGUARDAR CORREÇÃO PRA VALIDAR ESSE CENÁRIO TODO
    public void authorize() throws IOException {

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

        //**************************** BLOCK / TOWER ************************************************************

        // Create block / tower

        // Create dynamic variables
        HashMap<String, Object> mapValuesBlockTower = new HashMap<>();
        mapValuesBlockTower.put("referenciaExternaProjeto", externalReferenceProject);

        // Create Request
        EndpointConfig endpointConfigBlockTower = getEndpointConfig((ImobPath.PATH_BLOCK_TOWER));
        endpointConfigBlockTower.setBody(endpointConfigBlockTower.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BLOCK_TOWER_SAVE, mapValuesBlockTower));

        // Call endpoint
        Response responseBlockTower = MethodRest.callPost(endpointConfigBlockTower);

        // Check Response
        CheckResponse.checkHttpCode(201, responseBlockTower);
        CheckResponse.checkTextInJson("Created", responseBlockTower);


        //**************************** AUTHORIZE OPT-IN ************************************************************

        // Create dynamic variables
        HashMap<String, Object> mapValuesAuthorizeOptin = new HashMap<>();
        mapValuesAuthorizeOptin.put("referenciaExternaProjeto", externalReferenceProject);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_AUTHORIZE_OPTIN);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_AUTHORIZE_OPTIN,mapValuesAuthorizeOptin));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkHttpCode(201, response);
        CheckResponse.checkTextInJson("Created", response);
    }

    @Test
    public void rn004_105002() throws IOException {

        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("referenciaExternaProjeto", externalReferenceProject);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_AUTHORIZE_OPTIN);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_AUTHORIZE_OPTIN_RN004_105002, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("105002",  response);
        CheckResponse.checkTextInJson("CNPJ DO EMPREENDIMENTO OBRIGATORIO", response);

    }
    @Test
    public void rn004_105004() throws IOException {

        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("referenciaExternaProjeto", externalReferenceProject);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_AUTHORIZE_OPTIN);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_AUTHORIZE_OPTIN_RN004_105004, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("105004",  response);
        CheckResponse.checkTextInJson("DATA DE INICIO OBRIGATORIA", response);

    }
    @Test
    public void rn004_105006() throws IOException {

        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("referenciaExternaProjeto", externalReferenceProject);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_AUTHORIZE_OPTIN);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_AUTHORIZE_OPTIN_RN004_105006, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("105006",  response);
        CheckResponse.checkTextInJson("DATA FIM OBRIGATORIA", response);

    }
    @Test
    public void rn004_105010() throws IOException {

        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("referenciaExternaProjeto", externalReferenceProject);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_AUTHORIZE_OPTIN);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_AUTHORIZE_OPTIN_RN004_105010, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("105010",  response);
        CheckResponse.checkTextInJson("FINANCIADOR OBRIGATORIO", response);

    }
    @Test
    public void rn004_105016() throws IOException {

        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("referenciaExternaProjeto", externalReferenceProject);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_AUTHORIZE_OPTIN);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_AUTHORIZE_OPTIN_RN004_105016,mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("105016",  response);
        CheckResponse.checkTextInJson("APROVAR OPT IN OBRIGATORIO", response);

    }
    @Test
    public void rn005() throws IOException {

        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("referenciaExternaProjeto", externalReferenceProject);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_AUTHORIZE_OPTIN);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_AUTHORIZE_OPTIN_RN005,mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("105001",  response);
        CheckResponse.checkTextInJson("FINANCIADOR INVALIDO", response);

    }
    @Test
    public void rn006() throws IOException {

        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("referenciaExternaProjeto", externalReferenceProject);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_AUTHORIZE_OPTIN);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_AUTHORIZE_OPTIN_RN006,mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("105003",  response);
        CheckResponse.checkTextInJson("CNPJ DO EMPREENDIMENTO INVALIDO", response);

    }
    @Test
    public void rn007_105005() throws IOException {

        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("referenciaExternaProjeto", externalReferenceProject);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_AUTHORIZE_OPTIN);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_AUTHORIZE_OPTIN_RN007_105005,mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("105005",  response);
        CheckResponse.checkTextInJson("DATA DE INICIO INVALIDA", response);

    }
    @Test
    public void rn007_105007() throws IOException {

        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("referenciaExternaProjeto", externalReferenceProject);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_AUTHORIZE_OPTIN);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_AUTHORIZE_OPTIN_RN007_105007,mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("105007",  response);
        CheckResponse.checkTextInJson("DATA FIM INVALIDA", response);

    }
    @Test
    public void rn008() throws IOException {

        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("referenciaExternaProjeto", externalReferenceProject);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_AUTHORIZE_OPTIN);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_AUTHORIZE_OPTIN_RN008,mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("105017",  response);
        CheckResponse.checkTextInJson("APROVAR OPT IN INVALIDO", response);

    }
    @Test
    public void rn009() throws IOException {

        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("referenciaExternaProjeto", externalReferenceProject);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_AUTHORIZE_OPTIN);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_AUTHORIZE_OPTIN_RN009,mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("105012",  response);
        CheckResponse.checkTextInJson("TIPO DE LIBERACAO INVALIDO", response);

    }
    @Test
    public void rn010() throws IOException {

        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("referenciaExternaProjeto", externalReferenceProject);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_AUTHORIZE_OPTIN);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_AUTHORIZE_OPTIN_RN010,mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("105001",  response);
        CheckResponse.checkTextInJson("FINANCIADOR INVALIDO", response);

    }
    @Test
    public void rn011() throws IOException {

        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("referenciaExternaProjeto", externalReferenceProject);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_AUTHORIZE_OPTIN);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_AUTHORIZE_OPTIN_RN011,mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("105003",  response);
        CheckResponse.checkTextInJson("CNPJ DO EMPREENDIMENTO INVALIDO", response);

    }
    @Test
    public void rn012() throws IOException {

        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("referenciaExternaProjeto", externalReferenceProject);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_AUTHORIZE_OPTIN);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_AUTHORIZE_OPTIN_RN012,mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("105011",  response);
        CheckResponse.checkTextInJson("TIPO DE LIBERACAO OBRIGATORIO", response);

    }
    @Test
    public void rn013() throws IOException {

        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("referenciaExternaProjeto", externalReferenceProject);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_AUTHORIZE_OPTIN);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_AUTHORIZE_OPTIN_RN013,mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("105013",  response);
        CheckResponse.checkTextInJson("QUADRAS/TORRES OBRIGATORIO", response);

    }
    //@Test AJUSTAR CENÁRIO ASSIM QUE O AUTORIZAR COM SUCESSO VOLTAR A FUNCIONAR TODO
    public void rn014() throws IOException {

        //HashMap<String, Object> mapValues = new HashMap<>();
        //mapValues.put("referenciaExternaProjeto", externalReferenceProject);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_AUTHORIZE_OPTIN);
        endpointConfig.setBody(endpointConfig.setJsonFileBodyArray(ImobFileJson.PATH_JSON_AUTHORIZE_OPTIN_RN014));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("105014",  response);
        CheckResponse.checkTextInJson("QUADRAS/TORRES INVALIDO", response);

    }
    @Test
    public void rn016() throws IOException {

        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("referenciaExternaProjeto", externalReferenceProject);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_AUTHORIZE_OPTIN);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_AUTHORIZE_OPTIN_RN016,mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("105015",  response);
        CheckResponse.checkTextInJson("PROTOCOLO INVALIDO", response);

    }
    @Test
    public void rn020() throws IOException {

        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("referenciaExternaProjeto", externalReferenceProject);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_AUTHORIZE_OPTIN);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_AUTHORIZE_OPTIN_RN020,mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("105018",  response);
        CheckResponse.checkTextInJson("EMPREENDIMENTO INATIVO", response);

    }

    @Test
    public void rn021() throws IOException {

        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("referenciaExternaProjeto", externalReferenceProject);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_AUTHORIZE_OPTIN);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_AUTHORIZE_OPTIN_RN021,mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("105020",  response);
        CheckResponse.checkTextInJson("REFERENCIA EXTERNA PROJETO NAO EXISTE", response);

    }

    @Test
    public void rn022() throws IOException {

        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("referenciaExternaProjeto", externalReferenceProject);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_AUTHORIZE_OPTIN);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_AUTHORIZE_OPTIN_RN022,mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("105021",  response);
        CheckResponse.checkTextInJson("NAO E POSSIVEL INSERIR QUADRA/TORRE PARA TIPO DE LIBERACAO TOTAL", response);

    }
}
