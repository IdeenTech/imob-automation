package com.automation.imob.features.unity;

import com.automation.imob.ImobApplicationTests;
import com.automation.imob.components.MethodRest;
import com.automation.imob.components.config.EndpointConfig;
import com.automation.imob.components.result.CheckResponse;
import com.automation.imob.config.ImobFileJson;
import com.automation.imob.config.ImobPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.IOException;
import java.util.HashMap;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class RegisterAndUpdateUnityTest extends ImobApplicationTests {

    // Store set value
    private String bankAddressExternalRef;
    private String externalRefProject;
    private String identifierBlockTower;
    private String identifierUnity;

    @BeforeAll
    public void save() throws IOException {

        //Declare value identifiers: BlockTower and BankAddress
        bankAddressExternalRef = getDataFaker().getExternalReference("DomRefExterna-");
        externalRefProject = getDataFaker().getExternalReference("refExternaProject-");
        identifierBlockTower = getDataFaker().getExternalReference("blockToweridentifier-");
        identifierUnity = getDataFaker().getExternalReference("UnityIdentifier-");

        //Response create Unity
        Response response = createUnity(bankAddressExternalRef, externalRefProject, identifierBlockTower, identifierUnity);

        CheckResponse.checkHttpCode(201, response);
        CheckResponse.checkTextInJson("Created", response);

    }

    public HashMap<String, Object> getCommonsValues() {
        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("domicilioBancario", bankAddressExternalRef);
        mapValues.put("referenciaExternaProjeto", externalRefProject);
        mapValues.put("identificadorQuadraTorre", identifierBlockTower);

        return mapValues;
    }

    @Test
    public void rn013() throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("tipoOperacao", "3");

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_UNITY);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_UNITY_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("102002", response);
        CheckResponse.checkTextInJson("TIPO DE OPERACAO INVALIDO", response);
    }

    @Test
    public void rn014_102001() throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("tipoOperacao", "");

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_UNITY);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_UNITY_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("102001", response);
        CheckResponse.checkTextInJson("TIPO DE OPERACAO OBRIGATORIO", response);
    }

    @ParameterizedTest
    @MethodSource("operationType")
    public void rn014_102003(String operationType) throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("tipoOperacao", operationType);
        mapValues.put("referenciaExternaProjeto", "");


        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_UNITY);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_UNITY_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("102003", response);
        CheckResponse.checkTextInJson("REFERENCIA EXTERNA PROJETO OBRIGATORIA", response);
    }

    @ParameterizedTest
    @MethodSource("operationType")
    public void rn014_102005(String operationType) throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("tipoOperacao", operationType);
        mapValues.put("identificadorQuadraTorre", "");

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_UNITY);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_UNITY_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("102005", response);
        CheckResponse.checkTextInJson("IDENTIFICADOR DA QUADRA TORRE OBRIGATORIO", response);
    }

    @ParameterizedTest
    @MethodSource("operationType")
    public void rn014_102021(String operationType) throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("tipoOperacao", operationType);
        mapValues.put("identificadorUnidade", "");

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_UNITY);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_UNITY_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("102021", response);
        CheckResponse.checkTextInJson("IDENTIFICADOR DA UNIDADE OBRIGATORIO", response);
    }

    @ParameterizedTest
    @MethodSource("operationType")
    public void rn014_102022(String operationType) throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("tipoOperacao", operationType);
        mapValues.put("tipoImovel", "");

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_UNITY);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_UNITY_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("102022", response);
        CheckResponse.checkTextInJson("TIPO DO IMOVEL OBRIGATORIO", response);
    }

    @ParameterizedTest
    @MethodSource("operationType")
    public void rn014_102025(String operationType) throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("tipoOperacao", operationType);
        mapValues.put("fracaoIdealTipo", "");

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_UNITY);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_UNITY_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("102025", response);
        CheckResponse.checkTextInJson("FRACAO IDEAL TIPO OBRIGATORIO", response);
    }

    @ParameterizedTest
    @MethodSource("operationType")
    public void rn014_102027(String operationType) throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("tipoOperacao", operationType);
        mapValues.put("fracaoIdeal", "");

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_UNITY);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_UNITY_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("102027", response);
        CheckResponse.checkTextInJson("FRACAO IDEAL OBRIGATORIO", response);
    }

    @ParameterizedTest
    @MethodSource("operationType")
    public void rn014_102029(String operationType) throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("tipoOperacao", operationType);
        mapValues.put("metragemTotal", "");

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_UNITY);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_UNITY_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("102029", response);
        CheckResponse.checkTextInJson("METRAGEM TOTAL OBRIGATORIO", response);
    }

    @ParameterizedTest
    @MethodSource("operationType")
    public void rn014_102030(String operationType) throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("tipoOperacao", operationType);
        mapValues.put("metragemUtil", "");

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_UNITY);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_UNITY_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("102030", response);
        CheckResponse.checkTextInJson("METRAGEM UTIL OBRIGATORIO", response);
    }

    @ParameterizedTest
    @MethodSource("operationType")
    public void rn014_102031(String operationType) throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("tipoOperacao", operationType);
        mapValues.put("pavimento", "");

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_UNITY);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_UNITY_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("102031", response);
        CheckResponse.checkTextInJson("PAVIMENTO OBRIGATORIO", response);
    }

    @ParameterizedTest
    @MethodSource("operationType")
    public void rn014_102032(String operationType) throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("tipoOperacao", operationType);
        mapValues.put("pavimento", "");

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_UNITY);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_UNITY_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("102031", response);
        CheckResponse.checkTextInJson("PAVIMENTO OBRIGATORIO", response);
    }

    @ParameterizedTest
    @MethodSource("operationType")
    public void rn014_102033(String operationType) throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("tipoOperacao", operationType);
        mapValues.put("precoM2", "");

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_UNITY);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_UNITY_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("102033", response);
        CheckResponse.checkTextInJson("PRECO M² OBRIGATORIO", response);
    }

    @ParameterizedTest
    @MethodSource("operationType")
    public void rn014_102034(String operationType) throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("tipoOperacao", operationType);
        mapValues.put("dataTabela", "");

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_UNITY);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_UNITY_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("102034", response);
        CheckResponse.checkTextInJson("DATA DA TABELA REF M² OBRIGATORIA", response);
    }

    @ParameterizedTest
    @MethodSource("operationType")
    public void rn014_102036(String operationType) throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("tipoOperacao", operationType);
        mapValues.put("identificacaoOnus", "");

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_UNITY);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_UNITY_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("102036", response);
        CheckResponse.checkTextInJson("IDENTIFICACAO ONUS OBRIGATORIO", response);
    }

    @ParameterizedTest
    @MethodSource("operationType")
    public void rn014_102038(String operationType) throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("tipoOperacao", operationType);
        mapValues.put("statusUnidade", "");

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_UNITY);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_UNITY_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("102038", response);
        CheckResponse.checkTextInJson("STATUS DA UNIDADE OBRIGATORIO", response);
    }

    @ParameterizedTest
    @MethodSource("operationType")
    public void rn014_102040(String operationType) throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("tipoOperacao", operationType);
        mapValues.put("classificacaoDirecionamentoUnidade", "");

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_UNITY);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_UNITY_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("102040", response);
        CheckResponse.checkTextInJson("CLASSIFICACAO DE DIRECIONAMENTO DA UNIDADE OBRIGATORIO", response);
    }

    @ParameterizedTest
    @DisplayName("rn015 Testing invalid immob")
    @ValueSource(strings = {"21", "A"})
    public void rn015(String invalidImmob) throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("tipoImovel", invalidImmob);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_UNITY);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_UNITY_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("102023", response);
        CheckResponse.checkTextInJson("TIPO DO IMOVEL INVALIDO", response);
    }

    @ParameterizedTest
    @DisplayName("rn016 Testing invalid date")
    @ValueSource(strings = {"20-10", "2022-15", "203-09", "A"})
    public void rn016_102013_create(String invalidDate) throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("dataHabiteSeReal", invalidDate);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_UNITY);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_UNITY_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("102013", response);
        CheckResponse.checkTextInJson("DATA HABITE SE REAL INVALIDA", response);
    }

    @ParameterizedTest
    @DisplayName("rn016 Testing invalid date")
    @ValueSource(strings = {"20-10", "2022-15", "203-09", "A"})
    public void rn016_102035_create(String invalidDate) throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("dataTabela", invalidDate);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_UNITY);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_UNITY_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("102035", response);
        CheckResponse.checkTextInJson("DATA DA TABELA REF M² INVALIDA", response);
    }

    @ParameterizedTest
    @DisplayName("rn016 Testing invalid date")
    @ValueSource(strings = {"20-10", "2022-15", "203-09", "A"})
    public void rn016_102042_create(String invalidDate) throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("dataQuitacaoAntesRegistro", invalidDate);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_UNITY);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_UNITY_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("102042", response);
        CheckResponse.checkTextInJson("DATA QUITACAO ANTES DO REGISTRO INVALIDA", response);
    }

    @ParameterizedTest
    @MethodSource("operationType")
    public void rn017(String operationType) throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("tipoOperacao", operationType);
        mapValues.put("statusUnidade", "1");

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_UNITY);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_UNITY_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("102039", response);
        CheckResponse.checkTextInJson("STATUS DA UNIDADE INVALIDO", response);
    }

    @ParameterizedTest
    @MethodSource("operationType")
    public void rn018(String operationType) throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("tipoOperacao", operationType);
        mapValues.put("classificacaoDirecionamentoUnidade", "6");

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_UNITY);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_UNITY_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("102041", response);
        CheckResponse.checkTextInJson("CLASSIFICACAO DE DIRECIONAMENTO DA UNIDADE INVALIDO", response);
    }

    @ParameterizedTest
    @MethodSource("operationType")
    public void rn019(String operationType) throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("tipoOperacao", operationType);
        mapValues.put("identificacaoOnus", "6");

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_UNITY);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_UNITY_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("102037", response);
        CheckResponse.checkTextInJson("IDENTIFICACAO ONUS INVALIDO", response);
    }

    @ParameterizedTest
    @MethodSource("operationType")
    public void rn020(String operationType) throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("tipoOperacao", operationType);
        mapValues.put("fracaoIdealTipo", "2");

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_UNITY);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_UNITY_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("102026", response);
        CheckResponse.checkTextInJson("FRACAO IDEAL TIPO INVALIDO", response);
    }

    @ParameterizedTest
    @MethodSource("operationType")
    public void rn021(String operationType) throws IOException {
        //generate random external reference project
        String invalidRefProject = getDataFaker().getExternalReference("invalidRefProject-");

        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("tipoOperacao", operationType);
        mapValues.put("identificadorUnidade", identifierUnity);
        mapValues.put("referenciaExternaProjeto", invalidRefProject);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_UNITY);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_UNITY_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("102004", response);
        CheckResponse.checkTextInJson("REFERENCIA EXTERNA PROJETO NAO EXISTE", response);
    }

    @ParameterizedTest
    @MethodSource("operationType")
    public void rn022(String operationType) throws IOException {

        //Declare value identifiers: BlockTower and BankAddress
        bankAddressExternalRef = getDataFaker().getExternalReference("DomRefExterna-");
        externalRefProject = getDataFaker().getExternalReference("refExternaProject-");
        identifierBlockTower = getDataFaker().getExternalReference("blockToweridentifier-");
        identifierUnity = getDataFaker().getExternalReference("UnityIdentifier-");
        //Response create Unity
        Response response = createUnity(bankAddressExternalRef, externalRefProject, identifierBlockTower, identifierUnity);

        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("tipoOperacao", operationType);

        // Check response
        CheckResponse.checkTextInJson("102050", response);
        CheckResponse.checkTextInJson("QUANTIDADE DE UNIDADES POR QUADRA TORRE DIFERENTE DO CADASTRADO", response);
    }

    @ParameterizedTest
    @MethodSource("operationType")
    public void rn023(String operationType) throws IOException {
        //generate random Block Tower value
        String invalidBlockTower = getDataFaker().getExternalReference("invalidBlockTower-");

        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("tipoOperacao", operationType);
        mapValues.put("identificadorQuadraTorre", invalidBlockTower);
        mapValues.put("identificadorUnidade", identifierUnity);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_UNITY);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_UNITY_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("102020", response);
        CheckResponse.checkTextInJson("IDENTIFICADOR DA QUADRA/TORRE INVALIDO", response);
    }

    @ParameterizedTest
    @MethodSource("operationType")
    public void rn025(String operationType) throws IOException {

        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("tipoOperacao", operationType);
        mapValues.put("identificadorUnidade", identifierUnity);
        mapValues.put("fracaoIdeal", "101");

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_UNITY);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_UNITY_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);
        // Check Response
        CheckResponse.checkTextInJson("102028", response);
        CheckResponse.checkTextInJson("FRACAO IDEAL INVALIDO", response);
    }

    @ParameterizedTest
    @MethodSource("operationType")
    public void rn026(String operationType) throws IOException {
        //generate random PayAddress value
        String invalidPayAddress = getDataFaker().getExternalReference("invalidPayAddress-");

        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("tipoOperacao", operationType);
        mapValues.put("identificadorUnidade", identifierUnity);
        mapValues.put("domicilioBancario", invalidPayAddress);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_UNITY);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_UNITY_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);
        // Check Response
        CheckResponse.checkTextInJson("102019", response);
        CheckResponse.checkTextInJson("DOMICILIO BANCARIO INVALIDO", response);
    }

    @Test
    public void rn028_create() throws IOException {
        //generate value for unity identifier
        String teste = getDataFaker().getExternalReference("UnityIdentifier-");

        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("identificadorUnidade", teste);
        mapValues.put("dataHabiteSeReal", "2023-01-01");

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_UNITY);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_UNITY_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("102051", response);
        CheckResponse.checkTextInJson("DATA HABITE-SE REAL DA QUADRA/TORRE NAO INFORMADA", response);
    }

    @ParameterizedTest
    @MethodSource("operationType")
    public void rn029_100008(String operationType) throws IOException {
        identifierUnity = getDataFaker().getExternalReference("tst - ");
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("tipoOperacao", operationType);
        mapValues.put("identificadorUnidade", identifierUnity);
        mapValues.put("fracaoIdealTipo", "0");
        mapValues.put("fracaoIdeal", "0.2222222");

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_UNITY);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_UNITY_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("100008", response);
        CheckResponse.checkTextInJson("FRACAO IDEAL DEVE SER NO MAXIMO DECIMAL (3,6)", response);
    }

    @ParameterizedTest
    @MethodSource("operationType")
    public void rn030(String operationType) throws IOException {
        identifierUnity = getDataFaker().getExternalReference("tst - ");
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("tipoOperacao", operationType);
        mapValues.put("identificadorUnidade", identifierUnity);
        mapValues.put("statusUnidade", "010");
        mapValues.put("identificacaoOnus", "001");

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_UNITY);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_UNITY_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("102037", response);
        CheckResponse.checkTextInJson("IDENTIFICACAO ONUS INVALIDO", response);
    }

    @Test
    public void rn031() throws IOException {

        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("domicilioBancario", bankAddressExternalRef);
        mapValues.put("referenciaExternaProjeto", externalRefProject);
        mapValues.put("identificadorQuadraTorre", identifierBlockTower);
        mapValues.put("identificadorUnidade", identifierUnity);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_UNITY);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_UNITY_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);
        response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("102059", response);
        CheckResponse.checkTextInJson("IDENTIFICADOR DA UNIDADE DUPLICADA", response);
    }

    @ParameterizedTest
    @MethodSource("operationType")
    public void rn034(String operationType) throws IOException {

        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("tipoOperacao", operationType);
        mapValues.put("identificadorUnidade", identifierUnity);
        mapValues.put("matriculaCartorio", "AAAAAAA");

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_UNITY);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_UNITY_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("102024", response);
        CheckResponse.checkTextInJson("NUMERO DA MATRICULA INVALIDO", response);
    }

    @ParameterizedTest
    @MethodSource("operationType")
    public void rn035(String operationType) throws IOException {

        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("tipoOperacao", operationType);
        mapValues.put("identificadorUnidade", identifierUnity);
        mapValues.put("metragemTotal", "999999,99");

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_UNITY);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_UNITY_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("100008", response);
        CheckResponse.checkTextInJson("METRAGEM TOTAL DEVE SER NO MAXIMO DECIMAL(5,2)", response);
    }

    @ParameterizedTest
    @MethodSource("operationType")
    public void rn036(String operationType) throws IOException {

        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("tipoOperacao", operationType);
        mapValues.put("identificadorUnidade", identifierUnity);
        mapValues.put("metragemUtil", "999999,99");

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_UNITY);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_UNITY_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("100008", response);
        CheckResponse.checkTextInJson("METRAGEM UTIL DEVE SER NO MAXIMO DECIMAL(5,2)", response);
    }

    @ParameterizedTest
    @MethodSource("operationType")
    public void rn037_100005(String operationType) throws IOException {

        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("tipoOperacao", operationType);
        mapValues.put("identificadorUnidade", identifierUnity);
        mapValues.put("pavimento", "9999");

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_UNITY);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_UNITY_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("100005", response);
        CheckResponse.checkTextInJson("PAVIMENTO DEVE CONTER NO MAXIMO 3 POSICOES", response);
    }

    @ParameterizedTest
    @MethodSource("operationType")
    public void rn037_102066(String operationType) throws IOException {

        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("tipoOperacao", operationType);
        mapValues.put("identificadorUnidade", identifierUnity);
        mapValues.put("pavimento", "Text");

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_UNITY);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_UNITY_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("102066", response);
        CheckResponse.checkTextInJson("PAVIMENTO INVALIDO", response);
    }

    @ParameterizedTest
    @MethodSource("operationType")
    public void rn038(String operationType) throws IOException {

        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("tipoOperacao", operationType);
        mapValues.put("identificadorUnidade", identifierUnity);
        mapValues.put("quantidadeDormitorios", "122");

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_UNITY);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_UNITY_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("100005", response);
        CheckResponse.checkTextInJson("QUANTIDADE DE DORMITORIOS DEVE CONTER NO MAXIMO 2 POSICOES", response);
    }

    @ParameterizedTest
    @MethodSource("operationType")
    public void rn039(String operationType) throws IOException {

        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("tipoOperacao", operationType);
        mapValues.put("identificadorUnidade", identifierUnity);
        mapValues.put("quantidadeGaragensPrivativas", "122");

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_UNITY);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_UNITY_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("100005", response);
        CheckResponse.checkTextInJson("QUANTIDADE DE GARAGENS PRIVATIVAS DEVE CONTER NO MAXIMO 2 POSICOES", response);
    }

    @ParameterizedTest
    @MethodSource("operationType")
    public void rn040(String operationType) throws IOException {

        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("tipoOperacao", operationType);
        mapValues.put("identificadorUnidade", identifierUnity);
        mapValues.put("precoM2", "9999999.99");

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_UNITY);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_UNITY_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("100008", response);
        CheckResponse.checkTextInJson("PRECO M² DEVE SER NO MAXIMO DECIMAL(6,2)", response);
    }
    //=================================Update===================================

    @ParameterizedTest
    @DisplayName("rn016 Testing invalid date")
    @ValueSource(strings = {"20-10", "2022-15", "203-09", "A"})
    public void rn016_102013_update(String invalidDate) throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("dataHabiteSeReal", invalidDate);
        mapValues.put("tipoOperacao", "A");

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_UNITY);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_UNITY_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("102013", response);
        CheckResponse.checkTextInJson("DATA HABITE SE REAL INVALIDA", response);
    }

    @ParameterizedTest
    @DisplayName("rn016 Testing invalid date")
    @ValueSource(strings = {"20-10", "2022-15", "203-09", "A"})
    public void rn016_102035_update(String invalidDate) throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("dataTabela", invalidDate);
        mapValues.put("tipoOperacao", "A");

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_UNITY);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_UNITY_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("102035", response);
        CheckResponse.checkTextInJson("DATA DA TABELA REF M² INVALIDA", response);
    }

    @ParameterizedTest
    @DisplayName("rn016 Testing invalid date")
    @ValueSource(strings = {"20-10", "2022-15", "203-09", "A"})
    public void rn016_102042_update(String invalidDate) throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("dataQuitacaoAntesRegistro", invalidDate);
        mapValues.put("tipoOperacao", "A");

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_UNITY);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_UNITY_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("102042", response);
        CheckResponse.checkTextInJson("DATA QUITACAO ANTES DO REGISTRO INVALIDA", response);
    }

    @Test
    public void rn028_update() throws IOException {
        identifierUnity = getDataFaker().getExternalReference("RN026 - ");
        createUnity(bankAddressExternalRef, externalRefProject, identifierBlockTower, identifierUnity);

        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("tipoOperacao", "A");
        mapValues.put("identificadorUnidade", identifierUnity);
        mapValues.put("dataHabiteSeReal", "2023-01-01");

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_UNITY);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_UNITY_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);


        // Check Response
        CheckResponse.checkTextInJson("102051", response);
        CheckResponse.checkTextInJson("DATA HABITE-SE REAL DA QUADRA/TORRE NAO INFORMADA", response);
    }

    @Test
    public void rn012_edit() throws IOException {
        identifierBlockTower = getDataFaker().getExternalReference("tst - ");

        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("tipoOperacao", "A");
        mapValues.put("identificadorUnidade", identifierUnity);
        mapValues.put("identificadorQuadraTorre", identifierBlockTower);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_UNITY);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_UNITY_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("102020", response);
        CheckResponse.checkTextInJson("IDENTIFICADOR DA QUADRA/TORRE INVALIDO", response);
    }

    @Test
    public void rn013_edit() throws IOException {
        identifierUnity = getDataFaker().getExternalReference("tst - ");

        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("tipoOperacao", "A");
        mapValues.put("identificadorUnidade", identifierUnity);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_UNITY);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_UNITY_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("102046", response);
        CheckResponse.checkTextInJson("IDENTIFICADOR DA UNIDADE INVALIDO", response);
    }

}
