package co.com.lulobank.models.entities;

public class ServiceResponse {

    private static String response;
    private static String status;
    private static String request;


    public static String getRequest() {
        return request;
    }

    public static void setRequest(String request) {
        ServiceResponse.request = request;
    }

    public static String getStatus() {
        return status;
    }

    public static void setStatus(String status) {
        ServiceResponse.status = status;
    }

    public static String getResponse() {
        return ServiceResponse.response;
    }

    public static void setResponse(String response) {
        ServiceResponse.response = response;
    }
}