package com.automation.imob.features.bankaddress;

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
public class RegisterBankAddressTest extends ImobApplicationTests {

    private String bankAddressExternalRef;

    @BeforeAll
    public void init() {
        bankAddressExternalRef = getDataFaker().getExternalReference("domiciliobancario-");
    }

    @Test
    public void save() throws IOException {
        Response response = createBankAddres(bankAddressExternalRef);

        // Check Response
        CheckResponse.checkHttpCode(201, response);
        CheckResponse.checkTextInJson("Created", response);
    }

    @Test
    public void rn004_111001() throws IOException {

        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("referenciaExterna", bankAddressExternalRef);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BANK_ADDRESS);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonBody(ImobFileJson.PATH_JSON_BANK_ADDRESS_RN004_111001, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("111001", response);
        CheckResponse.checkTextInJson("TIPO DE OPERACAO OBRIGATORIO", response);
    }

    @ParameterizedTest
    @MethodSource("operationType")
    public void rn004_111006(String operationType) throws IOException {

        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("referenciaExterna", bankAddressExternalRef);
        mapValues.put("tipoOperacao", operationType);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BANK_ADDRESS);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonBody(ImobFileJson.PATH_JSON_BANK_ADDRESS_RN004_111006, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("111006", response);
        CheckResponse.checkTextInJson("CNPJ OBRIGATORIO", response);
    }

    @ParameterizedTest
    @MethodSource("operationType")
    public void rn004_111008(String operationType) throws IOException {

        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("referenciaExterna", bankAddressExternalRef);
        mapValues.put("tipoOperacao", operationType);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BANK_ADDRESS);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonBody(ImobFileJson.PATH_JSON_BANK_ADDRESS_RN004_111008, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("111008", response);
        CheckResponse.checkTextInJson("RAZAO SOCIAL OBRIGATORIO", response);
    }

