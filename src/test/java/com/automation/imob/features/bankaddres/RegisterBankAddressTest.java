package com.automation.imob.features.bankaddres;

import com.automation.imob.ImobApplicationTests;
import com.automation.imob.components.MethodRest;
import com.automation.imob.components.config.EndpointConfig;
import com.automation.imob.components.result.CheckResponse;
import com.automation.imob.config.ImobFileJson;
import com.automation.imob.config.ImobPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import java.io.IOException;
import java.util.HashMap;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class RegisterBankAddressTest extends ImobApplicationTests {

    private String BankAddresExternalRef;

    @BeforeAll
    public void init() {
        BankAddresExternalRef = getDataFaker().getExternalReference("domiciliobancario-");
    }

    @Test
    public void save() throws IOException {
        Response response = createBankAddres(BankAddresExternalRef);

        // Check Response
        CheckResponse.checkHttpCode(201, response);
        CheckResponse.checkTextInJson("Created", response);
    }

    @Test
    public void rn004_111001() throws IOException {

        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("referenciaExterna", BankAddresExternalRef);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BANK_ADDRESS);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonBody(ImobFileJson.PATH_JSON_BANK_ADDRESS_RN004_111001, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("111001", response);
        CheckResponse.checkTextInJson("TIPO DE OPERACAO OBRIGATORIO", response);
    }

    @Test
    public void rn004_111006() throws IOException {

        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("referenciaExterna", BankAddresExternalRef);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BANK_ADDRESS);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonBody(ImobFileJson.PATH_JSON_BANK_ADDRESS_RN004_111006, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("111006", response);
        CheckResponse.checkTextInJson("CNPJ OBRIGATORIO", response);
    }

    @Test
    public void rn004_111008() throws IOException {

        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("referenciaExterna", BankAddresExternalRef);

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

    @Test
    public void rn004_111013() throws IOException {

        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("referenciaExterna", BankAddresExternalRef);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BANK_ADDRESS);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonBody(ImobFileJson.PATH_JSON_BANK_ADDRESS_RN004_111013, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("111013", response);
        CheckResponse.checkTextInJson("BANCO OBRIGATORIO", response);
    }

    @Test
    public void rn004_111015() throws IOException {

        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("referenciaExterna", BankAddresExternalRef);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BANK_ADDRESS);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonBody(ImobFileJson.PATH_JSON_BANK_ADDRESS_RN004_111015, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("111015", response);
        CheckResponse.checkTextInJson("AGENCIA OBRIGATORIO", response);
    }

    @Test
    public void rn004_111017() throws IOException {

        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("referenciaExterna", BankAddresExternalRef);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BANK_ADDRESS);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonBody(ImobFileJson.PATH_JSON_BANK_ADDRESS_RN004_111017, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("111017", response);
        CheckResponse.checkTextInJson("CONTA OBRIGATORIO", response);
    }

    @Test
    public void rn004_111018() throws IOException {

        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("referenciaExterna", BankAddresExternalRef);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BANK_ADDRESS);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonBody(ImobFileJson.PATH_JSON_BANK_ADDRESS_RN004_111018, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("111018", response);
        CheckResponse.checkTextInJson("CONVENIO DE COBRANCA OBRIGATORIO", response);
    }

    @Test
    public void rn004_111019() throws IOException {

        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("referenciaExterna", BankAddresExternalRef);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BANK_ADDRESS);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonBody(ImobFileJson.PATH_JSON_BANK_ADDRESS_RN004_111019, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("111019", response);
        CheckResponse.checkTextInJson("COD CEDENTE OBRIGATORIO", response);
    }

    @Test
    public void rn005() throws IOException {

        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("referenciaExterna", BankAddresExternalRef);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BANK_ADDRESS);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonBody(ImobFileJson.PATH_JSON_BANK_ADDRESS_RN005, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("111002", response);
        CheckResponse.checkTextInJson("TIPO DE OPERACAO INVALIDO", response);
    }

    @Test
    public void rn006() throws IOException {

        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("referenciaExterna", BankAddresExternalRef);

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
        mapValues.put("referenciaExterna", BankAddresExternalRef);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BANK_ADDRESS);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonBody(ImobFileJson.PATH_JSON_BANK_ADDRESS_RN007, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("111011", response);
        CheckResponse.checkTextInJson("REFERENCIA EXTERNA JA EXISTE", response);
    }

    @Test
    public void rn008() throws IOException {

        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("referenciaExterna", BankAddresExternalRef);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BANK_ADDRESS);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonBody(ImobFileJson.PATH_JSON_BANK_ADDRESS_RN008, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("111020", response);
        CheckResponse.checkTextInJson("JUSTIFICATIVA OBRIGATORIA", response);
    }

    @Test
    public void rn010() throws IOException {

        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("referenciaExterna", BankAddresExternalRef);

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
