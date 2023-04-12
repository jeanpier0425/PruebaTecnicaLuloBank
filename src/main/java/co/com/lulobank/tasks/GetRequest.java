package co.com.lulobank.tasks;

import co.com.lulobank.models.entities.ServiceResponse;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static co.com.lulobank.utils.constans.GeneralConstant.KEY_SERVICE;
import static co.com.lulobank.utils.properties.ServicesProperties.keyServiceValue;

public class GetRequest implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Get.resource("")
                .with(specificRequest
                        -> specificRequest.contentType(ContentType.JSON)
                        .header(KEY_SERVICE, keyServiceValue)
                        .log().all().relaxedHTTPSValidation()
                )
        );
        SerenityRest.lastResponse().prettyPrint();
        ServiceResponse.objectService().setResponse(SerenityRest.lastResponse().getBody().asString());
    }
    public static GetRequest service(){
        return Tasks.instrumented(GetRequest.class);
    }

}
