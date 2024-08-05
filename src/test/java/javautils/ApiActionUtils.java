package javautils;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ApiActionUtils {
    // Send a GET request
    public static Response sendGetRequest(String endpoint) {
        return RestAssured.get(endpoint);
    }

    // Send a POST request
    public static Response sendPostRequest(String endpoint, String body) {
        return RestAssured.given()
                .contentType("application/json")
                .body(body)
                .post(endpoint);
    }

    // Send a PUT request
    public static Response sendPutRequest(String endpoint, String body) {
        return RestAssured.given()
                .contentType("application/json")
                .body(body)
                .put(endpoint);
    }

    // Send a DELETE request
    public static Response sendDeleteRequest(String endpoint) {
        return RestAssured.delete(endpoint);
    }

    // Extract value from JSON response
    public static String extractValueFromResponse(Response response, String jsonPath) {
        return response.jsonPath().getString(jsonPath);
    }

    // Validate response status code
    public static boolean validateStatusCode(Response response, int expectedStatusCode) {
        return response.getStatusCode() == expectedStatusCode;
    }
}
