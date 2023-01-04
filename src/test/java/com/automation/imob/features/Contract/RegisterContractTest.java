package com.automation.imob.features.Contract;

import com.automation.imob.ImobApplicationTests;
import com.automation.imob.components.result.CheckResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;

import java.io.IOException;
import java.util.HashMap;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class RegisterContractTest extends ImobApplicationTests{
    //store set value
    private String bankAddresExternalRef;
    private String externalRefProject;
    private String identifierContract;

    @BeforeAll
    public void save() throws IOException {
        //Declare value identifiers: BlockTower and BankAddress
        bankAddresExternalRef = getDataFaker().getExternalReference("DomRefExterna-");
        externalRefProject = getDataFaker().getExternalReference("refExternaProject-");
        identifierContract = getDataFaker().getExternalReference("contractIdentifier-");

        //Response Create BlockTower
        Response response = createBlockTower(bankAddresExternalRef, externalRefProject, identifierContract);

        // Check response
        CheckResponse.checkHttpCode(201, response);
        CheckResponse.checkTextInJson("Created", response);
    }

}