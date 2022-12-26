package com.automation.imob.features.Building;

import com.automation.imob.ImobApplicationTests;
import com.automation.imob.components.MethodRest;
import com.automation.imob.components.config.EndpointConfig;
import com.automation.imob.components.result.CheckResponse;
import com.automation.imob.config.ImobFileJson;
import com.automation.imob.config.ImobPath;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.IOException;
import java.util.HashMap;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class RegisterBuildingTest extends ImobApplicationTests {
    //store set value
    private String bankAddresExternalRef;
    private String externalRefProject;

    @BeforeAll
    public void save() throws IOException {
        //Declare value identifiers: Building and BankAddress
        bankAddresExternalRef = getDataFaker().getExternalReference("DomRefExterna-");
        externalRefProject = getDataFaker().getExternalReference("refExternaProject-");

        //Response Create Building
        Response response = createBuilding(bankAddresExternalRef, externalRefProject);

        // Check Response
        CheckResponse.checkHttpCode(201, response);
        CheckResponse.checkTextInJson("Created", response);
    }

    @Test
    public void rn012_101001() throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("domicilioBancario", bankAddresExternalRef);
        mapValues.put("referenciaExternaProjeto", externalRefProject);
        mapValues.put("tipoOperacao", "");

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BUILDING);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BUILDING_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("101001", response);
        CheckResponse.checkTextInJson("TIPO DE OPERACAO OBRIGATORIO", response);
    }

    @Test
    public void rn012_101003() throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("domicilioBancario", bankAddresExternalRef);
        mapValues.put("referenciaExternaProjeto", "");


        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BUILDING);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BUILDING_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("101003", response);
        CheckResponse.checkTextInJson("REFERENCIA EXTERNA PROJETO OBRIGATORIA", response);
    }

    @Test
    public void rn012_101005() throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("domicilioBancario", bankAddresExternalRef);
        mapValues.put("referenciaExternaProjeto", externalRefProject);
        mapValues.put("idSpe", "");


        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BUILDING);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BUILDING_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("101005", response);
        CheckResponse.checkTextInJson("IDENTIFICADOR DA SPE/DESENVOLVEDOR IMOBILIARIO OBRIGATORIO", response);
    }

    @Test
    public void rn012_101007() throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("domicilioBancario", bankAddresExternalRef);
        mapValues.put("referenciaExternaProjeto", externalRefProject);
        mapValues.put("cns", "");


        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BUILDING);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BUILDING_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("101007", response);
        CheckResponse.checkTextInJson("CNS DO CARTORIO OBRIGATORIO", response);
    }

    @Test
    public void rn012_101009() throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("domicilioBancario", bankAddresExternalRef);
        mapValues.put("referenciaExternaProjeto", externalRefProject);
        mapValues.put("numeroMatricula", "");


        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BUILDING);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BUILDING_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("101009", response);
        CheckResponse.checkTextInJson("NUMERO DA MATRICULA OBRIGATORIO", response);
    }

    @Test
    public void rn012_101013() throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("domicilioBancario", bankAddresExternalRef);
        mapValues.put("referenciaExternaProjeto", externalRefProject);
        mapValues.put("razaoSocial", "");

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BUILDING);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BUILDING_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("101013", response);
        CheckResponse.checkTextInJson("RAZAO SOCIAL OBRIGATORIA", response);
    }

    @Test
    public void rn012_101014() throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("domicilioBancario", bankAddresExternalRef);
        mapValues.put("referenciaExternaProjeto", externalRefProject);
        mapValues.put("nomeComercial", "");

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BUILDING);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BUILDING_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("101014", response);
        CheckResponse.checkTextInJson("NOME COMERCIAL OBRIGATORIO", response);
    }

    @Test
    public void rn012_101048() throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("domicilioBancario", bankAddresExternalRef);
        mapValues.put("referenciaExternaProjeto", externalRefProject);
        mapValues.put("cpfResponsavel", "");

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BUILDING);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BUILDING_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("101048", response);
        CheckResponse.checkTextInJson("CPF RESPONSAVEL OBRIGATORIO", response);
    }

    @Test
    public void rn012_101017() throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("domicilioBancario", bankAddresExternalRef);
        mapValues.put("referenciaExternaProjeto", externalRefProject);
        mapValues.put("nomeContato", "");

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BUILDING);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BUILDING_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("101017", response);
        CheckResponse.checkTextInJson("NOME CONTATO OBRIGATORIO", response);
    }

    @Test
    public void rn012_101018() throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("domicilioBancario", bankAddresExternalRef);
        mapValues.put("referenciaExternaProjeto", externalRefProject);
        mapValues.put("email", "");

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BUILDING);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BUILDING_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("101018", response);
        CheckResponse.checkTextInJson("EMAIL OBRIGATORIO", response);
    }

    @Test
    public void rn012_101019() throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("domicilioBancario", bankAddresExternalRef);
        mapValues.put("referenciaExternaProjeto", externalRefProject);
        mapValues.put("celular", "");

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BUILDING);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BUILDING_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("101019", response);
        CheckResponse.checkTextInJson("CELULAR OBRIGATORIO", response);
    }

    @Test
    public void rn012_101022() throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("domicilioBancario", bankAddresExternalRef);
        mapValues.put("referenciaExternaProjeto", externalRefProject);
        mapValues.put("cep", "");

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BUILDING);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BUILDING_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("101022", response);
        CheckResponse.checkTextInJson("CEP OBRIGATORIO", response);
    }

    @Test
    public void rn012_101024() throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("domicilioBancario", bankAddresExternalRef);
        mapValues.put("referenciaExternaProjeto", externalRefProject);
        mapValues.put("logradouro", "");

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BUILDING);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BUILDING_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("101024", response);
        CheckResponse.checkTextInJson("LOGRADOURO OBRIGATORIO", response);
    }

    @Test
    public void rn012_101025() throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("domicilioBancario", bankAddresExternalRef);
        mapValues.put("referenciaExternaProjeto", externalRefProject);
        mapValues.put("numero", "");

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BUILDING);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BUILDING_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("101025", response);
        CheckResponse.checkTextInJson("NUMERO OBRIGATORIO", response);
    }

    @Test
    public void rn012_101027() throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("domicilioBancario", bankAddresExternalRef);
        mapValues.put("referenciaExternaProjeto", externalRefProject);
        mapValues.put("uso", "");

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BUILDING);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BUILDING_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("101027", response);
        CheckResponse.checkTextInJson("USO OBRIGATORIO", response);
    }

    @Test
    public void rn012_101029() throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("domicilioBancario", bankAddresExternalRef);
        mapValues.put("referenciaExternaProjeto", externalRefProject);
        mapValues.put("tipoImplantacao", "");

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BUILDING);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BUILDING_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("101029", response);
        CheckResponse.checkTextInJson("TIPO DE IMPLANTACAO OBRIGATORIO", response);
    }

    @Test
    public void rn012_101031() throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("domicilioBancario", bankAddresExternalRef);
        mapValues.put("referenciaExternaProjeto", externalRefProject);
        mapValues.put("registroIncorporacao", "");

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BUILDING);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BUILDING_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("101031", response);
        CheckResponse.checkTextInJson("REGISTRO DE INCORPORACAO OBRIGATORIO", response);
    }

    @Test
    public void rn012_101036() throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("domicilioBancario", bankAddresExternalRef);
        mapValues.put("referenciaExternaProjeto", externalRefProject);
        mapValues.put("patrimonio", "");

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BUILDING);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BUILDING_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("101036", response);
        CheckResponse.checkTextInJson("PATRIMONIO DE AFETACAO OBRIGATORIO", response);
    }

    @Test
    public void rn012_101041() throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("domicilioBancario", bankAddresExternalRef);
        mapValues.put("referenciaExternaProjeto", externalRefProject);
        mapValues.put("quantidadeQuadrasTorres", "");

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BUILDING);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BUILDING_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("101041", response);
        CheckResponse.checkTextInJson("IDENTIFICACAO QUANTIDADE QUADRAS TORRES OBRIGATORIO", response);
    }

    @Test
    public void rn012_101042() throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("domicilioBancario", bankAddresExternalRef);
        mapValues.put("referenciaExternaProjeto", externalRefProject);
        mapValues.put("domicilioBancario", "");

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BUILDING);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BUILDING_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("101042", response);
        CheckResponse.checkTextInJson("DOMICILIO BANCARIO OBRIGATORIO", response);
    }

    @Test
    public void rn013() throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("domicilioBancario", bankAddresExternalRef);
        mapValues.put("referenciaExternaProjeto", externalRefProject);
        mapValues.put("tipoOperacao", "Teste");

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BUILDING);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BUILDING_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("101002", response);
        CheckResponse.checkTextInJson("TIPO DE OPERACAO INVALIDO", response);
    }

    @Test
    public void rn014() throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("domicilioBancario", bankAddresExternalRef);
        mapValues.put("referenciaExternaProjeto", externalRefProject);
        mapValues.put("idSpe", "Teste_Invalido");

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BUILDING);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BUILDING_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("101006", response);
        CheckResponse.checkTextInJson("IDENTIFICADOR DA SPE/DESENVOLVEDOR IMOBILIARIO INVALIDO", response);
    }

    @Test
    public void rn015() throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("domicilioBancario", bankAddresExternalRef);
        mapValues.put("referenciaExternaProjeto", externalRefProject);
        mapValues.put("desenvolvedorImobiliario", "Teste_Invalido");

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BUILDING);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BUILDING_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("101026", response);
        CheckResponse.checkTextInJson("DESENVOLVEDOR IMOBILIARIO INVALIDO", response);
    }

    @DisplayName("rn016_101016 Testing invalid dates")
    @ParameterizedTest
    @ValueSource(strings = {"20-10", "2022-15", "203-09", "A"})
    public void rn016_101016(String invalidDate) throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("domicilioBancario", bankAddresExternalRef);
        mapValues.put("referenciaExternaProjeto", externalRefProject);
        mapValues.put("dataAtualizacao", invalidDate);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BUILDING);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BUILDING_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("101016", response);
        CheckResponse.checkTextInJson("DATA DE ATUALIZACAO INVALIDA", response);
    }

    @DisplayName("rn016_101035 Testing invalid dates")
    @ParameterizedTest
    @ValueSource(strings = {"20-10", "2022-15", "203-09", "A"})
    public void rn016_101035(String invalidDate) throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("domicilioBancario", bankAddresExternalRef);
        mapValues.put("referenciaExternaProjeto", externalRefProject);
        mapValues.put("dataIncorporacao", invalidDate);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BUILDING);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BUILDING_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("101035", response);
        CheckResponse.checkTextInJson("DATA REGISTRO DE INCORPORACAO INVALIDA", response);
    }

    @DisplayName("rn016_101040 Testing invalid dates")
    @ParameterizedTest
    @ValueSource(strings = {"20-10", "2022-15", "203-09", "A"})
    public void rn016_101040(String invalidDate) throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("domicilioBancario", bankAddresExternalRef);
        mapValues.put("referenciaExternaProjeto", externalRefProject);
        mapValues.put("dataPatrimonio", invalidDate);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BUILDING);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BUILDING_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("101040", response);
        CheckResponse.checkTextInJson("DATA CONSTITUICAO DO PATRIMONIO DE AFETACAO INVALIDA", response);
    }

    @DisplayName("rn017 Testing invalid cellphone")
    @ParameterizedTest
    @ValueSource(strings = {"+55011949494949494", "A", "+55011949494949", "asdfghjklqwert", "123"})
    public void rn017(String invalidCellhphone) throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("domicilioBancario", bankAddresExternalRef);
        mapValues.put("referenciaExternaProjeto", externalRefProject);
        mapValues.put("celular", invalidCellhphone);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BUILDING);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BUILDING_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("101020", response);
        CheckResponse.checkTextInJson("CELULAR INVALIDO", response);
    }

    @DisplayName("rn018 Testing invalid postal code")
    @ParameterizedTest
    @ValueSource(strings = {"999999999", "aaaaaaaa", "aaaaaaaaa", "99999999", "15995-042"})
    public void rn018(String invalidCEP) throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("domicilioBancario", bankAddresExternalRef);
        mapValues.put("referenciaExternaProjeto", externalRefProject);
        mapValues.put("cep", invalidCEP);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BUILDING);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BUILDING_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("101023", response);
        CheckResponse.checkTextInJson("CEP INVALIDO", response);
    }

    @DisplayName("rn019 Testing invalid USO")
    @ParameterizedTest
    @ValueSource(strings = {"4", "01", "a"})
    public void rn019(String invalidUSO) throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("domicilioBancario", bankAddresExternalRef);
        mapValues.put("referenciaExternaProjeto", externalRefProject);
        mapValues.put("uso", invalidUSO);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BUILDING);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BUILDING_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("101028", response);
        CheckResponse.checkTextInJson("USO INVALIDO", response);
    }

    @DisplayName("rn020 Testing invalid type implantation")
    @ParameterizedTest
    @ValueSource(strings = {"4", "01", "a"})
    public void rn020(String invalidImplantation) throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("domicilioBancario", bankAddresExternalRef);
        mapValues.put("referenciaExternaProjeto", externalRefProject);
        mapValues.put("tipoImplantacao", invalidImplantation);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BUILDING);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BUILDING_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("101030", response);
        CheckResponse.checkTextInJson("TIPO DE IMPLANTACAO INVALIDO", response);
    }

    @DisplayName("rn021 Testing invalid type")
    @ParameterizedTest
    @ValueSource(strings = {"4", "01", "a"})
    public void rn021(String invalidtype) throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("domicilioBancario", bankAddresExternalRef);
        mapValues.put("referenciaExternaProjeto", externalRefProject);
        mapValues.put("registroIncorporacao", invalidtype);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BUILDING);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BUILDING_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("101032", response);
        CheckResponse.checkTextInJson("REGISTRO DE INCORPORACAO INVALIDO", response);
    }

    @DisplayName("rn022 Testing invalid type")
    @ParameterizedTest
    @ValueSource(strings = {"4", "01", "a"})
    public void rn022(String invalidtype) throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("domicilioBancario", bankAddresExternalRef);
        mapValues.put("referenciaExternaProjeto", externalRefProject);
        mapValues.put("patrimonio", invalidtype);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BUILDING);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BUILDING_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("101037", response);
        CheckResponse.checkTextInJson("PATRIMONIO DE AFETACAO INVALIDO", response);
    }

    @Test
    public void rn023() throws IOException {

        String bankAddresExternalRef = getDataFaker().getExternalReference("DomBancario-");

        Integer cns = getDataFaker().getNumberCharacters(6);
        Integer registrationNumber = getDataFaker().getNumberCharacters(7);

        createBankAddres(bankAddresExternalRef);

        HashMap<String, Object> mapValuesBuilding = new HashMap<>();
        mapValuesBuilding.put("referenciaExternaProjeto", externalRefProject);
        mapValuesBuilding.put("domicilioBancario", bankAddresExternalRef);
        mapValuesBuilding.put("cns", cns);
        mapValuesBuilding.put("numeroMatricula", registrationNumber);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BUILDING);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BUILDING_SAVE, mapValuesBuilding));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);
        // Check Response
        CheckResponse.checkTextInJson("101004", response);
        CheckResponse.checkTextInJson("REFERENCIA EXTERNA PROJETO JA EXISTE", response);
    }

    @DisplayName("rn025 Testing invalid DevBuild")
    @ParameterizedTest
    @ValueSource(strings = {"9999999999999999", "aaa"})
    public void rn025(String invalidtype) throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("domicilioBancario", bankAddresExternalRef);
        mapValues.put("referenciaExternaProjeto", externalRefProject);
        mapValues.put("desenvolvedorImobiliario", invalidtype);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BUILDING);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BUILDING_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("101026", response);
        CheckResponse.checkTextInJson("DESENVOLVEDOR IMOBILIARIO INVALIDO", response);
    }

    @Test
    public void rn028() throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("domicilioBancario", bankAddresExternalRef);
        mapValues.put("referenciaExternaProjeto", externalRefProject);
        mapValues.put("ri", "");

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BUILDING);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BUILDING_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("101033", response);
        CheckResponse.checkTextInJson("AVERBACAO RI OBRIGATORIA", response);
    }

    @Test
    public void rn029() throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("domicilioBancario", bankAddresExternalRef);
        mapValues.put("referenciaExternaProjeto", externalRefProject);
        mapValues.put("dataIncorporacao", "");

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BUILDING);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BUILDING_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("101034", response);
        CheckResponse.checkTextInJson("DATA REGISTRO DE INCORPORACAO OBRIGATORIA", response);
    }

    @Test
    public void rn030() throws IOException {

        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("domicilioBancario", bankAddresExternalRef);
        mapValues.put("referenciaExternaProjeto", externalRefProject);
        mapValues.put("averbacao", "");

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BUILDING);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BUILDING_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("101038", response);
        CheckResponse.checkTextInJson("AVERBACAO OBRIGATORIA", response);
    }

    @Test
    public void rn031() throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("domicilioBancario", bankAddresExternalRef);
        mapValues.put("referenciaExternaProjeto", externalRefProject);
        mapValues.put("dataPatrimonio", "");

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BUILDING);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BUILDING_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("101039", response);
        CheckResponse.checkTextInJson("DATA CONSTITUICAO DO PATRIMONIO DE AFETACAO OBRIGATORIA", response);
    }

    @Test
    public void rn032() throws IOException {
        //Dynamic variable created when saving bank address
        String text = getDataFaker().getWorld();
        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("domicilioBancario", text);
        mapValues.put("referenciaExternaProjeto", externalRefProject);


        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BUILDING);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BUILDING_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("101043", response);
        CheckResponse.checkTextInJson("DOMICILIO BANCARIO INVALIDO", response);
    }

    @Test
    public void rn033() throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("domicilioBancario", bankAddresExternalRef);
        mapValues.put("referenciaExternaProjeto", externalRefProject);
        mapValues.put("parceirosValidacao", "invalid");

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BUILDING);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BUILDING_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("101051", response);
        CheckResponse.checkTextInJson("PARCEIRO DE VALIDACAO INVALIDO", response);
    }

    @DisplayName("rn034 Testing invalid CNPJ")
    @ParameterizedTest
    @ValueSource(strings = {"9999999999999999", "aaa", "0000000"})
    public void rn034(String invalidCNPJ) throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("domicilioBancario", bankAddresExternalRef);
        mapValues.put("referenciaExternaProjeto", externalRefProject);
        mapValues.put("cnpjParceiroValidacao", invalidCNPJ);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BUILDING);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BUILDING_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("101049", response);
        CheckResponse.checkTextInJson("CNPJ PARCEIRO DE VALIDACAO INVALIDO", response);
    }

    @DisplayName("rn035 Testing invalid context")
    @ParameterizedTest
    @ValueSource(strings = {"99", "aaa", "a", "5,6,7", "0000000"})
    public void rn035(String invalid) throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("domicilioBancario", bankAddresExternalRef);
        mapValues.put("referenciaExternaProjeto", externalRefProject);
        mapValues.put("contexto", invalid);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BUILDING);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BUILDING_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("101053", response);
        CheckResponse.checkTextInJson("CONTEXTO INVALIDO", response);
    }

    @Test
    public void rn036() throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("domicilioBancario", bankAddresExternalRef);
        mapValues.put("referenciaExternaProjeto", externalRefProject);
        mapValues.put("parceirosValidacao", "0");
        mapValues.put("cnpjParceiroValidacao", "");

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BUILDING);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BUILDING_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("101050", response);
        CheckResponse.checkTextInJson("CNPJ PARCEIRO DE VALIDACAO OBRIGATORIO", response);
    }

    @Test
    public void rn037() throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("domicilioBancario", bankAddresExternalRef);
        mapValues.put("referenciaExternaProjeto", externalRefProject);
        mapValues.put("parceirosValidacao", "0");
        mapValues.put("contexto", "");

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BUILDING);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BUILDING_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("101052", response);
        CheckResponse.checkTextInJson("CONTEXTO OBRIGATORIO", response);
    }

    @DisplayName("rn039 Testing invalid CPF")
    @ParameterizedTest
    @ValueSource(strings = {"99999999999", "659.778.920-20", "a", "0000000"})
    public void rn039(String invalidCPF) throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("domicilioBancario", bankAddresExternalRef);
        mapValues.put("referenciaExternaProjeto", externalRefProject);
        mapValues.put("cpfResponsavel", invalidCPF);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BUILDING);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BUILDING_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("101062", response);
        CheckResponse.checkTextInJson("CPF RESPONSAVEL INVALIDO", response);
    }

    @DisplayName("rn040 Testing invalid phone number")
    @ParameterizedTest
    @ValueSource(strings = {"+55011949494949494", "A", "+55011949494949", "asdfghjklqwert", "123"})
    public void rn040(String invalidPhone) throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("domicilioBancario", bankAddresExternalRef);
        mapValues.put("referenciaExternaProjeto", externalRefProject);
        mapValues.put("telefone", invalidPhone);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BUILDING);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BUILDING_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("101021", response);
        CheckResponse.checkTextInJson("TELEFONE INVALIDO", response);
    }

    @Test
    public void rn042() throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("domicilioBancario", bankAddresExternalRef);
        mapValues.put("referenciaExternaProjeto", externalRefProject);


        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BUILDING);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BUILDING_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("101067", response);
        CheckResponse.checkTextInJson("EMPREENDIMENTO JA CADASTRADO NA CERC", response);
    }

    @DisplayName("rn043 - Testing invalid cns")
    @ParameterizedTest
    @ValueSource(strings = {"AAA", "A", "333333333333"})
    public void rn043(String invalidCNS) throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("domicilioBancario", bankAddresExternalRef);
        mapValues.put("referenciaExternaProjeto", externalRefProject);
        mapValues.put("cns", invalidCNS);


        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BUILDING);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BUILDING_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("101008", response);
        CheckResponse.checkTextInJson("CNS DO CARTORIO INVALIDO", response);
    }

    @DisplayName("rn044 Testing invalid registration")
    @ParameterizedTest
    @ValueSource(strings = {"AAA", "A", "333333333333"})
    public void rn044(String registration) throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("domicilioBancario", bankAddresExternalRef);
        mapValues.put("referenciaExternaProjeto", externalRefProject);
        mapValues.put("numeroMatricula", registration);


        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BUILDING);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BUILDING_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("101010", response);
        CheckResponse.checkTextInJson("NUMERO DA MATRICULA INVALIDO", response);
    }

    @DisplayName("rn045 Testing invalid evaluation")
    @ParameterizedTest
    @ValueSource(strings = {"AAA", "A", "333333333333"})
    public void rn045(String evaluation) throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("domicilioBancario", bankAddresExternalRef);
        mapValues.put("referenciaExternaProjeto", externalRefProject);
        mapValues.put("avaliacao", evaluation);


        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BUILDING);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BUILDING_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("100006", response);
        CheckResponse.checkTextInJson("AVALIACAO DEVE CONTER TAMANHO 2 POSICOES", response);
    }

    @DisplayName("rn046 Testing invalid dd")
    @ParameterizedTest
    @ValueSource(strings = {"AAA", "A", "333333333333"})
    public void rn046(String dd) throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("domicilioBancario", bankAddresExternalRef);
        mapValues.put("referenciaExternaProjeto", externalRefProject);
        mapValues.put("dd", dd);


        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BUILDING);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BUILDING_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("101012", response);
        CheckResponse.checkTextInJson("DIGITO VERIFICADOR DA MATRICULA INVALIDO", response);
    }

    @Test
    public void rn047() throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("domicilioBancario", bankAddresExternalRef);
        mapValues.put("referenciaExternaProjeto", externalRefProject);
        mapValues.put("idSpe", "33477071000139");


        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BUILDING);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BUILDING_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("101070", response);
        CheckResponse.checkTextInJson("IDENTIFICADOR DA SPE/DESENVOLVEDOR IMOBILIARIO NAO CADASTRADO NA CERC", response);
    }
    @Test
    public void rn048() throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("domicilioBancario", bankAddresExternalRef);
        mapValues.put("referenciaExternaProjeto", externalRefProject);
        mapValues.put("desenvolvedorImobiliario", "99977071000139");


        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BUILDING);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BUILDING_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("101026", response);
        CheckResponse.checkTextInJson("DESENVOLVEDOR IMOBILIARIO INVALIDO", response);
    }
}
