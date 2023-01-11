package com.automation.imob.features.unity;

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

public class InactiveUnity extends ImobApplicationTests {

    // Store set value
    private String bankAddressExternalRef;
    private String externalRefProject;
    private String identifierBlockTower;
    private String identifierUnity;

    @BeforeAll
    public void createUnity() throws IOException {

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
    public void rn005_102003( )throws IOException{
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("tipoOperacao", "I");
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

    @Test
    public void rn005_102005( )throws IOException{
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("tipoOperacao", "I");
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

    @Test
    public void rn005_102021( )throws IOException{
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("tipoOperacao", "I");
        mapValues.put("identificadorQuadraTorre", "");


        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_UNITY);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_UNITY_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("102021", response);
        CheckResponse.checkTextInJson("IDENTIFICADOR DA UNIDADE OBRIGATORIO", response);
    }

    @Test
    public void rn007( )throws IOException{
        String invalidExtRef = getDataFaker().getExternalReference("invalid -");

        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("tipoOperacao", "I");
        mapValues.put("referenciaExternaProjeto", invalidExtRef);


        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_UNITY);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_UNITY_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("102004", response);
        CheckResponse.checkTextInJson("REFERENCIA EXTERNA PROJETO NAO EXISTE", response);
    }
}