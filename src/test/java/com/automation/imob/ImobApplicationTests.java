package com.automation.imob;

import com.automation.imob.components.MethodRest;
import com.automation.imob.components.config.EndpointConfig;
import com.automation.imob.config.ConfigParams;
import io.restassured.response.Response;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.junit.BeforeClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Getter
public class ImobApplicationTests {

    @Autowired
    private ConfigParams configParams;





}
