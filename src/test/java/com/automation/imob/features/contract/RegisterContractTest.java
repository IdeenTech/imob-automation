package com.automation.imob.features.contract;

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
public class RegisterContractTest extends ImobApplicationTests{
    //store set value
    private String bankAddresExternalRef;
    private String externalRefProject;
    private String identifierBlockTower;
    private String identifierUnity;
    private String externalRefContract;

    @BeforeAll
    public void save() throws IOException {
        //Declare value identifiers: BlockTower and BankAddress
        externalRefProject = getDataFaker().getExternalReference("refExternaProject-");
        identifierBlockTower = getDataFaker().getExternalReference("blocktowerIdentifier-");
        identifierUnity = getDataFaker().getExternalReference("unityIdentifier-");
        externalRefContract = getDataFaker().getExternalReference("contractIdentifier-");

        //Response Create BlockTower
        Response response = createContract(bankAddresExternalRef, externalRefProject, identifierBlockTower, identifierUnity, externalRefContract);

        // Check response
        CheckResponse.checkHttpCode(201, response);
        CheckResponse.checkTextInJson("Created", response);

    }

    public HashMap<String, Object> getCommonsValues() {
        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("domicilioBancario", bankAddresExternalRef);
        mapValues.put("referenciaExternaProjeto", externalRefProject);
        mapValues.put("referenciaExternaContrato", externalRefContract);
        mapValues.put("quadraTorre", identifierBlockTower);
        mapValues.put("unidade", identifierUnity);

        return mapValues;
    }

