package com.automation.imob.features.unity;

import com.automation.imob.ImobApplicationTests;
import com.automation.imob.components.result.CheckResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.io.IOException;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class RegisterAndUpdateUnityTest extends ImobApplicationTests {

    // Store set value
    private String bankAddressExternalRef;
    private String externalRefProject;
    private String identifierBlockTower;
    private String identifierUnity;

    @Test
    public void save() throws IOException {

        //Declare value identifiers: BlockTower and BankAddress
        bankAddressExternalRef = getDataFaker().getExternalReference("DomRefExterna-");
        externalRefProject = getDataFaker().getExternalReference("refExternaProject-");
        identifierBlockTower = getDataFaker().getExternalReference("blockToweridentifier-");
        identifierUnity = getDataFaker().getExternalReference("UnityIdentifier-");

        //Response create Unity
        Response response = createUnity(bankAddressExternalRef, externalRefProject, identifierBlockTower, identifierUnity);

        // Check response
        CheckResponse.checkHttpCode(201, response);
        CheckResponse.checkTextInJson("Created", response);
    }
}
