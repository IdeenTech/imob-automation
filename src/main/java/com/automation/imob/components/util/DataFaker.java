package com.automation.imob.components.util;

import com.github.javafaker.Faker;
import lombok.ToString;

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
        return this.faker.lorem().words().toString();
    }

    public String getExternalReference(String prefix){
        return  prefix != null ? prefix.concat(getWorld()) : getWorld();
    }

    public String getWorldWithNumberCharacters(Integer numberCharacters) {
        return this.faker.lorem().characters(numberCharacters);
    }

    public Integer getNumberCharacters(Integer numberCharacters) {
        return Math.toIntExact(this.faker.number().randomNumber(numberCharacters, true));
    }

    public String getIdCovenant(){
        return "identificadorCovenant".concat(getWorldWithNumberCharacters(10));
    }

    public String getCnpj(boolean formatted) {
        return CnpjUtil.generateCnpj(formatted);
    }

    public String getCpf(boolean formatted) {
        return CpfUtil.generateCpf(formatted);
    }

}
