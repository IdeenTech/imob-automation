package com.automation.imob.features.building;

import com.automation.imob.ImobApplicationTests;
import com.automation.imob.components.MethodRest;
import com.automation.imob.components.config.EndpointConfig;
import com.automation.imob.components.result.CheckResponse;
import com.automation.imob.config.ImobFileJson;
import com.automation.imob.config.ImobPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.IOException;
import java.util.HashMap;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class RegisterAndUpdateBuildingTest extends ImobApplicationTests {
    //store set value
    private String payAddressExternalRef;
    private String externalRefProject;

    @BeforeAll
    public void save() throws IOException {
        //Declare value identifiers: Building and PayAddress
        payAddressExternalRef = getDataFaker().getExternalReference("DomRefExterna-");
        externalRefProject = getDataFaker().getExternalReference("refExternaProject-");

        //Response Create Building
        Response response = createBuilding(payAddressExternalRef, externalRefProject);

        // Check Response
        CheckResponse.checkHttpCode(201, response);
        CheckResponse.checkTextInJson("Created", response);
    }

    public HashMap<String, Object> getCommonsValues() {
        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("domicilioBancario", payAddressExternalRef);
        mapValues.put("referenciaExternaProjeto", externalRefProject);

        return mapValues;
    }

    @Test
    public void rn012_101001() throws IOException {
        //Dynamic variable created when saving pay address
        HashMap<String, Object> mapValues = getCommonsValues();
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

    @ParameterizedTest
    @MethodSource("operationType")
    public void rn012_101003(final String operationType) throws IOException {
        //Dynamic variable created when saving pay address
        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("domicilioBancario", payAddressExternalRef);
        mapValues.put("tipoOperacao", operationType);
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

    @ParameterizedTest
    @MethodSource("operationType")
    public void rn012_101005(String operationType) throws IOException {
        //Dynamic variable created when saving pay address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("idSpe", "");
        mapValues.put("tipoOperacao", operationType);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BUILDING);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BUILDING_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("101005", response);
        CheckResponse.checkTextInJson("IDENTIFICADOR DA SPE/DESENVOLVEDOR IMOBILIARIO OBRIGATORIO", response);
    }

    @ParameterizedTest
    @MethodSource("operationType")
    public void rn012_101007(String operationType) throws IOException {
        //Dynamic variable created when saving pay address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("cns", "");
        mapValues.put("tipoOperacao", operationType);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BUILDING);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BUILDING_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("101007", response);
        CheckResponse.checkTextInJson("CNS DO CARTORIO OBRIGATORIO", response);
    }

    @ParameterizedTest
    @MethodSource("operationType")
    public void rn012_101009(String operationType) throws IOException {
        //Dynamic variable created when saving pay address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("numeroMatricula", "");
        mapValues.put("tipoOperacao", operationType);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BUILDING);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BUILDING_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("101009", response);
        CheckResponse.checkTextInJson("NUMERO DA MATRICULA OBRIGATORIO", response);
    }

    @ParameterizedTest
    @MethodSource("operationType")
    public void rn012_101013(String operationType) throws IOException {
        //Dynamic variable created when saving pay address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("razaoSocial", "");
        mapValues.put("tipoOperacao", operationType);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BUILDING);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BUILDING_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("101013", response);
        CheckResponse.checkTextInJson("RAZAO SOCIAL OBRIGATORIA", response);
    }

    @ParameterizedTest
    @MethodSource("operationType")
    public void rn012_101014(String operationType) throws IOException {
        //Dynamic variable created when saving pay address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("nomeComercial", "");
        mapValues.put("tipoOperacao", operationType);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BUILDING);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BUILDING_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("101014", response);
        CheckResponse.checkTextInJson("NOME COMERCIAL OBRIGATORIO", response);
    }

    @ParameterizedTest
    @MethodSource("operationType")
    public void rn012_101048(String operationType) throws IOException {
        //Dynamic variable created when saving pay address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("cpfResponsavel", "");
        mapValues.put("tipoOperacao", operationType);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BUILDING);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BUILDING_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("101048", response);
        CheckResponse.checkTextInJson("CPF RESPONSAVEL OBRIGATORIO", response);
    }

    @ParameterizedTest
    @MethodSource("operationType")
    public void rn012_101017(String operationType) throws IOException {
        //Dynamic variable created when saving pay address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("nomeContato", "");
        mapValues.put("tipoOperacao", operationType);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BUILDING);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BUILDING_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("101017", response);
        CheckResponse.checkTextInJson("NOME CONTATO OBRIGATORIO", response);
    }

    @ParameterizedTest
    @MethodSource("operationType")
    public void rn012_101018(String operationType) throws IOException {
        //Dynamic variable created when saving pay address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("email", "");
        mapValues.put("tipoOperacao", operationType);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BUILDING);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BUILDING_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("101018", response);
        CheckResponse.checkTextInJson("EMAIL OBRIGATORIO", response);
    }

    @ParameterizedTest
    @MethodSource("operationType")
    public void rn012_101019(String operationType) throws IOException {
        //Dynamic variable created when saving pay address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("celular", "");
        mapValues.put("tipoOperacao", operationType);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BUILDING);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BUILDING_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("101019", response);
        CheckResponse.checkTextInJson("CELULAR OBRIGATORIO", response);
    }

    @ParameterizedTest
    @MethodSource("operationType")
    public void rn012_101022(String operationType) throws IOException {
        //Dynamic variable created when saving pay address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("cep", "");
        mapValues.put("tipoOperacao", operationType);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BUILDING);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BUILDING_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("101022", response);
        CheckResponse.checkTextInJson("CEP OBRIGATORIO", response);
    }

    @ParameterizedTest
    @MethodSource("operationType")
    public void rn012_101024(String operationType) throws IOException {
        //Dynamic variable created when saving pay address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("logradouro", "");
        mapValues.put("tipoOperacao", operationType);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BUILDING);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BUILDING_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("101024", response);
        CheckResponse.checkTextInJson("LOGRADOURO OBRIGATORIO", response);
    }

    @ParameterizedTest
    @MethodSource("operationType")
    public void rn012_101025(String operationType) throws IOException {
        //Dynamic variable created when saving pay address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("numero", "");
        mapValues.put("tipoOperacao", operationType);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BUILDING);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BUILDING_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("101025", response);
        CheckResponse.checkTextInJson("NUMERO OBRIGATORIO", response);
    }

    @ParameterizedTest
    @MethodSource("operationType")
    public void rn012_101027(String operationType) throws IOException {
        //Dynamic variable created when saving pay address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("uso", "");
        mapValues.put("tipoOperacao", operationType);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BUILDING);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BUILDING_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("101027", response);
        CheckResponse.checkTextInJson("USO OBRIGATORIO", response);
    }

    @ParameterizedTest
    @MethodSource("operationType")
    public void rn012_101029(String operationType) throws IOException {
        //Dynamic variable created when saving pay address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("tipoImplantacao", "");
        mapValues.put("tipoOperacao", operationType);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BUILDING);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BUILDING_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("101029", response);
        CheckResponse.checkTextInJson("TIPO DE IMPLANTACAO OBRIGATORIO", response);
    }

    @ParameterizedTest
    @MethodSource("operationType")
    public void rn012_101031(String operationType) throws IOException {
        //Dynamic variable created when saving pay address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("registroIncorporacao", "");
        mapValues.put("tipoOperacao", operationType);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BUILDING);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BUILDING_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("101031", response);
        CheckResponse.checkTextInJson("REGISTRO DE INCORPORACAO OBRIGATORIO", response);
    }

    @ParameterizedTest
    @MethodSource("operationType")
    public void rn012_101036(String operationType) throws IOException {
        //Dynamic variable created when saving pay address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("patrimonio", "");
        mapValues.put("tipoOperacao", operationType);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BUILDING);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BUILDING_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("101036", response);
        CheckResponse.checkTextInJson("PATRIMONIO DE AFETACAO OBRIGATORIO", response);
    }

    @ParameterizedTest
    @MethodSource("operationType")
    public void rn012_101041(String operationType) throws IOException {
        //Dynamic variable created when saving pay address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("quantidadeQuadrasTorres", "");
        mapValues.put("tipoOperacao", operationType);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BUILDING);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BUILDING_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("101041", response);
        CheckResponse.checkTextInJson("IDENTIFICACAO QUANTIDADE QUADRAS TORRES OBRIGATORIO", response);
    }

    @ParameterizedTest
    @MethodSource("operationType")
    public void rn012_101042(String operationType) throws IOException {
        //Dynamic variable created when saving pay address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("domicilioBancario", "");
        mapValues.put("tipoOperacao", operationType);

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
        //Dynamic variable created when saving pay address
        HashMap<String, Object> mapValues = getCommonsValues();
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

    @ParameterizedTest
    @MethodSource("operationType")
    public void rn014(String operationType) throws IOException {
        //Dynamic variable created when saving pay address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("idSpe", "Teste_Invalido");
        mapValues.put("tipoOperacao", operationType);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BUILDING);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BUILDING_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("101006", response);
        CheckResponse.checkTextInJson("IDENTIFICADOR DA SPE/DESENVOLVEDOR IMOBILIARIO INVALIDO", response);
    }

    @ParameterizedTest
    @MethodSource("operationType")
    public void rn015(String operationType) throws IOException {
        //Dynamic variable created when saving pay address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("desenvolvedorImobiliario", "Teste_Invalido");
        mapValues.put("tipoOperacao", operationType);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BUILDING);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BUILDING_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("101026", response);
        CheckResponse.checkTextInJson("DESENVOLVEDOR IMOBILIARIO INVALIDO", response);
    }

    @ParameterizedTest
    @DisplayName("rn016_101016(create) Testing invalid dates")
    @ValueSource(strings = {"20-10", "2022-15", "203-09", "A"})
    public void rn016_101016_create(String invalidDate) throws IOException {
        //Dynamic variable created when saving pay address
        HashMap<String, Object> mapValues = getCommonsValues();
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

    @DisplayName("rn016_101035(create) Testing invalid dates")
    @ParameterizedTest
    @ValueSource(strings = {"20-10", "2022-15", "203-09", "A"})
    public void rn016_101035_create(String invalidDate) throws IOException {
        //Dynamic variable created when saving pay address
        HashMap<String, Object> mapValues = getCommonsValues();
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

    @DisplayName("rn016_101040(create) Testing invalid dates")
    @ParameterizedTest
    @ValueSource(strings = {"20-10", "2022-15", "203-09", "A"})
    public void rn016_101040_create(String invalidDate) throws IOException {
        //Dynamic variable created when saving pay address
        HashMap<String, Object> mapValues = getCommonsValues();
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

    @DisplayName("rn017(create) Testing invalid cellphone ")
    @ParameterizedTest
    @ValueSource(strings = {"+55011949494949494", "A", "+55011949494949", "asdfghjklqwert", "123"})
    public void rn017_create(String invalidCellhphone) throws IOException {
        //Dynamic variable created when saving pay address
        HashMap<String, Object> mapValues = getCommonsValues();
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

    @DisplayName("rn018(create) Testing invalid postal code")
    @ParameterizedTest
    @ValueSource(strings = {"999999999", "aaaaaaaa", "aaaaaaaaa", "99999999", "15995-042"})
    public void rn018_create(String invalidCEP) throws IOException {
        //Dynamic variable created when saving pay address
        HashMap<String, Object> mapValues = getCommonsValues();
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

    @DisplayName("rn019(create) Testing invalid USO")
    @ParameterizedTest
    @ValueSource(strings = {"4", "01", "a"})
    public void rn019_create(String invalidUSO) throws IOException {
        //Dynamic variable created when saving pay address
        HashMap<String, Object> mapValues = getCommonsValues();
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

    @DisplayName("rn020(create) Testing invalid type implantation")
    @ParameterizedTest
    @ValueSource(strings = {"4", "01", "a"})
    public void rn020_create(String invalidImplantation) throws IOException {
        //Dynamic variable created when saving pay address
        HashMap<String, Object> mapValues = getCommonsValues();
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

    @DisplayName("rn021(create) Testing invalid type")
    @ParameterizedTest
    @ValueSource(strings = {"4", "01", "a"})
    public void rn021_create(String invalidtype) throws IOException {
        //Dynamic variable created when saving pay address
        HashMap<String, Object> mapValues = getCommonsValues();
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

    @DisplayName("rn022(create) Testing invalid type")
    @ParameterizedTest
    @ValueSource(strings = {"4", "01", "a"})
    public void rn022_create(String invalidtype) throws IOException {
        //Dynamic variable created when saving pay address
        HashMap<String, Object> mapValues = getCommonsValues();
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

        String payAddresExternalRef = getDataFaker().getExternalReference("DomBancario-");

        Integer cns = getDataFaker().getNumberCharacters(6);
        Integer registrationNumber = getDataFaker().getNumberCharacters(7);

        createPayAddress(payAddresExternalRef);

        HashMap<String, Object> mapValuesBuilding = new HashMap<>();
        mapValuesBuilding.put("referenciaExternaProjeto", externalRefProject);
        mapValuesBuilding.put("domicilioBancario", payAddresExternalRef);
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

    @DisplayName("rn025(create) Testing invalid DevBuild")
    @ParameterizedTest
    @ValueSource(strings = {"9999999999999999", "aaa"})
    public void rn025_create(String invalidtype) throws IOException {
        //Dynamic variable created when saving pay address
        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("domicilioBancario", payAddressExternalRef);
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

    @ParameterizedTest
    @MethodSource("operationType")
    public void rn028(String operationType) throws IOException {
        //Dynamic variable created when saving pay address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("ri", "");
        mapValues.put("tipoOperacao", operationType);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BUILDING);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BUILDING_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("101033", response);
        CheckResponse.checkTextInJson("AVERBACAO RI OBRIGATORIA", response);
    }

    @ParameterizedTest
    @MethodSource("operationType")
    public void rn029(String operationType) throws IOException {
        //Dynamic variable created when saving pay address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("dataIncorporacao", "");
        mapValues.put("tipoOperacao", operationType);
        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BUILDING);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BUILDING_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("101034", response);
        CheckResponse.checkTextInJson("DATA REGISTRO DE INCORPORACAO OBRIGATORIA", response);
    }

    @ParameterizedTest
    @MethodSource("operationType")
    public void rn030(String operationType) throws IOException {

        //Dynamic variable created when saving pay address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("averbacao", "");
        mapValues.put("tipoOperacao", operationType);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BUILDING);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BUILDING_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("101038", response);
        CheckResponse.checkTextInJson("AVERBACAO OBRIGATORIA", response);
    }

    @ParameterizedTest
    @MethodSource("operationType")
    public void rn031(String operationType) throws IOException {
        //Dynamic variable created when saving pay address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("dataPatrimonio", "");
        mapValues.put("tipoOperacao", operationType);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BUILDING);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BUILDING_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("101039", response);
        CheckResponse.checkTextInJson("DATA CONSTITUICAO DO PATRIMONIO DE AFETACAO OBRIGATORIA", response);
    }

    @ParameterizedTest
    @MethodSource("operationType")
    public void rn032(String operationType) throws IOException {
        //Dynamic variable created when saving pay address
        String text = getDataFaker().getWorld();
        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("domicilioBancario", text);
        mapValues.put("referenciaExternaProjeto", externalRefProject);
        mapValues.put("tipoOperacao", operationType);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BUILDING);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BUILDING_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("101043", response);
        CheckResponse.checkTextInJson("DOMICILIO BANCARIO INVALIDO", response);
    }

    @ParameterizedTest
    @MethodSource("operationType")
    public void rn033(String operationType) throws IOException {
        //Dynamic variable created when saving pay address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("parceirosValidacao", "invalid");
        mapValues.put("tipoOperacao", operationType);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BUILDING);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BUILDING_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("101051", response);
        CheckResponse.checkTextInJson("PARCEIRO DE VALIDACAO INVALIDO", response);
    }

    @DisplayName("rn034(create) Testing invalid CNPJ")
    @ParameterizedTest
    @ValueSource(strings = {"9999999999999999", "aaa", "0000000"})
    public void rn034_create(String invalidCNPJ) throws IOException {
        //Dynamic variable created when saving pay address
        HashMap<String, Object> mapValues = getCommonsValues();
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

    @DisplayName("rn035(create) Testing invalid context")
    @ParameterizedTest
    @ValueSource(strings = {"99", "aaa", "a", "5,6,7", "0000000"})
    public void rn035_create(String invalid) throws IOException {
        //Dynamic variable created when saving pay address
        HashMap<String, Object> mapValues = getCommonsValues();
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

    @ParameterizedTest
    @MethodSource("operationType")
    public void rn036(String operationType) throws IOException {
        //Dynamic variable created when saving pay address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("parceirosValidacao", "0");
        mapValues.put("cnpjParceiroValidacao", "");
        mapValues.put("tipoOperacao", operationType);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BUILDING);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BUILDING_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("101050", response);
        CheckResponse.checkTextInJson("CNPJ PARCEIRO DE VALIDACAO OBRIGATORIO", response);
    }

    @ParameterizedTest
    @MethodSource("operationType")
    public void rn037(String operationType) throws IOException {
        //Dynamic variable created when saving pay address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("parceirosValidacao", "0");
        mapValues.put("contexto", "");
        mapValues.put("tipoOperacao", operationType);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BUILDING);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BUILDING_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("101052", response);
        CheckResponse.checkTextInJson("CONTEXTO OBRIGATORIO", response);
    }

    @DisplayName("rn039(create) Testing invalid CPF")
    @ParameterizedTest
    @ValueSource(strings = {"99999999999", "659.778.920-20", "a", "0000000"})
    public void rn039_create(String invalidCPF) throws IOException {
        //Dynamic variable created when saving pay address
        HashMap<String, Object> mapValues = getCommonsValues();
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


    @DisplayName("rn040(create) Testing invalid phone number")
    @ParameterizedTest
    @ValueSource(strings = {"+55011949494949494", "A", "+55011949494949", "asdfghjklqwert", "123"})
    public void rn040_create(String invalidPhone) throws IOException {
        //Dynamic variable created when saving pay address
        HashMap<String, Object> mapValues = getCommonsValues();
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
        //Dynamic variable created when saving pay address
        HashMap<String, Object> mapValues = getCommonsValues();

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BUILDING);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BUILDING_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("101067", response);
        CheckResponse.checkTextInJson("EMPREENDIMENTO JA CADASTRADO NA CERC", response);
    }

    @DisplayName("rn043(create) - Testing invalid cns")
    @ParameterizedTest
    @ValueSource(strings = {"AAA", "A", "333333333333"})
    public void rn043_create(String invalidCNS) throws IOException {
        //Dynamic variable created when saving pay address
        HashMap<String, Object> mapValues = getCommonsValues();
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

    @DisplayName("rn044(create) Testing invalid registration")
    @ParameterizedTest
    @ValueSource(strings = {"AAA", "A", "333333333333"})
    public void rn044_create(String registration) throws IOException {
        //Dynamic variable created when saving pay address
        HashMap<String, Object> mapValues = getCommonsValues();
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

    @DisplayName("rn045(create) Testing invalid evaluation")
    @ParameterizedTest
    @ValueSource(strings = {"AAA", "A", "333333333333"})
    public void rn045_create(String evaluation) throws IOException {
        //Dynamic variable created when saving pay address
        HashMap<String, Object> mapValues = getCommonsValues();
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

    @DisplayName("rn046(create) Testing invalid dd")
    @ParameterizedTest
    @ValueSource(strings = {"AAA", "A", "333333333333"})
    public void rn046_create(String dd) throws IOException {
        //Dynamic variable created when saving pay address
        HashMap<String, Object> mapValues = getCommonsValues();
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


    @ParameterizedTest
    @MethodSource("operationType")
    public void rn047(String operationType) throws IOException {
        //Dynamic variable created when saving pay address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("idSpe", "33477071000139");
        mapValues.put("tipoOperacao", operationType);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BUILDING);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BUILDING_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("101070", response);
        CheckResponse.checkTextInJson("IDENTIFICADOR DA SPE/DESENVOLVEDOR IMOBILIARIO NAO CADASTRADO NA CERC", response);
    }

    @ParameterizedTest
    @MethodSource("operationType")
    public void rn048(String operationType) throws IOException {
        //Dynamic variable created when saving pay address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("desenvolvedorImobiliario", "99977071000139");
        mapValues.put("tipoOperacao", operationType);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BUILDING);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BUILDING_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("101026", response);
        CheckResponse.checkTextInJson("DESENVOLVEDOR IMOBILIARIO INVALIDO", response);
    }

    //================================================================================ Edit Methods ========================================================================================================

    @ParameterizedTest
    @DisplayName("rn016_101016(edit) Testing invalid dates")
    @ValueSource(strings = {"20-10", "2022-15", "203-09", "A"})
    public void rn016_101016_edit(String invalidDate) throws IOException {
        //Dynamic variable created when saving pay address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("dataAtualizacao", invalidDate);
        mapValues.put("tipoOperacao", "A");

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BUILDING);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BUILDING_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("101016", response);
        CheckResponse.checkTextInJson("DATA DE ATUALIZACAO INVALIDA", response);
    }

    @DisplayName("rn016_101040(edit) Testing invalid dates")
    @ParameterizedTest
    @ValueSource(strings = {"20-10", "2022-15", "203-09", "A"})
    public void rn016_101040_edit(String invalidDate) throws IOException {
        //Dynamic variable created when saving pay address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("dataPatrimonio", invalidDate);
        mapValues.put("tipoOperacao", "A");

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BUILDING);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BUILDING_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("101040", response);
        CheckResponse.checkTextInJson("DATA CONSTITUICAO DO PATRIMONIO DE AFETACAO INVALIDA", response);
    }

    @DisplayName("rn016_101035(edit) Testing invalid dates")
    @ParameterizedTest
    @ValueSource(strings = {"20-10", "2022-15", "203-09", "A"})
    public void rn016_101035_edit(String invalidDate) throws IOException {
        //Dynamic variable created when saving pay address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("dataIncorporacao", invalidDate);
        mapValues.put("tipoOperacao", "A");

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BUILDING);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BUILDING_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("101035", response);
        CheckResponse.checkTextInJson("DATA REGISTRO DE INCORPORACAO INVALIDA", response);
    }

    @DisplayName("rn017(edit) Testing invalid cellphone ")
    @ParameterizedTest
    @ValueSource(strings = {"+55011949494949494", "A", "+55011949494949", "asdfghjklqwert", "123"})
    public void rn017_edit(String invalidCellhphone) throws IOException {
        //Dynamic variable created when saving pay address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("celular", invalidCellhphone);
        mapValues.put("tipoOperacao", "A");

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BUILDING);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BUILDING_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("101020", response);
        CheckResponse.checkTextInJson("CELULAR INVALIDO", response);
    }

    @DisplayName("rn018(edit) Testing invalid postal code")
    @ParameterizedTest
    @ValueSource(strings = {"999999999", "aaaaaaaa", "aaaaaaaaa", "99999999", "15995-042"})
    public void rn018_edit(String invalidCEP) throws IOException {
        //Dynamic variable created when saving pay address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("cep", invalidCEP);
        mapValues.put("tipoOperacao", "A");

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BUILDING);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BUILDING_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("101023", response);
        CheckResponse.checkTextInJson("CEP INVALIDO", response);
    }

    @DisplayName("rn019(edit) Testing invalid USO")
    @ParameterizedTest
    @ValueSource(strings = {"4", "01", "a"})
    public void rn019_edit(String invalidUSO) throws IOException {
        //Dynamic variable created when saving pay address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("uso", invalidUSO);
        mapValues.put("tipoOperacao", "A");

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BUILDING);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BUILDING_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("101028", response);
        CheckResponse.checkTextInJson("USO INVALIDO", response);
    }

    @DisplayName("rn020(edit) Testing invalid type implantation")
    @ParameterizedTest
    @ValueSource(strings = {"4", "01", "a"})
    public void rn020_edit(String invalidImplantation) throws IOException {
        //Dynamic variable created when saving pay address
        HashMap<String, Object> mapValues = getCommonsValues();
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

    @DisplayName("rn021(edit) Testing invalid type")
    @ParameterizedTest
    @ValueSource(strings = {"4", "01", "a"})
    public void rn021_edit(String invalidtype) throws IOException {
        //Dynamic variable created when saving pay address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("registroIncorporacao", invalidtype);
        mapValues.put("tipoOperacao", "A");

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BUILDING);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BUILDING_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("101032", response);
        CheckResponse.checkTextInJson("REGISTRO DE INCORPORACAO INVALIDO", response);
    }

    @DisplayName("rn022(edit) Testing invalid type")
    @ParameterizedTest
    @ValueSource(strings = {"4", "01", "a"})
    public void rn022_edit(String invalidtype) throws IOException {
        //Dynamic variable created when saving pay address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("patrimonio", invalidtype);
        mapValues.put("tipoOperacao", "A");

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BUILDING);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BUILDING_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("101037", response);
        CheckResponse.checkTextInJson("PATRIMONIO DE AFETACAO INVALIDO", response);
    }

    @DisplayName("rn025(edit) Testing invalid DevBuild")
    @ParameterizedTest
    @ValueSource(strings = {"9999999999999999", "aaa"})
    public void rn025_edit(String invalidtype) throws IOException {
        //Dynamic variable created when saving pay address
        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("domicilioBancario", payAddressExternalRef);
        mapValues.put("referenciaExternaProjeto", externalRefProject);
        mapValues.put("desenvolvedorImobiliario", invalidtype);
        mapValues.put("tipoOperacao", "A");

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BUILDING);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BUILDING_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("101026", response);
        CheckResponse.checkTextInJson("DESENVOLVEDOR IMOBILIARIO INVALIDO", response);
    }

    @DisplayName("rn034(edit) Testing invalid CNPJ")
    @ParameterizedTest
    @ValueSource(strings = {"9999999999999999", "aaa", "0000000"})
    public void rn034_edit(String invalidCNPJ) throws IOException {
        //Dynamic variable created when saving pay address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("cnpjParceiroValidacao", invalidCNPJ);
        mapValues.put("tipoOperacao", "A");

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BUILDING);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BUILDING_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("101049", response);
        CheckResponse.checkTextInJson("CNPJ PARCEIRO DE VALIDACAO INVALIDO", response);
    }

    @DisplayName("rn035(edit) Testing invalid context")
    @ParameterizedTest
    @ValueSource(strings = {"99", "aaa", "a", "5,6,7", "0000000"})
    public void rn035_edit(String invalid) throws IOException {
        //Dynamic variable created when saving pay address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("contexto", invalid);
        mapValues.put("tipoOperacao", "A");

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BUILDING);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BUILDING_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("101053", response);
        CheckResponse.checkTextInJson("CONTEXTO INVALIDO", response);
    }

    @DisplayName("rn039(edit) Testing invalid CPF")
    @ParameterizedTest
    @ValueSource(strings = {"99999999999", "659.778.920-20", "a", "0000000"})
    public void rn039_edit(String invalidCPF) throws IOException {
        //Dynamic variable created when saving pay address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("cpfResponsavel", invalidCPF);
        mapValues.put("tipoOperacao", "A");

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BUILDING);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BUILDING_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("101062", response);
        CheckResponse.checkTextInJson("CPF RESPONSAVEL INVALIDO", response);
    }

    @DisplayName("rn040(edit) Testing invalid phone number")
    @ParameterizedTest
    @ValueSource(strings = {"+55011949494949494", "A", "+55011949494949", "asdfghjklqwert", "123"})
    public void rn040_edit(String invalidPhone) throws IOException {
        //Dynamic variable created when saving pay address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("telefone", invalidPhone);
        mapValues.put("tipoOperacao", "A");

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BUILDING);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BUILDING_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("101021", response);
        CheckResponse.checkTextInJson("TELEFONE INVALIDO", response);
    }

    @DisplayName("rn043(edit) - Testing invalid cns")
    @ParameterizedTest
    @ValueSource(strings = {"AAA", "A", "333333333333"})
    public void rn043_edit(String invalidCNS) throws IOException {
        //Dynamic variable created when saving pay address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("cns", invalidCNS);
        mapValues.put("tipoOperacao", "A");

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BUILDING);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BUILDING_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("101008", response);
        CheckResponse.checkTextInJson("CNS DO CARTORIO INVALIDO", response);
    }

    @DisplayName("rn044(edit) Testing invalid registration")
    @ParameterizedTest
    @ValueSource(strings = {"AAA", "A", "333333333333"})
    public void rn044_edit(String registration) throws IOException {
        //Dynamic variable created when saving pay address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("numeroMatricula", registration);
        mapValues.put("tipoOperacao", "A");

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BUILDING);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BUILDING_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("101010", response);
        CheckResponse.checkTextInJson("NUMERO DA MATRICULA INVALIDO", response);
    }

    @DisplayName("rn045(edit) Testing invalid evaluation")
    @ParameterizedTest
    @ValueSource(strings = {"AAA", "A", "333333333333"})
    public void rn045_edit(String evaluation) throws IOException {
        //Dynamic variable created when saving pay address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("avaliacao", evaluation);
        mapValues.put("tipoOperacao", "A");

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BUILDING);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BUILDING_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("100006", response);
        CheckResponse.checkTextInJson("AVALIACAO DEVE CONTER TAMANHO 2 POSICOES", response);
    }

    @DisplayName("rn046(edit) Testing invalid dd")
    @ParameterizedTest
    @ValueSource(strings = {"AAA", "A", "333333333333"})
    public void rn046_edit(String dd) throws IOException {
        //Dynamic variable created when saving pay address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("dd", dd);
        mapValues.put("tipoOperacao", "A");

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
    public void rn027() throws IOException {
        //Dynamic variable created when saving pay address
        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("domicilioBancario", payAddressExternalRef);
        mapValues.put("tipoOperacao", "I");
        mapValues.put("referenciaExternaProjeto", externalRefProject);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BUILDING);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BUILDING_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);
        response = MethodRest.callPost(endpointConfig);
        mapValues.put("tipoOperacao", "A");

        // Check Response
        CheckResponse.checkTextInJson("101054", response);
        CheckResponse.checkTextInJson("EMPREENDIMENTO INATIVO", response);
    }
}
