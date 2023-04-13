package co.com.lulobank.tasks;

import co.com.lulobank.models.entities.ServiceResponse;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Put;

import static co.com.lulobank.utils.constans.GeneralConstant.KEY_SERVICE;
import static co.com.lulobank.utils.properties.ServicesProperties.keyServiceValue;

public class PutRequest implements Task {

    private String requestConsume;

    public PutRequest(String requestConsume) {
        this.requestConsume = requestConsume;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Put.to("").with(
                        request -> request.contentType(ContentType.JSON)
                                .header(KEY_SERVICE, keyServiceValue)
                                .body(requestConsume).log().all().relaxedHTTPSValidation()
                )
        );
        SerenityRest.lastResponse().prettyPrint();
        ServiceResponse.setRequest(requestConsume);
        ServiceResponse.setResponse(SerenityRest.lastResponse().getBody().asString());
    }

    public static PutRequest onEndPoint(String requestConsume){
        return Tasks.instrumented(PutRequest.class,requestConsume);
    }
}