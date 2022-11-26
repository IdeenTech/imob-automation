package com.automation.imob.features.covenants.registercovenants;

import com.automation.imob.ImobApplicationTests;
import com.automation.imob.components.MethodRest;
import com.automation.imob.components.config.EndpointConfig;
import com.automation.imob.components.result.CheckResponse;
import com.automation.imob.config.ConfigParams;
import com.automation.imob.config.ImobFileJson;
import com.automation.imob.config.ImobPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashMap;

public class RegisterCovenantsTest extends ImobApplicationTests {
    @Test
    public void registerCovenants() throws IOException {
        HashMap<String, Object> mapValues = new HashMap<>();
        String idConvents = getDataFaker().getIdCovenant();
        mapValues.put("identificadorCovenant",idConvents);
        // Create Request
        EndpointConfig endpointConfig = new EndpointConfig();
        endpointConfig.addHeadersJson(getAccessToken());
        endpointConfig.setUrl(ConfigParams.HOST.concat(ImobPath.PATH_REGISTER_COVENANTS));
        endpointConfig.setBody(endpointConfig.alterValuesInJsonArrayBody(ImobFileJson.PATH_JSON_REGISTER_COVENANTS, mapValues));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkHttpCode(201, response);
        CheckResponse.checkTextInJson("Created", response);
    }

    @Test
    public void rn006_112003() throws IOException {
        // Create Request
        EndpointConfig endpointConfig = new EndpointConfig();
        endpointConfig.addHeadersJson(getAccessToken());
        endpointConfig.setUrl(ConfigParams.HOST.concat(ImobPath.PATH_REGISTER_COVENANTS));
        endpointConfig.setBody(endpointConfig.setJsonFileBodyArray(ImobFileJson.PATH_JSON_REGISTER_COVENANTS_RN006_112003));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("112003",  response);
        CheckResponse.checkTextInJson("IDENTIFICADOR DO COVENANTS OBRIGATORIO", response);
    }
    @Test
    public void rn006_112005() throws IOException {
        // Create Request
        EndpointConfig endpointConfig = new EndpointConfig();
        endpointConfig.addHeadersJson(getAccessToken());
        endpointConfig.setUrl(ConfigParams.HOST.concat(ImobPath.PATH_REGISTER_COVENANTS));
        endpointConfig.setBody(endpointConfig.setJsonFileBodyArray(ImobFileJson.PATH_JSON_REGISTER_COVENANTS_RN006_112005));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("112005",  response);
        CheckResponse.checkTextInJson("VARIACAO PERCENTUAL SALDO RENEGOCIACAO OBRIGATORIA", response);
    }
    @Test
    public void rn006_112007() throws IOException {
        // Create Request
        EndpointConfig endpointConfig = new EndpointConfig();
        endpointConfig.addHeadersJson(getAccessToken());
        endpointConfig.setUrl(ConfigParams.HOST.concat(ImobPath.PATH_REGISTER_COVENANTS));
        endpointConfig.setBody(endpointConfig.setJsonFileBodyArray(ImobFileJson.PATH_JSON_REGISTER_COVENANTS_RN006_112007));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("112007",  response);
        CheckResponse.checkTextInJson("VARIACAO FINANCEIRA SALDO RENEGOCIACAO OBRIGATORIA", response);
    }
    @Test
    public void rn006_112009() throws IOException {
        // Create Request
        EndpointConfig endpointConfig = new EndpointConfig();
        endpointConfig.addHeadersJson(getAccessToken());
        endpointConfig.setUrl(ConfigParams.HOST.concat(ImobPath.PATH_REGISTER_COVENANTS));
        endpointConfig.setBody(endpointConfig.setJsonFileBodyArray(ImobFileJson.PATH_JSON_REGISTER_COVENANTS_RN006_112009));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("112009",  response);
        CheckResponse.checkTextInJson("DESCONTO NOMINAL NA CONCILIACAO DE UM PAGAMENTO DE PARCELA OBRIGATORIO", response);
    }

