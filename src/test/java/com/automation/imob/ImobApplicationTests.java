package com.automation.imob;

import com.automation.imob.components.MethodRest;
import com.automation.imob.components.config.EndpointConfig;
import com.automation.imob.components.util.DataFaker;
import com.automation.imob.config.ConfigParams;
import io.restassured.response.Response;
import lombok.Getter;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.boot.test.context.SpringBootTest;

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

}
