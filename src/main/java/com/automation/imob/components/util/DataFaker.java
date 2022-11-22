package com.automation.imob.components.util;

import com.github.javafaker.Faker;

import java.util.Locale;

public class DataFaker {

    private Faker faker;
    private static DataFaker dataFake;

    public static DataFaker getInstance() {
        if (dataFake == null) {
            dataFake = new DataFaker();
        }
        return dataFake;
    }

    private DataFaker() {
        this.faker = new Faker(new Locale("pt_BR"));
    }

    public String getWorld() {
        return this.faker.lorem().word();
    }

    public String getExternalReference(){
        return "domicilioBancario".concat(getWorld());
    }

    public String getWorldWithNumberCharacters(Integer numberCharacters) {
        return this.faker.lorem().characters(numberCharacters);
    }

}
