package com.automation.imob.components.util;

import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class JsonUtil {

    public static String readFileJson(String pathFileJson) throws IOException {
        return new JSONObject(FileUtils.readFileToString(getJsonFile(pathFileJson), StandardCharsets.UTF_8.toString())).toString();
    }

    public static JSONObject getJsonValues(String pathFileJson) throws IOException {
        return new JSONObject(FileUtils.readFileToString(getJsonFile(pathFileJson), StandardCharsets.UTF_8.toString()));
    }

    public static JSONArray getJsonValuesArray(String pathFileJson) throws IOException {
        return new JSONArray(FileUtils.readFileToString(getJsonFile(pathFileJson), StandardCharsets.UTF_8.toString()));
    }

    private static File getJsonFile(String pathFileJson) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        return new File(Objects.requireNonNull(classLoader.getResource(pathFileJson)).getFile());
    }

    public static String readFileJsonArray(String pathFileJson) throws IOException {
        return new JSONArray(FileUtils.readFileToString(getJsonFile(pathFileJson), StandardCharsets.UTF_8.toString())).toString();
    }


}
