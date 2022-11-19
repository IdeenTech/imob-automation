package com.automation.imob;

import com.automation.imob.config.ConfigParams;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Getter
public class ImobApplicationTests {

    @Autowired
    private ConfigParams configParams;



}
