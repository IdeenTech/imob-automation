package com.automation.imob.bankaddres;
import com.automation.imob.ImobApplicationTests;
import com.automation.imob.components.MethodRest;
import com.automation.imob.components.config.EndpointConfig;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;

public class RegisterBankAddressTest extends ImobApplicationTests {
    private String ACCESS_TOKEN;

    @BeforeAll
    public void authentication(){
        EndpointConfig endpointConfig = new EndpointConfig();
        endpointConfig.addHeaders("Authorization", getConfigParams().getBasicToken());
        endpointConfig.addHeaders("Content-Type", "multipart/form-data; boundary=<calculated when request is sent>");
        endpointConfig.addHeaders("Content-Length","<calculated when request is sent>");
        endpointConfig.addHeaders("Host", "<calculated when request is sent>");
        endpointConfig.addHeaders("Accept", "*/*");
        endpointConfig.addHeaders("Accept-Encoding", "gzip,deflate,br");
        endpointConfig.addHeaders("Connection", "keep-alive");

        endpointConfig.setUrl(getConfigParams().getHostAuth());

        Response response = MethodRest.callPost(endpointConfig);
        response.then().statusCode(200);

        ResponseBody body = response.getBody();
        ACCESS_TOKEN = body.jsonPath().get("access_token");
        System.out.println(ACCESS_TOKEN);
    }
    @BeforeEach
    public void common(){
        EndpointConfig endpointConfig = new EndpointConfig();
        endpointConfig.addHeaders("Authorization", ACCESS_TOKEN);
        endpointConfig.addHeaders("Content-Type", "application/json");
        endpointConfig.addHeaders("Connection", "keep-alive");
        endpointConfig.addHeaders("Accept-Encoding", "gzip,deflate,br");
        endpointConfig.addHeaders("Accept", "*/*");
        endpointConfig.addHeaders("Host", "<calculated when request is sent>");
        endpointConfig.addHeaders("Content-Length", "<calculated when request is sent>");
        endpointConfig.addHeaders("Content-Type", "text/plain");
        endpointConfig.setUrl(getConfigParams().getHost().concat("/domiciliobancario"));
    }
    @Test
    public void save() throws IOException {
        EndpointConfig endpointConfig = new EndpointConfig();
        endpointConfig.setBody(endpointConfig.setJsonFileBody("json/bankaddres/save.json"));

        Response response = MethodRest.callPost(endpointConfig);
        response.then().statusCode(201);
    }

    @Test
    public void rn004_111001() throws IOException {
        EndpointConfig endpointConfig = new EndpointConfig();
        endpointConfig.setBody(endpointConfig.setJsonFileBody("json/bankaddres/rn004-111001.json"));
        Response response = MethodRest.callPost(endpointConfig);

        Assert.assertTrue(response.getBody().asString().equals("111001"));
        Assert.assertTrue(response.getBody().asString().equals("TIPO DE OPERACAO OBRIGATORIO"));

    }

}
