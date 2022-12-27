package com.automation.imob.features.Building;

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
public class UpdateBuildingTest  extends ImobApplicationTests {
    //store set value
    private String bankAddresExternalRef;
    private String externalRefProject;

    @BeforeAll
    public void createBuilidng() throws IOException{
        //Declare value identifiers: Building and BankAddress
        bankAddresExternalRef = getDataFaker().getExternalReference("DomRefExterna-");
        externalRefProject = getDataFaker().getExternalReference("UpdateRefExternaProject-");

        //Response Create Building
        Response response = createBuilding(bankAddresExternalRef, externalRefProject);

        // Check Response
        CheckResponse.checkHttpCode(201, response);
        CheckResponse.checkTextInJson("Created", response);
    }


    public HashMap<String, Object> getCommonsValues(){
        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("domicilioBancario", bankAddresExternalRef);
        mapValues.put("referenciaExternaProjeto", externalRefProject);
        mapValues.put("tipoOperacao", "A");
        return mapValues;
    }

    @Test
    public void update()throws IOException{

        //insert "A" in "tipoOperacao" for update Building
        HashMap<String, Object> mapValues = getCommonsValues();

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BUILDING);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BUILDING_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("201", response);
        CheckResponse.checkTextInJson("Created", response);
    }
    @Test
    public void update_rn012_101003()throws IOException{

        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("domicilioBancario", bankAddresExternalRef);
        mapValues.put("referenciaExternaProjeto", "");
        mapValues.put("tipoOperacao", "A");

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
        HashMap<String, Object> mapValues = getCommonsValues();
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
}