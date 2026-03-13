package pom_pattern.utils;

import java.util.List;
import java.util.Map;

public class KudoDataGateway {

    private final KudoApiService apiService;

    public KudoDataGateway() {
        this.apiService = new KudoApiService();
    }

    public void seedKudos(String from, List<Map<String, String>> kudosData) {
        apiService.seedKudos(from, kudosData);
    }

    public long getTotalElements() {
        return apiService.getTotalElements();
    }
}
