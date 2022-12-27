package com.automation.imob.features.bankaddres;

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
import org.junit.jupiter.params.provider.ValueSource;

import java.io.IOException;
import java.util.HashMap;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UpdateBankAddressTest extends ImobApplicationTests {

    private String bankAdressExternalRef;

    @BeforeAll
    public void save() throws IOException {
        bankAdressExternalRef = getDataFaker().getExternalReference("alterardomiciliobancario-");

        Response response = createBankAddres(bankAdressExternalRef);

        //Check Response
        CheckResponse.checkHttpCode(201, response);
        CheckResponse.checkTextInJson("Created", response);
    }

    public HashMap<String, Object> getCommonsValues() {
        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("referenciaExterna", bankAdressExternalRef);
        mapValues.put("tipoOperacao", "A");

        return mapValues;
    }

    @Test
    public void update_rn004_111006() throws IOException {

        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("cnpj","");

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BANK_ADDRESS);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonBody(ImobFileJson.PATH_JSON_BANK_ADDRESS_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("111006", response);
        CheckResponse.checkTextInJson("CNPJ OBRIGATORIO", response);
    }

    @Test
    public void update_rn004_111008() throws IOException {

        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("razaoSocial", "");

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BANK_ADDRESS);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonBody(ImobFileJson.PATH_JSON_BANK_ADDRESS_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("111008", response);
        CheckResponse.checkTextInJson("RAZAO SOCIAL OBRIGATORIO", response);
    }

    @Test
    public void update_rn111010() throws IOException {

        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("referenciaExterna","");

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BANK_ADDRESS);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonBody(ImobFileJson.PATH_JSON_BANK_ADDRESS_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("111010", response);
        CheckResponse.checkTextInJson("REFERENCIA EXTERNA OBRIGATORIO", response);
    }

    @Test
    public void update_rn004_111013() throws IOException{
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("banco","");

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BANK_ADDRESS);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonBody(ImobFileJson.PATH_JSON_BANK_ADDRESS_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("111013", response);
        CheckResponse.checkTextInJson("BANCO OBRIGATORIO", response);
    }

    @Test
    public void update_rn004_111015() throws IOException{

        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("agencia","");

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BANK_ADDRESS);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonBody(ImobFileJson.PATH_JSON_BANK_ADDRESS_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("111015", response);
        CheckResponse.checkTextInJson("AGENCIA OBRIGATORIO", response);
    }

    @Test
    public void update_rn004_111017() throws IOException{

        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("conta","");

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BANK_ADDRESS);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonBody(ImobFileJson.PATH_JSON_BANK_ADDRESS_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("111017", response);
        CheckResponse.checkTextInJson("CONTA OBRIGATORIO", response);
    }

    @Test
    public void update_rn004_111018() throws IOException {

        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("convenioCobranca","");

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BANK_ADDRESS);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonBody(ImobFileJson.PATH_JSON_BANK_ADDRESS_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("111018", response);
        CheckResponse.checkTextInJson("CONVENIO DE COBRANCA OBRIGATORIO", response);
    }

    @Test
    public void update_rn004_111019() throws IOException{

        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("codigoCedente","");

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BANK_ADDRESS);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonBody(ImobFileJson.PATH_JSON_BANK_ADDRESS_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("111019", response);
        CheckResponse.checkTextInJson("COD CEDENTE OBRIGATORIO", response);
    }

    @DisplayName("update_rn005 Testing invalid OPERATION TYPE")
    @ParameterizedTest
    @ValueSource(strings = {"1", "a", "B"})
    public void update_rn005(String invalidOperationType) throws IOException{

        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("tipoOperacao", invalidOperationType);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BANK_ADDRESS);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonBody(ImobFileJson.PATH_JSON_BANK_ADDRESS_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("111002", response);
        CheckResponse.checkTextInJson("TIPO DE OPERACAO INVALIDO", response);
    }

    @DisplayName("update_rn006 Testing invalid CNPJ")
    @ParameterizedTest
    @ValueSource(strings = {"999999999999999", "a", "0000000"})
    public void update_rn006(String invalidCNPJ) throws IOException{

        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("cnpj", invalidCNPJ);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BANK_ADDRESS);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonBody(ImobFileJson.PATH_JSON_BANK_ADDRESS_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("111007", response);
        CheckResponse.checkTextInJson("CNPJ INVALIDO", response);
    }

    @Test
    public void update_rn007() throws IOException{

        Response updateResponse = createBankAddres(bankAdressExternalRef);

        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("referenciaExterna",bankAdressExternalRef);

        // Check Response
        CheckResponse.checkTextInJson("111011", updateResponse);
        CheckResponse.checkTextInJson("REFERENCIA EXTERNA JA EXISTE", updateResponse);
    }

    //
    @Test
    public void update_rn008() throws IOException{

        // Creating value cnpj
        String cnpj = getDataFaker().getCnpj(false);

        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("justificativa","");
        mapValues.put("cnpj", cnpj);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BANK_ADDRESS);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonBody(ImobFileJson.PATH_JSON_BANK_ADDRESS_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("111020", response);
        CheckResponse.checkTextInJson("JUSTIFICATIVA OBRIGATORIA", response);
    }

    @DisplayName("update_rn010 Testing invalid ASSIGNMENT CODE")
    @ParameterizedTest
    @ValueSource(strings = {"99999999", "a", "00000000"})
    public void update_rn010(String invalidCodCedente)throws IOException{

        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("codigoCedente",invalidCodCedente);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BANK_ADDRESS);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonBody(ImobFileJson.PATH_JSON_BANK_ADDRESS_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("111028", response);
        CheckResponse.checkTextInJson("COD CEDENTE INVALIDO", response);
    }


}