    @Test
    public void rn010_103001() throws IOException{
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("tipoOperacao", "");

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_CONTRACT);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_CONTRACT_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("103001", response);
        CheckResponse.checkTextInJson("TIPO DE OPERACAO OBRIGATORIO", response);

    }

    @ParameterizedTest
    @MethodSource("operationType")
    public void rn010_103003(final String operationType) throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("referenciaExternaContrato", externalRefContract);
        mapValues.put("quadraTorre", identifierBlockTower);
        mapValues.put("unidade", identifierUnity);
        mapValues.put("domicilioBancario", bankAddresExternalRef);
        mapValues.put("referenciaExternaProjeto", "");
        mapValues.put("tipoOperacao", operationType);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_CONTRACT);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_CONTRACT_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("103003", response);
        CheckResponse.checkTextInJson("REFERENCIA EXTERNA PROJETO OBRIGATORIA", response);
    }

    @ParameterizedTest
    @MethodSource("operationType")
    public void rn010_103005(final String operationType) throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("quadraTorre", identifierBlockTower);
        mapValues.put("unidade", identifierUnity);
        mapValues.put("domicilioBancario", bankAddresExternalRef);
        mapValues.put("referenciaExternaProjeto", externalRefProject);
        mapValues.put("referenciaExternaContrato", "");
        mapValues.put("tipoOperacao", operationType);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_CONTRACT);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_CONTRACT_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("103005", response);
        CheckResponse.checkTextInJson("REFERENCIA EXTERNA CONTRATO OBRIGATORIA", response);
    }


    @Test
    public void rn010_103007() throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("unidade", identifierUnity);
        mapValues.put("domicilioBancario", bankAddresExternalRef);
        mapValues.put("referenciaExternaProjeto", externalRefProject);
        mapValues.put("referenciaExternaContrato", externalRefContract);
        mapValues.put("quadraTorre", "");

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_CONTRACT);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_CONTRACT_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("103007", response);
        CheckResponse.checkTextInJson("IDENTIFICADOR DA QUADRA TORRE OBRIGATORIO", response);
    }

    @Test
    public void rn010_103009() throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("domicilioBancario", bankAddresExternalRef);
        mapValues.put("referenciaExternaProjeto", externalRefProject);
        mapValues.put("referenciaExternaContrato", externalRefContract);
        mapValues.put("quadraTorre", identifierBlockTower);
        mapValues.put("unidade", "");

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_CONTRACT);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_CONTRACT_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("103009", response);
        CheckResponse.checkTextInJson("IDENTIFICADOR DA UNIDADE OBRIGATORIO", response);
    }

    @Test
    public void rn010_103011() throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("porcentagemMoraMes", "");

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_CONTRACT);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_CONTRACT_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("103011", response);
        CheckResponse.checkTextInJson("PERCENTUAL MORA AO MES OBRIGATORIO", response);
    }

    @Test
    public void rn010_103012() throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("porcentagemMulta", "");

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_CONTRACT);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_CONTRACT_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("103012", response);
        CheckResponse.checkTextInJson("PERCENTUAL MULTA OBRIGATORIO", response);
    }

    @Test
    public void rn010_103013() throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("dataAssinatura", "");

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_CONTRACT);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_CONTRACT_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("103013", response);
        CheckResponse.checkTextInJson("DATA ASSINATURA OBRIGATORIA", response);
    }

    @Test
    public void rn010_103015() throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("tipoContrato", "");

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_CONTRACT);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_CONTRACT_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("103015", response);
        CheckResponse.checkTextInJson("CONTRATO TIPO OBRIGATORIO", response);
    }

    @Test
    public void rn010_103017() throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("valor", "");

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_CONTRACT);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_CONTRACT_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("103017", response);
        CheckResponse.checkTextInJson("VALOR OBRIGATORIO", response);
    }

    @Test
    public void rn010_103018() throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("metodoAmortizacao", "");

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_CONTRACT);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_CONTRACT_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("103018", response);
        CheckResponse.checkTextInJson("METODO AMORTIZACAO OBRIGATORIO", response);
    }

    @Test
    public void rn010_103020() throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("indicePrecoPreObra", "");

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_CONTRACT);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_CONTRACT_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("103020", response);
        CheckResponse.checkTextInJson("INDICE DE PRECOS PRE OBRA OBRIGATORIO", response);
    }

    @Test
    public void rn010_103024() throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("jurosAA", "");

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_CONTRACT);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_CONTRACT_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("103024", response);
        CheckResponse.checkTextInJson("JUROS AO ANO OBRIGATORIO", response);
    }

    @Test
    public void rn010_103025() throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("aplicacaoJuros", "");

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_CONTRACT);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_CONTRACT_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("103025", response);
        CheckResponse.checkTextInJson("APLICACAO DO JUROS OBRIGATORIO", response);
    }

    @Test
    public void rn010_103031() throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("statusContrato", "");

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_CONTRACT);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_CONTRACT_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("103031", response);
        CheckResponse.checkTextInJson("STATUS DO CONTRATO OBRIGATORIO", response);
    }

    @Test
    public void rn010_103033() throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("jaRenegociado", "");

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_CONTRACT);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_CONTRACT_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("103033", response);
        CheckResponse.checkTextInJson("JA FOI RENECEGOCIADO OBRIGATORIO", response);
    }

    @ParameterizedTest
    @ValueSource(strings = {"20-10", "2022-14", "203-09", "A"})
    public void rn010_103014(String invalidDateAs) throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("dataAssinatura", invalidDateAs);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_CONTRACT);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_CONTRACT_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("103014", response);
        CheckResponse.checkTextInJson("DATA ASSINATURA INVALIDA", response);
    }

    @ParameterizedTest
    @ValueSource(strings = {"20-10", "2022-14", "203-09", "A"})
    public void rn010_103029(String invalidDate) throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("dataDistrato", invalidDate);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_CONTRACT);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_CONTRACT_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("103029", response);
        CheckResponse.checkTextInJson("DATA DO DISTRATO INVALIDA", response);
    }

    @DisplayName("rn010_103037(Create) Testing invalid dates ")
    @ParameterizedTest
    @ValueSource(strings = {"20-10", "2022-14", "203-09", "A"})
    public void rn010_103037_create(String invalidDate) throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("dataBloqueioFaturamentoContrato", invalidDate);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_CONTRACT);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_CONTRACT_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("103037", response);
        CheckResponse.checkTextInJson("DATA DO BLOQUEIO OU DESBLOQUEIO DE FATURAMENTO DO CONTRATO INVALIDA", response);
    }

    @DisplayName("rn012 testing invalid operation Type")
    @ParameterizedTest
    @ValueSource(strings = {"b", "B", "1", "AA"})
    public void rn012(String invalidOperationType) throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("tipoOperacao", invalidOperationType);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_CONTRACT);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_CONTRACT_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("103002", response);
        CheckResponse.checkTextInJson("TIPO DE OPERACAO INVALIDO", response);
    }

    @DisplayName("rn013 Testing invalid contract type")
    @ParameterizedTest
    @ValueSource(strings = {"123", "9999", "a", "A", "99", "9"})
    public void rn013(String invalidContract) throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("tipoContrato", invalidContract);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_CONTRACT);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_CONTRACT_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("103016", response);
        CheckResponse.checkTextInJson("CONTRATO TIPO INVALIDO", response);
    }


    @DisplayName("rn014(create) Testing invalid amortization method")
    @ParameterizedTest
    @ValueSource(strings = {"123", "9999", "a", "A", "99", "9", "004",})
    public void rn014_create(String invalidContract) throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("metodoAmortizacao", invalidContract);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_CONTRACT);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_CONTRACT_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("103019", response);
        CheckResponse.checkTextInJson("METODO AMORTIZACAO INVALIDO", response);
    }

    @DisplayName("rn015 Testing invalid pre-work price indexes")
    @ParameterizedTest
    @ValueSource(strings = {"123", "9999", "a", "A", "99", "9", "007"})
    public void rn015(String invalidPricesPre) throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("indicePrecoPreObra", invalidPricesPre);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_CONTRACT);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_CONTRACT_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("103021", response);
        CheckResponse.checkTextInJson("INDICE DE PRECOS PRE OBRA INVALIDO", response);
    }

    @DisplayName("rn016 Testing invalid post work price indexes")
    @ParameterizedTest
    @ValueSource(strings = {"123", "9999", "a", "A", "99", "9","007"})
    public void rn016(String invalidPricesPos) throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("indicePrecoPosObra", invalidPricesPos);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_CONTRACT);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_CONTRACT_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("103023", response);
        CheckResponse.checkTextInJson("INDICE DE PRECOS POS OBRA INVALIDO", response);
    }


    @DisplayName("rn017 Testing application of invalid interest")
    @ParameterizedTest
    @ValueSource(strings = {"123", "9999", "a", "A", "99", "9","003"})
    public void rn017(String invalidInter) throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("aplicacaoJuros", invalidInter);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_CONTRACT);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_CONTRACT_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("103026", response);
        CheckResponse.checkTextInJson("APLICACAO DO JUROS INVALIDO", response);
    }

    @DisplayName("rn018(Create) Testing invalid contract status")
    @ParameterizedTest
    @ValueSource(strings = {"123", "9999", "a", "A", "99", "9","008"})
    public void rn018_create(String invalidStatus) throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("statusContrato", invalidStatus);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_CONTRACT);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_CONTRACT_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("103032", response);
        CheckResponse.checkTextInJson("STATUS DO CONTRATO INVALIDO", response);
    }

    @DisplayName("rn019 Testing invalid has already been renegotiated")
    @ParameterizedTest
    @ValueSource(strings = {"9", "s", "AAA", "N9"})
    public void rn019(String invalidRenegotiated) throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("jaRenegociado", invalidRenegotiated);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_CONTRACT);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_CONTRACT_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("103034", response);
        CheckResponse.checkTextInJson("JA FOI RENEGOCIADO INVALIDO", response);
    }

    @DisplayName("rn020(Create) invalid contract billing block")
    @ParameterizedTest
    @ValueSource(strings = {"123", "9999", "a", "A", "99", "9","002"})
    public void rn020_create(String invalidBillingBlock) throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("bloqueioFaturamentoContrato", invalidBillingBlock);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_CONTRACT);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_CONTRACT_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("103036", response);
        CheckResponse.checkTextInJson("BLOQUEIO DE FATURAMENTO DO CONTRATO INVALIDO", response);
    }

    @ParameterizedTest
    @MethodSource("operationType")
    public void rn021(final String operationType) throws IOException {
        String fakeExternalRef = getDataFaker().getExternalReference("externalref--");

        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("referenciaExternaContrato", externalRefContract);
        mapValues.put("quadraTorre", identifierBlockTower);
        mapValues.put("unidade", identifierUnity);
        mapValues.put("domicilioBancario", bankAddresExternalRef);
        mapValues.put("tipoOperacao", operationType);
        mapValues.put("referenciaExternaProjeto", fakeExternalRef);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_CONTRACT);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_CONTRACT_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("103004", response);
        CheckResponse.checkTextInJson("REFERENCIA EXTERNA PROJETO NAO EXISTE", response);
    }

    @ParameterizedTest
    @MethodSource("operationType")
    public void rn022(final String operationType) throws IOException {

        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("referenciaExternaContrato", externalRefContract);
        mapValues.put("quadraTorre", identifierBlockTower);
        mapValues.put("unidade", identifierUnity);
        mapValues.put("domicilioBancario", bankAddresExternalRef);
        mapValues.put("referenciaExternaProjeto", externalRefProject);
        mapValues.put("tipoOperacao", operationType);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_CONTRACT);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_CONTRACT_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);
        response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("103006", response);
        CheckResponse.checkTextInJson("REFERENCIA EXTERNA CONTRATO JA EXISTE", response);
    }

    @ParameterizedTest
    @MethodSource("operationType")
    public void rn023(final String operationType) throws IOException {
        String fakeBlockTower = getDataFaker().getExternalReference("blockTowerExternal-");

        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("referenciaExternaContrato", externalRefContract);
        mapValues.put("unidade", identifierUnity);
        mapValues.put("domicilioBancario", bankAddresExternalRef);
        mapValues.put("referenciaExternaProjeto", externalRefProject);
        mapValues.put("tipoOperacao", operationType);
        mapValues.put("quadraTorre", fakeBlockTower);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_CONTRACT);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_CONTRACT_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("103008", response);
        CheckResponse.checkTextInJson("IDENTIFICADOR DA QUADRA TORRE INVALIDO", response);
    }

    @ParameterizedTest
    @MethodSource("operationType")
    public void rn024(final String operationType) throws IOException {
        String fakeUnity = getDataFaker().getExternalReference("unityExternal-");

        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("referenciaExternaContrato", externalRefContract);
        mapValues.put("domicilioBancario", bankAddresExternalRef);
        mapValues.put("quadraTorre", identifierBlockTower);
        mapValues.put("referenciaExternaProjeto", externalRefProject);
        mapValues.put("tipoOperacao", operationType);
        mapValues.put("unidade", fakeUnity);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_CONTRACT);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_CONTRACT_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("103010", response);
        CheckResponse.checkTextInJson("IDENTIFICADOR DA UNIDADE INVALIDO", response);
    }

    @ParameterizedTest
    @MethodSource("operationType")
    public void rn025(final String operationType) throws IOException {
        String fakeBankAddress = getDataFaker().getExternalReference("unityExternal-");

        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("referenciaExternaContrato", externalRefContract);
        mapValues.put("unidade", identifierUnity);
        mapValues.put("quadraTorre", identifierBlockTower);
        mapValues.put("referenciaExternaProjeto", externalRefProject);
        mapValues.put("tipoOperacao", operationType);
        mapValues.put("domicilioBancario", fakeBankAddress);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_CONTRACT);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_CONTRACT_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("103035", response);
        CheckResponse.checkTextInJson("DOMICILIO BANCARIO INVALIDO", response);
    }

    @ParameterizedTest
    @ValueSource(strings = {"A","a","1","NN", "s"})
    public void rn029(String invalidlien) throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("gravameOnus", invalidlien);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_CONTRACT);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_CONTRACT_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("103087", response);
        CheckResponse.checkTextInJson("GRAVAME/ONUS INVALIDO", response);
    }

    @DisplayName("rn036(create) testing invalid percentages")
    @ParameterizedTest
    @ValueSource(strings = {"9,99", "99,99", "a"})
    public void rn036_create(String invalidPercentage) throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("porcentagemMoraMes", invalidPercentage);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_CONTRACT);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_CONTRACT_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("100008", response);
        CheckResponse.checkTextInJson("PORCENTAGEM MORA MES DEVE SER NO MAXIMO DECIMAL(3,2)", response);
    }

    @DisplayName("rn037(create) testing invalid percentages")
    @ParameterizedTest
    @ValueSource(strings = {"9,99", "99,99", "a"})
    public void rn037_create(String invalidPercentage) throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("porcentagemMulta", invalidPercentage);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_CONTRACT);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_CONTRACT_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("100008", response);
        CheckResponse.checkTextInJson("PORCENTAGEM MULTA DEVE SER NO MAXIMO DECIMAL(3,2)", response);
    }

    @DisplayName("rn038(create) testing invalid percentages")
    @ParameterizedTest
    @ValueSource(strings = {"10,0"})
    public void rn038_create(String invalidPercentage) throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("valor", invalidPercentage);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_CONTRACT);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_CONTRACT_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("100008", response);
        CheckResponse.checkTextInJson("VALOR DEVE SER NO MAXIMO DECIMAL (10,2)", response);
    }

    @DisplayName("rn039(create) testing invalid percentages")
    @ParameterizedTest
    @ValueSource(strings = {"9,99", "99,99", "a"})
    public void rn039_create(String invalidPercentage) throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("jurosAA", invalidPercentage);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_CONTRACT);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_CONTRACT_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("100008", response);
        CheckResponse.checkTextInJson("JUROS AA DEVE SER NO MAXIMO DECIMAL (3,2)", response);
    }

    @DisplayName("rn040(create) testing invalid assessments")
    @ParameterizedTest
    @ValueSource(strings = {"99,99", "aaa"})
    public void rn040_create(String invalidAssessment) throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("avaliacao", invalidAssessment);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_CONTRACT);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_CONTRACT_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("100005", response);
        CheckResponse.checkTextInJson("AVALIACAO DEVE CONTER NO MAXIMO 2 POSICOES", response);
    }

    @DisplayName("rn044 testing invalid percentages")
    @ParameterizedTest
    @ValueSource(strings = {"99,99", "99", "9,99", "a", "10,3"})
    public void rn044(String invalidPercentage) throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("valor", invalidPercentage);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_CONTRACT);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_CONTRACT_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("100008", response);
        CheckResponse.checkTextInJson("VALOR A DEVOLVER DEVE SER NO MAXIMO DECIMAL (10,2)", response);
    }








    /*---------------------------------------------------- EDIT METHODS --------------------------------------------*/

    @DisplayName("rn010_103037(Edit) Testing invalid dates ")
    @ParameterizedTest
    @ValueSource(strings = {"20-10", "2022-14", "203-09", "A"})
    public void rn010_103037_edit(String invalidDate) throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("dataBloqueioFaturamentoContrato", invalidDate);
        mapValues.put("tipoOperacao", "A");

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_CONTRACT);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_CONTRACT_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("103037", response);
        CheckResponse.checkTextInJson("DATA DO BLOQUEIO OU DESBLOQUEIO DE FATURAMENTO DO CONTRATO INVALIDA", response);
    }

    @DisplayName("rn014(edit) Testing invalid amortization method")
    @ParameterizedTest
    @ValueSource(strings = {"20-10", "2022-14", "203-09", "A"})
    public void rn014_edit(String invalidContract) throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("tipoContrato", invalidContract);
        mapValues.put("tipoOperacao", "A");

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_CONTRACT);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_CONTRACT_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("103019", response);
        CheckResponse.checkTextInJson("METODO AMORTIZACAO INVALIDO", response);
    }

    @DisplayName("rn018(edit) Testing application of invalid interest")
    @ParameterizedTest
    @ValueSource(strings = {"123", "9999", "a", "A", "99", "9","008"})
    public void rn018_edit(String invalidStatus) throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("statusContrato", invalidStatus);
        mapValues.put("tipoOperacao", "A");

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_CONTRACT);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_CONTRACT_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("103032", response);
        CheckResponse.checkTextInJson("STATUS DO CONTRATO INVALIDO", response);
    }

    @DisplayName("rn020(edit) invalid contract billing block")
    @ParameterizedTest
    @ValueSource(strings = {"123", "9999", "a", "A", "99", "9","002"})
    public void rn020_edit(String invalidBillingBlock) throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("bloqueioFaturamentoContrato", invalidBillingBlock);
        mapValues.put("tipoOperacao", "A");

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_CONTRACT);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_CONTRACT_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("103036", response);
        CheckResponse.checkTextInJson("BLOQUEIO DE FATURAMENTO DO CONTRATO INVALIDO", response);
    }

    @DisplayName("rn036_edit testing invalid percentages")
    @ParameterizedTest
    @ValueSource(strings = {"9,99", "99,99", "a"})
    public void rn036_edit(String invalidPercentage) throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("porcentagemMoraMes", invalidPercentage);
        mapValues.put("tipoOperacao", "A");

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_CONTRACT);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_CONTRACT_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("100008", response);
        CheckResponse.checkTextInJson("PORCENTAGEM MORA MES DEVE SER NO MAXIMO DECIMAL(3,2)", response);
    }

    @DisplayName("rn037(edit) testing invalid percentages")
    @ParameterizedTest
    @ValueSource(strings = {"9,99", "99,99", "a"})
    public void rn037_edit(String invalidPercentage) throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("porcentagemMulta", invalidPercentage);
        mapValues.put("tipoOperacao", "A");

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_CONTRACT);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_CONTRACT_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("100008", response);
        CheckResponse.checkTextInJson("PORCENTAGEM MULTA DEVE SER NO MAXIMO DECIMAL(3,2)", response);
    }

    @DisplayName("rn038(edit) testing invalid percentages")
    @ParameterizedTest
    @ValueSource(strings = {"99,99", "99", "9,99", "a"})
    public void rn038_edit(String invalidPercentage) throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("valor", invalidPercentage);
        mapValues.put("tipoOperacao", "A");

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_CONTRACT);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_CONTRACT_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("100008", response);
        CheckResponse.checkTextInJson("VALOR DEVE SER NO MAXIMO DECIMAL (10,2)", response);
    }

    @DisplayName("rn039(edit) testing invalid percentages")
    @ParameterizedTest
    @ValueSource(strings = {"9,99", "99,99", "a"})
    public void rn039_edit(String invalidPercentage) throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("jurosAA", invalidPercentage);
        mapValues.put("tipoOperacao","A");

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_CONTRACT);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_CONTRACT_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("100008", response);
        CheckResponse.checkTextInJson("JUROS AA DEVE SER NO MAXIMO DECIMAL (3,2)", response);
    }
    @DisplayName("rn040(edit) testing invalid assessments")
    @ParameterizedTest
    @ValueSource(strings = {"99,99", "a", "aaa" })
    public void rn040_edit(String invalidAssessment) throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("avaliacao", invalidAssessment);
        mapValues.put("tipoOperacao", "A");

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_CONTRACT);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_CONTRACT_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("100005", response);
        CheckResponse.checkTextInJson("AVALIACAO DEVE CONTER NO MAXIMO 2 POSICOES", response);
    }
}