    @Test
    public void rn006_112011() throws IOException {
        // Create Request
        EndpointConfig endpointConfig = new EndpointConfig();
        endpointConfig.addHeadersJson(getAccessToken());
        endpointConfig.setUrl(ConfigParams.HOST.concat(ImobPath.PATH_REGISTER_COVENANTS));
        endpointConfig.setBody(endpointConfig.setJsonFileBodyArray(ImobFileJson.PATH_JSON_REGISTER_COVENANTS_RN006_112011));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("112011",  response);
        CheckResponse.checkTextInJson("ACRESCIMO NOMINAL NA CONCILIACAO DE UM PAGAMENTO DE PARCELA OBRIGATORIO", response);
    }
    @Test
    public void rn006_112014() throws IOException {
        // Create Request
        EndpointConfig endpointConfig = new EndpointConfig();
        endpointConfig.addHeadersJson(getAccessToken());
        endpointConfig.setUrl(ConfigParams.HOST.concat(ImobPath.PATH_REGISTER_COVENANTS));
        endpointConfig.setBody(endpointConfig.setJsonFileBodyArray(ImobFileJson.PATH_JSON_REGISTER_COVENANTS_RN006_112014));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("112014",  response);
        CheckResponse.checkTextInJson("REGISTRO DE VENDA ABAIXO DA TABELA DE PRECOS OBRIGATORIO", response);
    }
    @Test
    public void rn006_112017() throws IOException {
        // Create Request
        EndpointConfig endpointConfig = new EndpointConfig();
        endpointConfig.addHeadersJson(getAccessToken());
        endpointConfig.setUrl(ConfigParams.HOST.concat(ImobPath.PATH_REGISTER_COVENANTS));
        endpointConfig.setBody(endpointConfig.setJsonFileBodyArray(ImobFileJson.PATH_JSON_REGISTER_COVENANTS_RN006_112017));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("112017",  response);
        CheckResponse.checkTextInJson("CONCILICACAO NAO AUTOMATICA OBRIGATORIO", response);
    }
    @Test
    public void rn006_112019() throws IOException {
        // Create Request
        EndpointConfig endpointConfig = new EndpointConfig();
        endpointConfig.addHeadersJson(getAccessToken());
        endpointConfig.setUrl(ConfigParams.HOST.concat(ImobPath.PATH_REGISTER_COVENANTS));
        endpointConfig.setBody(endpointConfig.setJsonFileBodyArray(ImobFileJson.PATH_JSON_REGISTER_COVENANTS_RN006_112019));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("112019",  response);
        CheckResponse.checkTextInJson("APROVACAO NA DATA PREVISTA PARA O HABITE-SE/TVO OBRIGATORIA", response);
    }
    @Test
    public void rn007() throws IOException {
        // Create Request
        EndpointConfig endpointConfig = new EndpointConfig();
        endpointConfig.addHeadersJson(getAccessToken());
        endpointConfig.setUrl(ConfigParams.HOST.concat(ImobPath.PATH_REGISTER_COVENANTS));
        endpointConfig.setBody(endpointConfig.setJsonFileBodyArray(ImobFileJson.PATH_JSON_REGISTER_COVENANTS_RN007));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("112006",  response);
        CheckResponse.checkTextInJson("VARIACAO PERCENTUAL SALDO RENEGOCIACAO INVALIDA", response);
    }
    @Test
    public void rn008() throws IOException {
        // Create Request
        EndpointConfig endpointConfig = new EndpointConfig();
        endpointConfig.addHeadersJson(getAccessToken());
        endpointConfig.setUrl(ConfigParams.HOST.concat(ImobPath.PATH_REGISTER_COVENANTS));
        endpointConfig.setBody(endpointConfig.setJsonFileBodyArray(ImobFileJson.PATH_JSON_REGISTER_COVENANTS_RN008));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("112008",  response);
        CheckResponse.checkTextInJson("VARIACAO FINANCEIRA SALDO RENEGOCIACAO INVALIDA", response);
    }
    @Test
    public void rn009() throws IOException {
        // Create Request
        EndpointConfig endpointConfig = new EndpointConfig();
        endpointConfig.addHeadersJson(getAccessToken());
        endpointConfig.setUrl(ConfigParams.HOST.concat(ImobPath.PATH_REGISTER_COVENANTS));
        endpointConfig.setBody(endpointConfig.setJsonFileBodyArray(ImobFileJson.PATH_JSON_REGISTER_COVENANTS_RN009));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("112010",  response);
        CheckResponse.checkTextInJson("DESCONTO NOMINAL NA CONCILIACAO DE UM PAGAMENTO DE PARCELA INVALIDO", response);
    }
    @Test
    public void rn010() throws IOException {
        // Create Request
        EndpointConfig endpointConfig = new EndpointConfig();
        endpointConfig.addHeadersJson(getAccessToken());
        endpointConfig.setUrl(ConfigParams.HOST.concat(ImobPath.PATH_REGISTER_COVENANTS));
        endpointConfig.setBody(endpointConfig.setJsonFileBodyArray(ImobFileJson.PATH_JSON_REGISTER_COVENANTS_RN010));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("112012",  response);
        CheckResponse.checkTextInJson("ACRESCIMO NOMINAL NA CONCILIACAO DE UM PAGAMENTO DE PARCELA INVALIDO", response);
    }
    @Test
    public void rn011() throws IOException {
        // Create Request
        EndpointConfig endpointConfig = new EndpointConfig();
        endpointConfig.addHeadersJson(getAccessToken());
        endpointConfig.setUrl(ConfigParams.HOST.concat(ImobPath.PATH_REGISTER_COVENANTS));
        endpointConfig.setBody(endpointConfig.setJsonFileBodyArray(ImobFileJson.PATH_JSON_REGISTER_COVENANTS_RN011));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("112013",  response);
        CheckResponse.checkTextInJson("DESEJA APROVAR FLUXO DE DISTRATO INVALIDO", response);
    }
    @Test
    public void rn012() throws IOException {
        // Create Request
        EndpointConfig endpointConfig = new EndpointConfig();
        endpointConfig.addHeadersJson(getAccessToken());
        endpointConfig.setUrl(ConfigParams.HOST.concat(ImobPath.PATH_REGISTER_COVENANTS));
        endpointConfig.setBody(endpointConfig.setJsonFileBodyArray(ImobFileJson.PATH_JSON_REGISTER_COVENANTS_RN012));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("112015",  response);
        CheckResponse.checkTextInJson("REGISTRO DE VENDA ABAIXO DA TABELA DE PRECOS INVALIDO", response);
    }
    @Test
    public void rn013() throws IOException {
        // Create Request
        EndpointConfig endpointConfig = new EndpointConfig();
        endpointConfig.addHeadersJson(getAccessToken());
        endpointConfig.setUrl(ConfigParams.HOST.concat(ImobPath.PATH_REGISTER_COVENANTS));
        endpointConfig.setBody(endpointConfig.setJsonFileBodyArray(ImobFileJson.PATH_JSON_REGISTER_COVENANTS_RN013));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("112016",  response);
        CheckResponse.checkTextInJson("DESEJA APROVAR O FLUXO DE CESSÃO INVALIDO", response);
    }
    @Test
    public void rn014() throws IOException {
        // Create Request
        EndpointConfig endpointConfig = new EndpointConfig();
        endpointConfig.addHeadersJson(getAccessToken());
        endpointConfig.setUrl(ConfigParams.HOST.concat(ImobPath.PATH_REGISTER_COVENANTS));
        endpointConfig.setBody(endpointConfig.setJsonFileBodyArray(ImobFileJson.PATH_JSON_REGISTER_COVENANTS_RN014));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("112018",  response);
        CheckResponse.checkTextInJson("CONCILICACAO NAO AUTOMATICA INVALIDO", response);
    }

