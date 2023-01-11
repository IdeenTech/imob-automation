package com.automation.imob;

import com.automation.imob.components.MethodRest;
import com.automation.imob.components.config.EndpointConfig;
import com.automation.imob.components.util.DataFaker;
import com.automation.imob.config.ConfigParams;
import com.automation.imob.config.ImobFileJson;
import com.automation.imob.config.ImobPath;
import io.restassured.response.Response;
import lombok.Getter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.provider.Arguments;

import java.io.IOException;
import java.util.HashMap;
import java.util.stream.Stream;

@Getter
public class ImobApplicationTests {

    private static String accessToken;

    @BeforeAll
    public static void authentication() {
        EndpointConfig endpointConfig = new EndpointConfig();
        endpointConfig.addHeadersAuthToken(ConfigParams.BASIC_TOKEN);
        endpointConfig.addFormParams("grant_type", "client_credentials");

        endpointConfig.setUrl(ConfigParams.HOST_AUTH);
        Response response = MethodRest.callPost(endpointConfig);
        response.then().statusCode(200);

        accessToken = response.getBody().jsonPath().get("access_token");
    }

    public static String getAccessToken() {
        return accessToken;
    }

    protected DataFaker getDataFaker() {
        return DataFaker.getInstance();
    }

    //method to change the type of operation in endpoint tests
    public static Stream<Arguments> operationType() {
        return Stream.of(
                Arguments.of("A"),
                Arguments.of("C")
        );
    }

    protected EndpointConfig getEndpointConfig(String path) {
        EndpointConfig endpointConfig = new EndpointConfig();
        endpointConfig.addHeadersJson(getAccessToken());
        endpointConfig.setUrl(ConfigParams.HOST.concat(path));
        return endpointConfig;
    }

    protected Response createBankAddres(String bankAddresExternalRef) throws IOException {
        //Create dynamics variables
        Integer bank = getDataFaker().getNumberCharacters(3);
        Integer agency = getDataFaker().getNumberCharacters(4);
        Integer account = getDataFaker().getNumberCharacters(6);

        //Apply dynamics variables
        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("referenciaExterna", bankAddresExternalRef);
        mapValues.put("banco", bank);
        mapValues.put("agencia", agency);
        mapValues.put("conta", account);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BANK_ADDRESS);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonBody(ImobFileJson.PATH_JSON_BANK_ADDRESS_SAVE, mapValues));


        return MethodRest.callPost(endpointConfig);
    }

    protected Response createBuilding(String bankAddresExternalRef, String externalRefProject) throws IOException {

        //Create dynamics variables
        Integer cns = getDataFaker().getNumberCharacters(6);
        Integer registrationNumber = getDataFaker().getNumberCharacters(7);

        //using the creation of the Bank Adress creation
        createBankAddres(bankAddresExternalRef);

        //Apply dynamics variables
        HashMap<String, Object> mapValuesBuilding = new HashMap<>();
        mapValuesBuilding.put("referenciaExternaProjeto", externalRefProject);
        mapValuesBuilding.put("domicilioBancario", bankAddresExternalRef);
        mapValuesBuilding.put("cns", cns);
        mapValuesBuilding.put("numeroMatricula", registrationNumber);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BUILDING);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BUILDING_SAVE, mapValuesBuilding));

        // Call endpoint
        return MethodRest.callPost(endpointConfig);
    }

    protected Response createBlockTower(String bankAddresExternalRef, String externalRefProject, String identifierBlockTower) throws IOException {

        //using the creation of the Building creation
        createBuilding(bankAddresExternalRef, externalRefProject);

        //Apply dynamics variables
        HashMap<String, Object> mapValuesBlockTower = new HashMap<>();
        mapValuesBlockTower.put("referenciaExternaProjeto", externalRefProject);
        mapValuesBlockTower.put("domicilioBancario", bankAddresExternalRef);
        mapValuesBlockTower.put("identificadorQuadraTorre", identifierBlockTower);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BLOCK_TOWER);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BLOCK_TOWER_SAVE, mapValuesBlockTower));

        // Call endpoint
        return MethodRest.callPost(endpointConfig);
    }


    protected Response createUnity(String bankAddresExternalRef, String externalRefProject, String identifierBlockTower, String identifierUnity) throws IOException {

        //using the creation of the Block/Tower creation
        createBlockTower(bankAddresExternalRef, externalRefProject,identifierBlockTower);

        //Apply dynamics variables
        HashMap<String, Object> mapValuesUnity = new HashMap<>();
        mapValuesUnity.put("referenciaExternaProjeto", externalRefProject);
        mapValuesUnity.put("domicilioBancario", bankAddresExternalRef);
        mapValuesUnity.put("identificadorQuadraTorre", identifierBlockTower);
        mapValuesUnity.put("identificadorUnidade", identifierUnity);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_UNITY);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_UNITY_SAVE, mapValuesUnity));

        // Call endpoint
        return MethodRest.callPost(endpointConfig);
    }

    protected Response createContract(String bankAddresExternalRef, String externalRefProject, String identifierBlockTower, String identifierUnity, String identifierContract) throws IOException {

        createBankAddres(bankAddresExternalRef);
         bankAddresExternalRef = getDataFaker().getWorld() ;

        //using the creation of the createUnity creation
        createUnity(bankAddresExternalRef, externalRefProject, identifierBlockTower, identifierUnity);

        //Apply dynamics variables
        HashMap<String, Object> mapValuesContract = new HashMap<>();
        mapValuesContract.put("referenciaExternaProjeto", externalRefProject);
        mapValuesContract.put("domicilioBancario", bankAddresExternalRef);
        mapValuesContract.put("referenciaExternaContrato", identifierContract);
        mapValuesContract.put("quadraTorre", identifierBlockTower);
        mapValuesContract.put("unidade", identifierUnity);


        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_CONTRACT);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_CONTRACT_SAVE, mapValuesContract));

        // Call endpoint
        return MethodRest.callPost(endpointConfig);
    }

}
