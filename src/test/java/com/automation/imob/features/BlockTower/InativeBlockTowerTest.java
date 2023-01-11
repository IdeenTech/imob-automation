package com.automation.imob.features.BlockTower;

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
public class InativeBlockTowerTest extends ImobApplicationTests {
    private String bankAddresExternalRef;
    private String externalRefProject;
    private String identifierBlockTower;

    @BeforeAll
    public void createBlockTower() throws IOException {
        //Declare value identifiers: Building, BlockTower and BankAddress
        bankAddresExternalRef = getDataFaker().getExternalReference("DomRefExterna-");
        externalRefProject = getDataFaker().getExternalReference("refExternaProject-");
        identifierBlockTower = getDataFaker().getExternalReference("blockToweridentifier-");

        //create Block tower
        createBlockTower(bankAddresExternalRef, externalRefProject, identifierBlockTower);
    }

    @Test
    public void inativeBlockTower() throws IOException {
        //Declare value identifiers: Building, BlockTower and BankAddress
        bankAddresExternalRef = getDataFaker().getExternalReference("InativeDomRefExterna-");
        externalRefProject = getDataFaker().getExternalReference("InativefExternaProject-");
        createBlockTower(bankAddresExternalRef, externalRefProject, identifierBlockTower);

        //create Building
        Response response = createBlockTower(bankAddresExternalRef, externalRefProject, identifierBlockTower);
        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("tipoOperacao", "I");

        // Check Response
        CheckResponse.checkTextInJson("200", response);
        CheckResponse.checkTextInJson(externalRefProject, response);
    }

    @Test
    public void rn005_102003() throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("domicilioBancario", bankAddresExternalRef);
        mapValues.put("identificadorQuadraTorre", identifierBlockTower);
        mapValues.put("tipoOperacao", "I");
        mapValues.put("referenciaExternaProjeto", "");

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BLOCK_TOWER);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BLOCK_TOWER_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("102003", response);
        CheckResponse.checkTextInJson("REFERENCIA EXTERNA PROJETO OBRIGATORIA", response);
    }
    @Test
    public void rn005_102005() throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("domicilioBancario", bankAddresExternalRef);
        mapValues.put("referenciaExternaProjeto", externalRefProject);
        mapValues.put("tipoOperacao", "I");
        mapValues.put("identificadorQuadraTorre", "");

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BLOCK_TOWER);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BLOCK_TOWER_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("102005", response);
        CheckResponse.checkTextInJson("IDENTIFICADOR DA QUADRA TORRE OBRIGATORIO", response);
    }

    @Test
    public void rn007() throws IOException {
        String externalReference = getDataFaker().getWorld();

        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("domicilioBancario", bankAddresExternalRef);
        mapValues.put("identificadorQuadraTorre", identifierBlockTower);
        mapValues.put("tipoOperacao", "I");
        mapValues.put("referenciaExternaProjeto", externalReference);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BLOCK_TOWER);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BLOCK_TOWER_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("102004", response);
        CheckResponse.checkTextInJson("REFERENCIA EXTERNA PROJETO NAO EXISTE", response);
    }

    @Test
    public void rn010() throws IOException {

        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("domicilioBancario", bankAddresExternalRef);
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
    @Test
    public void rn009() throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("domicilioBancario", bankAddresExternalRef);
        mapValues.put("referenciaExternaProjeto", externalRefProject);
        mapValues.put("tipoOperacao", "I");

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BLOCK_TOWER);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BLOCK_TOWER_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);
        response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("102063", response);
        CheckResponse.checkTextInJson("QUADRA/TORRE JA ESTA INATIVA", response);
    }
}
