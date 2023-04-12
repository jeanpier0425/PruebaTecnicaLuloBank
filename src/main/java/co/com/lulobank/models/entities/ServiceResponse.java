package co.com.lulobank.models.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServiceResponse {

    private  String response;
    private  String status;
    private  String request;

    public static ServiceResponse objectService(){
        return new ServiceResponse();
    }
}