    @Test
    public void rn004_111010() throws IOException {

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BANK_ADDRESS);
        endpointConfig.setBody(endpointConfig.setJsonFileBody(ImobFileJson.PATH_JSON_BANK_ADDRESS_RN004_111010));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("111010", response);
        CheckResponse.checkTextInJson("REFERENCIA EXTERNA OBRIGATORIO", response);
    }

    @ParameterizedTest
    @MethodSource("operationType")
    public void rn004_111013(String operationType) throws IOException {

        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("referenciaExterna", bankAddressExternalRef);
        mapValues.put("tipoOperacao", operationType);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BANK_ADDRESS);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonBody(ImobFileJson.PATH_JSON_BANK_ADDRESS_RN004_111013, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("111013", response);
        CheckResponse.checkTextInJson("BANCO OBRIGATORIO", response);
    }

    @ParameterizedTest
    @MethodSource("operationType")
    public void rn004_111015(String operationType) throws IOException {

        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("referenciaExterna", bankAddressExternalRef);
        mapValues.put("tipoOperacao", operationType);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BANK_ADDRESS);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonBody(ImobFileJson.PATH_JSON_BANK_ADDRESS_RN004_111015, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("111015", response);
        CheckResponse.checkTextInJson("AGENCIA OBRIGATORIO", response);
    }

    @ParameterizedTest
    @MethodSource("operationType")
    public void rn004_111017(String operationType) throws IOException {

        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("referenciaExterna", bankAddressExternalRef);
        mapValues.put("tipoOperacao", operationType);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BANK_ADDRESS);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonBody(ImobFileJson.PATH_JSON_BANK_ADDRESS_RN004_111017, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("111017", response);
        CheckResponse.checkTextInJson("CONTA OBRIGATORIO", response);
    }

    @ParameterizedTest
    @MethodSource("operationType")
    public void rn004_111018(String operationType) throws IOException {

        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("referenciaExterna", bankAddressExternalRef);
        mapValues.put("tipoOperacao", operationType);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BANK_ADDRESS);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonBody(ImobFileJson.PATH_JSON_BANK_ADDRESS_RN004_111018, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("111018", response);
        CheckResponse.checkTextInJson("CONVENIO DE COBRANCA OBRIGATORIO", response);
    }

    @ParameterizedTest
    @MethodSource("operationType")
    public void rn004_111019(String operationType) throws IOException {

        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("referenciaExterna", bankAddressExternalRef);
        mapValues.put("tipoOperacao", operationType);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BANK_ADDRESS);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonBody(ImobFileJson.PATH_JSON_BANK_ADDRESS_RN004_111019, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("111019", response);
        CheckResponse.checkTextInJson("COD CEDENTE OBRIGATORIO", response);
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "B", "1", "99"})
    public void rn005() throws IOException {

        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("referenciaExterna", bankAddressExternalRef);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BANK_ADDRESS);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonBody(ImobFileJson.PATH_JSON_BANK_ADDRESS_RN005, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("111002", response);
        CheckResponse.checkTextInJson("TIPO DE OPERACAO INVALIDO", response);
    }

    @DisplayName("rn006(create) testing invalid CNPJ")
    @ParameterizedTest
    @ValueSource(strings = {"999999999999999", "a", "A", "0000000"})
    public void rn006_create(String invalidCNPJ) throws IOException {

        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("referenciaExterna", bankAddressExternalRef);
        mapValues.put("cnpj", invalidCNPJ);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BANK_ADDRESS);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonBody(ImobFileJson.PATH_JSON_BANK_ADDRESS_RN006, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("111007", response);
        CheckResponse.checkTextInJson("CNPJ INVALIDO", response);
    }


    @Test
    public void rn007() throws IOException {

        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("referenciaExterna", bankAddressExternalRef);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BANK_ADDRESS);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonBody(ImobFileJson.PATH_JSON_BANK_ADDRESS_RN007, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("111011", response);
        CheckResponse.checkTextInJson("REFERENCIA EXTERNA JA EXISTE", response);
    }

    @ParameterizedTest
    @MethodSource("operationType")
    public void rn008(String operationType) throws IOException {

        String cnpj = getDataFaker().getCnpj(false);
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("referenciaExterna", bankAddressExternalRef);
        mapValues.put("tipoOperacao", operationType);
        mapValues.put("cnpj", cnpj);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BANK_ADDRESS);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonBody(ImobFileJson.PATH_JSON_BANK_ADDRESS_RN008, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("111020", response);
        CheckResponse.checkTextInJson("JUSTIFICATIVA OBRIGATORIA", response);
    }

    @DisplayName("rn010(create) testing invalid ASSIGNMENT CODE")
    @ParameterizedTest
    @ValueSource(strings = {"99999999", "a", "00000000"})
    public void rn010_create(String invalidAssigCode) throws IOException {

        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("referenciaExterna", bankAddressExternalRef);
        mapValues.put("codigoCedente", invalidAssigCode);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BANK_ADDRESS);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonBody(ImobFileJson.PATH_JSON_BANK_ADDRESS_RN010, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("111028", response);
        CheckResponse.checkTextInJson("COD CEDENTE INVALIDO", response);
    }

    //================================================================================ Edit Methods ========================================================================================================

    @Test
    public void update_rn007_111027() throws IOException {

        String teste = getDataFaker().getWorld();

        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("tipoOperacao", "A");
        mapValues.put("referenciaExterna", teste);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BANK_ADDRESS);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonBody(ImobFileJson.PATH_JSON_BANK_ADDRESS_RN007, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("111027", response);
        CheckResponse.checkTextInJson("REFERENCIA EXTERNA NAO EXISTE", response);
    }

    @DisplayName("rn006(edit) testing invalid CNPJ")
    @ParameterizedTest
    @ValueSource(strings = {"999999999999999", "a", "A", "0000000"})
    public void rn006_edit(String invalidCNPJ) throws IOException {

        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("referenciaExterna", bankAddressExternalRef);
        mapValues.put("tipoOperacao", "A");
        mapValues.put("cnpj", invalidCNPJ);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BANK_ADDRESS);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonBody(ImobFileJson.PATH_JSON_BANK_ADDRESS_RN006, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("111007", response);
        CheckResponse.checkTextInJson("CNPJ INVALIDO", response);
    }

    @DisplayName("rn010(edit) testing invalid ASSIGNMENT CODE")
    @ParameterizedTest
    @ValueSource(strings = {"99999999", "a", "00000000"})
    public void rn010_edit(String invalidassigcode) throws IOException {

        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("referenciaExterna", bankAddressExternalRef);
        mapValues.put("tipoOperacao", "A");
        mapValues.put("codigoCedente", invalidassigcode);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BANK_ADDRESS);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonBody(ImobFileJson.PATH_JSON_BANK_ADDRESS_RN010, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("111028", response);
        CheckResponse.checkTextInJson("COD CEDENTE INVALIDO", response);
    }
}
