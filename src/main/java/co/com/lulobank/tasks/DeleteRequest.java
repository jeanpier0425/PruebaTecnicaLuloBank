package co.com.lulobank.tasks;

import co.com.lulobank.models.entities.ServiceResponse;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Delete;

import static co.com.lulobank.utils.constans.GeneralConstant.KEY_SERVICE;
import static co.com.lulobank.utils.properties.ServicesProperties.keyServiceValue;

public class DeleteRequest implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Delete.from("").with(
                request -> request.contentType(ContentType.JSON)
                        .header(KEY_SERVICE, keyServiceValue)
                        .log().all().relaxedHTTPSValidation()
                )
        );
        SerenityRest.lastResponse().prettyPrint();
        ServiceResponse.setResponse(SerenityRest.lastResponse().getBody().asString());
    }

    public static DeleteRequest onEndPoint(){
        return Tasks.instrumented(DeleteRequest.class);
    }


}
