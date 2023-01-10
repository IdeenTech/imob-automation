package com.automation.imob.features.building;

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
public class InactiveBuildingTest extends ImobApplicationTests {

    private String bankAddressExternalRef;
    private String externalRefProject;

    @BeforeAll
    public void createBuilding() throws IOException {
        //Declare value identifiers: Building and BankAddress
        bankAddressExternalRef = getDataFaker().getExternalReference("DomRefExterna-");
        externalRefProject = getDataFaker().getExternalReference("refExternaProject-");

        //create Building
        createBuilding(bankAddressExternalRef, externalRefProject);
    }

    @Test
    public void inactiveBuilding() throws IOException {
        //Declare value identifiers: Building and BankAddress
        bankAddressExternalRef = getDataFaker().getExternalReference("InativDomRefExterna-");
        externalRefProject = getDataFaker().getExternalReference("InativrefExternaProject-");
        createBuilding(bankAddressExternalRef, externalRefProject);

        //create Building
        Response response = createBuilding(bankAddressExternalRef, externalRefProject);

        // Check Response
        CheckResponse.checkTextInJson("200", response);
        CheckResponse.checkTextInJson(externalRefProject, response);
    }

    @Test
    public void rn006() throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("domicilioBancario", bankAddressExternalRef);
        mapValues.put("tipoOperacao", "I");
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
    public void rn009() throws IOException {
        String externalReference = getDataFaker().getWorld();

        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("domicilioBancario", bankAddressExternalRef);
        mapValues.put("tipoOperacao", "I");
        mapValues.put("referenciaExternaProjeto", externalReference);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BUILDING);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BUILDING_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("101044", response);
        CheckResponse.checkTextInJson("REFERENCIA EXTERNA PROJETO NAO EXISTE", response);
    }

    @Test
    public void rn010() throws IOException {

        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("domicilioBancario", bankAddressExternalRef);
        mapValues.put("tipoOperacao", "I");
        mapValues.put("referenciaExternaProjeto", externalRefProject);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BUILDING);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BUILDING_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);
        response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("101054", response);
        CheckResponse.checkTextInJson("EMPREENDIMENTO INATIVO", response);
    }
}