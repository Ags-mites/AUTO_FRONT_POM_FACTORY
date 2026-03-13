package pom_pattern.utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KudoApiService {

    private final KudoEndpointsProvider endpoints;

    public KudoApiService() {
        this.endpoints = new KudoEndpointsProvider();
    }

    public void seedKudos(String from, List<Map<String, String>> kudosData) {
        for (Map<String, String> kudo : kudosData) {
            Map<String, String> mutableKudo = new HashMap<>(kudo);
            mutableKudo.put("from", from);
            RestAssured
                    .given()
                    .contentType("application/json")
                    .body(mutableKudo)
                    .when()
                    .post(endpoints.getKudosEndpoint());
        }
    }

    public long getTotalElements() {
        Response response = RestAssured
                .when()
                .get(endpoints.getKudosCountEndpoint());
        
        if (response.getStatusCode() == 200) {
            return response.jsonPath().getLong("totalElements");
        }
        return 0;
    }

    public Response createKudo(Map<String, String> kudoData) {
        return RestAssured
                .given()
                .contentType("application/json")
                .body(kudoData)
                .when()
                .post(endpoints.getKudosEndpoint());
    }
}
