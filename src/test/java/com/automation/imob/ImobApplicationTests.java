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
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.HashMap;

@SpringBootTest
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

    protected DataFaker getDataFaker(){
        return DataFaker.getInstance();
    }
    public EndpointConfig getEndpointConfig(String path) {
        EndpointConfig endpointConfig = new EndpointConfig();
        endpointConfig.addHeadersJson(getAccessToken());
        endpointConfig.setUrl(ConfigParams.HOST.concat(path));
        return endpointConfig;
    }
    protected Response createBankAddres(String BankAddresExternalRef) throws IOException {
        //Create dynamics variables
        Integer bank = getDataFaker().getNumberCharacters(3);
        Integer agency = getDataFaker().getNumberCharacters(4);
        Integer account = getDataFaker().getNumberCharacters(6);

        //Apply dynamics variables
        HashMap<String, Object> mapValues = new HashMap<>();
        mapValues.put("referenciaExterna", BankAddresExternalRef);
        mapValues.put("banco", bank);
        mapValues.put("agencia", agency);
        mapValues.put("conta", account);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BANK_ADDRESS);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonBody(ImobFileJson.PATH_JSON_BANK_ADDRESS_SAVE, mapValues));


        return MethodRest.callPost(endpointConfig);
    }


    @Test
    protected Response CreateBuilding(String BankAddresExternalRef, String ExternalRefProject) throws IOException {

        //Create dynamics variables
        Integer cns = getDataFaker().getNumberCharacters(6);
       Integer registrationNumber = getDataFaker().getNumberCharacters(7);

       //using the creation of the Bank Adress creation
       createBankAddres(BankAddresExternalRef);

        //Apply dynamics variables
        HashMap<String, Object> mapValuesBuilding = new HashMap<>();
        mapValuesBuilding.put("referenciaExternaProjeto", ExternalRefProject);
        mapValuesBuilding.put("domicilioBancario", BankAddresExternalRef);
        mapValuesBuilding.put("cns", cns);
        mapValuesBuilding.put("numeroMatricula", registrationNumber);

        // Create Request
        EndpointConfig endpointConfig = getEndpointConfig(ImobPath.PATH_BUILDING);
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_BUILDING_SAVE, mapValuesBuilding));

        // Call endpoint
        return MethodRest.callPost(endpointConfig);
        }

}
