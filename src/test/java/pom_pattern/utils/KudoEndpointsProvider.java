package pom_pattern.utils;

public class KudoEndpointsProvider {

    private static final String DEFAULT_PRODUCER_API_BASE_URL = "http://localhost:8082";
    private static final String API_V1 = "/api/v1";

    private final String producerApiBaseUrl;

    public KudoEndpointsProvider() {
        this.producerApiBaseUrl = System.getProperty("api.producer.base.url", DEFAULT_PRODUCER_API_BASE_URL);
    }

    public String getProducerApiBaseUrl() {
        return producerApiBaseUrl;
    }

    public String getKudosEndpoint() {
        return producerApiBaseUrl + API_V1 + "/kudos";
    }

    public String getKudosCountEndpoint() {
        return producerApiBaseUrl + API_V1 + "/kudos/count";
    }
}
