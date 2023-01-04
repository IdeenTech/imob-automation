package com.automation.imob.features.blockTower;

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
public class RegisterBlockTowerTest extends ImobApplicationTests {

    // Store set value
    private String bankAddressExternalRef;
    private String externalRefProject;
    private String identifierBlockTower;

    @BeforeAll
    public void save() throws IOException {
        //Declare value identifiers: BlockTower and BankAddress
        bankAddressExternalRef = getDataFaker().getExternalReference("DomRefExterna-");
        externalRefProject = getDataFaker().getExternalReference("refExternaProject-");
        identifierBlockTower = getDataFaker().getExternalReference("blockToweridentifier-");

        //Response Create BlockTower
        Response response = createBlockTower(bankAddressExternalRef, externalRefProject, identifierBlockTower);

        // Check response
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
    public void rn008_102001() throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("tipoOperacao", "");

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BLOCK_TOWER);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BLOCK_TOWER_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("102001", response);
        CheckResponse.checkTextInJson("TIPO DE OPERACAO OBRIGATORIO", response);
    }

    @ParameterizedTest
    @MethodSource("operationType")
    public void rn008_101003(final String operationType) throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("domicilioBancario", bankAddressExternalRef);
        mapValues.put("tipoOperacao", operationType);
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

    @ParameterizedTest
    @MethodSource("operationType")
    public void rn008_102005(final String operationType) throws IOException {
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("tipoOperacao", operationType);
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

    @ParameterizedTest
    @MethodSource("operationType")
    public void rn008_102007(final String operationType) throws IOException {
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("tipoOperacao", operationType);
        mapValues.put("uso", "");

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BLOCK_TOWER);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BLOCK_TOWER_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("102007", response);
        CheckResponse.checkTextInJson("USO OBRIGATORIO", response);
    }


    @ParameterizedTest
    @MethodSource("operationType")
    public void rn008_102009(final String operationType) throws IOException {
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("tipoOperacao", operationType);
        mapValues.put("dataHabiteSePrevista", "");

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BLOCK_TOWER);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BLOCK_TOWER_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("102009", response);
        CheckResponse.checkTextInJson("DATA HABITE SE PREVISTA OBRIGATORIA", response);
    }

    @ParameterizedTest
    @MethodSource("operationType")
    public void rn008_102011(final String operationType) throws IOException {
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("tipoOperacao", operationType);
        mapValues.put("dataHabiteSePrevistaPrazo", "");

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BLOCK_TOWER);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BLOCK_TOWER_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("102011", response);
        CheckResponse.checkTextInJson("DATA HABITE SE PREVISTA + PRAZO LEGAL OBRIGATORIA", response);
    }

    @ParameterizedTest
    @MethodSource("operationType")
    public void rn008_102015(final String operationType) throws IOException {
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("tipoOperacao", operationType);
        mapValues.put("evolucaoObraTotal", "");

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BLOCK_TOWER);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BLOCK_TOWER_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("102015", response);
        CheckResponse.checkTextInJson("EVOLUCAO DA OBRA TOTAL OBRIGATORIA", response);
    }


    @ParameterizedTest
    @MethodSource("operationType")
    public void rn008_102017(final String operationType) throws IOException {
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("tipoOperacao", operationType);
        mapValues.put("dataBaseEvolucaoObra", "");

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BLOCK_TOWER);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BLOCK_TOWER_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("102017", response);
        CheckResponse.checkTextInJson("DATA BASE DA EVOLUCAO DA OBRA OBRIGATORIA", response);
    }

    @ParameterizedTest
    @MethodSource("operationType")
    public void rn008_102061(final String operationType) throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("tipoOperacao", operationType);
        mapValues.put("unidadesTotalQuadraTorre", "");

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BLOCK_TOWER);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BLOCK_TOWER_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("102061", response);
        CheckResponse.checkTextInJson("UNIDADES TOTAL DA QUADRA TORRE OBRIGATORIO", response);
    }

    @ParameterizedTest
    @MethodSource("operationType")
    public void rn011_102061() throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("unidadesTotalQuadraTorre", "");

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BLOCK_TOWER);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BLOCK_TOWER_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("102061", response);
        CheckResponse.checkTextInJson("UNIDADES TOTAL DA QUADRA TORRE OBRIGATORIO", response);
    }

    /*----------------------------------------- INVALID ---------------------------------------*/
    @DisplayName("rn009 testing invalid operation Type")
    @ParameterizedTest
    @ValueSource(strings = {"b", "B", "1", "AA"})
    public void rn009(String invalidOperationType) throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("tipoOperacao", invalidOperationType);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BLOCK_TOWER);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BLOCK_TOWER_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("102002", response);
        CheckResponse.checkTextInJson("TIPO DE OPERACAO INVALIDO", response);
    }

    @DisplayName("rn010 testing invalid USO")
    @ParameterizedTest
    @ValueSource(strings = {"4", "01", "a"})
    public void rn010(String invalidUSO) throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("uso", invalidUSO);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BLOCK_TOWER);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BLOCK_TOWER_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("102008", response);
        CheckResponse.checkTextInJson("USO INVALIDO", response);
    }

    @DisplayName("rn011_102010 testing invalid habit date if speciefed")
    @ParameterizedTest
    @ValueSource(strings = {"20-10", "2022-15", "203-09", "A"})
    public void rn011_102010(String invalidDateHabit) throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("dataHabiteSePrevista", invalidDateHabit);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BLOCK_TOWER);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BLOCK_TOWER_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("102010", response);
        CheckResponse.checkTextInJson("DATA HABITE SE PREVISTA INVALIDA", response);
    }

    @DisplayName("rn011_102012 testing invalid habit date if speciefied + invalid legal term")
    @ParameterizedTest
    @ValueSource(strings = {"20-10", "2022-15", "203-09", "A"})
    public void rn011_102012(String invalidDataHabitexpc) throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("dataHabiteSePrevistaPrazo", invalidDataHabitexpc);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BLOCK_TOWER);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BLOCK_TOWER_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("102012", response);
        CheckResponse.checkTextInJson("DATA HABITE SE PREVISTA + PRAZO LEGAL INVALIDA", response);
    }

    @DisplayName("rn011_102013 testing invalid habit date if real")
    @ParameterizedTest
    @ValueSource(strings = {"20-10", "2022-15", "203-09", "A"})
    public void rn011_102013(String invalidDatahabIfReal) throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("dataHabiteSeReal", invalidDatahabIfReal);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BLOCK_TOWER);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BLOCK_TOWER_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("102013", response);
        CheckResponse.checkTextInJson("DATA HABITE SE REAL INVALIDA", response);
    }

    @DisplayName("rn011_102014 testing invalid realese date")
    @ParameterizedTest
    @ValueSource(strings = {"20-10", "2022-15", "203-09", "A"})
    public void rn011_102014(String invalidRealeseDate) throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("dataLancamento", invalidRealeseDate);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BLOCK_TOWER);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BLOCK_TOWER_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("102014", response);
        CheckResponse.checkTextInJson("DATA DO LANCAMENTO INVALIDA", response);
    }

    @DisplayName("rn011_102018 testing invalid base date evolution")
    @ParameterizedTest
    @ValueSource(strings = {"20-10", "2022-15", "203-09", "A"})
    public void rn011_102018(String invalidBaseDateEvol) throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("dataBaseEvolucaoObra", invalidBaseDateEvol);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BLOCK_TOWER);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BLOCK_TOWER_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("102018", response);
        CheckResponse.checkTextInJson("DATA BASE DA EVOLUCAO DA OBRA INVALIDA", response);
    }


    @ParameterizedTest
    @MethodSource("operationType")
    public void rn015(final String operationType) throws IOException {
        String domicilioFakeBankAddres = getDataFaker().getExternalReference("random-");

        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("tipoOperacao", operationType);
        mapValues.put("referenciaExternaProjeto", externalRefProject);
        mapValues.put("identificadorQuadraTorre", identifierBlockTower);
        mapValues.put("domicilioBancario", domicilioFakeBankAddres);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BLOCK_TOWER);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BLOCK_TOWER_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("102019", response);
        CheckResponse.checkTextInJson("DOMICILIO BANCARIO INVALIDO", response);
    }

    /* ------------------------------------ OTHERS -------------------------------------------------------*/


    @ParameterizedTest
    @MethodSource("operationType")
    public void rn012_102004(String operationType) throws IOException {
        //Dynamic variable created when saving bank address
        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("tipoOperacao", operationType);
        mapValues.put("domicilioBancario", bankAddressExternalRef);
        mapValues.put("identificadorQuadraTorre", identifierBlockTower);
        mapValues.put("referenciaExternaProjeto", "teste");

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BLOCK_TOWER);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BLOCK_TOWER_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("102004", response);
        CheckResponse.checkTextInJson("REFERENCIA EXTERNA PROJETO NAO EXISTE", response);
    }

    @ParameterizedTest
    @MethodSource("operationType")
    public void rn016() throws IOException {
        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("domicilioBancario", bankAddressExternalRef);
        mapValues.put("identificadorQuadraTorre", identifierBlockTower);
        mapValues.put("referenciaExternaProjeto", externalRefProject);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BLOCK_TOWER);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BLOCK_TOWER_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);
        response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("102058", response);
        CheckResponse.checkTextInJson("IDENTIFICADOR DE QUADRA/TORRE DUPLICADO", response);
    }

    @ParameterizedTest
    @ValueSource(strings = "9999")
    public void rn020(String invalidUnitsTotalBlockTower) throws IOException {
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("unidadesTotalQuadraTorre", invalidUnitsTotalBlockTower);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BLOCK_TOWER);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BLOCK_TOWER_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("100005", response);
        CheckResponse.checkTextInJson("UNIDADES TOTAL DA QUADRA TORRE DEVE CONTER NO MAXIMO 3 POSICOES", response);
    }

    @ParameterizedTest
    @ValueSource(strings = "9999")
    public void rn021(String invalidNumbOfFloors) throws IOException {
        HashMap<String, Object> mapValues = getCommonsValues();
        mapValues.put("numeroPavimentos", invalidNumbOfFloors);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BLOCK_TOWER);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BLOCK_TOWER_SAVE, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("100005", response);
        CheckResponse.checkTextInJson("NUMERO DE PAVIMENTOS DEVE CONTER NO MAXIMO 3 POSICOES", response);
    }

}