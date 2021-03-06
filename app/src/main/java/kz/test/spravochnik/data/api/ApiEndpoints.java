package kz.test.spravochnik.data.api;

public enum ApiEndpoints {

    PRODUCTION("Production", ApiModule.PRODUCTION_API_URL),
    STAGING("Staging", "http://data.egov.kz"),
    MOCK_MODE("Mock Mode", "mock://"),
    CUSTOM("Custom", null);
    
    public final String name;
    public final String url;

    ApiEndpoints(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String toString() {
        return this.name;
    }

    public static ApiEndpoints from(String endpoint) {
        for (ApiEndpoints value : values()) {
            if (value.url != null && value.url.equals(endpoint)) {
                return value;
            }
        }
        return CUSTOM;
    }

    public static boolean isMockMode(String endpoint) {
        return from(endpoint) == MOCK_MODE;
    }
}