    @Test
    public void rn015() throws IOException {
        // Create Request
        EndpointConfig endpointConfig = new EndpointConfig();
        endpointConfig.addHeadersJson(getAccessToken());
        endpointConfig.setUrl(ConfigParams.HOST.concat(ImobPath.PATH_REGISTER_COVENANTS));
        endpointConfig.setBody(endpointConfig.setJsonFileBodyArray(ImobFileJson.PATH_JSON_REGISTER_COVENANTS_RN015));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("112020",  response);
        CheckResponse.checkTextInJson("APROVACAO NA DATA PREVISTA PARA O HABITE-SE/TVO INVALIDA", response);
    }

    //@Test implementar após fluxo basico for ajustado TODO
    public void rn016() throws IOException {
        // Create Request
        EndpointConfig endpointConfig = new EndpointConfig();
        endpointConfig.addHeadersJson(getAccessToken());
        endpointConfig.setUrl(ConfigParams.HOST.concat(ImobPath.PATH_REGISTER_COVENANTS));
        endpointConfig.setBody(endpointConfig.setJsonFileBodyArray(ImobFileJson.PATH_JSON_REGISTER_COVENANTS_RN016));

        // Call endpoint
        Response response = MethodRest.callPost(endpointConfig);

        // Check Response
        CheckResponse.checkTextInJson("112004",  response);
        CheckResponse.checkTextInJson("IDENTIFICADOR DO COVENANTS JA EXISTE", response);
    }


}
