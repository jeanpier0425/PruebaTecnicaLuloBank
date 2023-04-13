package co.com.lulobank.tasks;

import co.com.lulobank.models.entities.ServiceResponse;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static co.com.lulobank.utils.constans.GeneralConstant.KEY_SERVICE;

public class WrongAppIdKey implements Task {

    private String typeErrorKey;

    public WrongAppIdKey(String typeErrorKey) {
        this.typeErrorKey = typeErrorKey;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Check.whether(typeErrorKey.equalsIgnoreCase("NOT_EXIST"))
                        .andIfSo(Get.resource("").with(specificRequest -> specificRequest.contentType(ContentType.JSON).header(KEY_SERVICE, "invalid_app-id987").log().all().relaxedHTTPSValidation()))
                        .otherwise(Get.resource("").with(specificRequest -> specificRequest.contentType(ContentType.JSON).log().all().relaxedHTTPSValidation()))
        );
        SerenityRest.lastResponse().prettyPrint();
        ServiceResponse.setResponse(SerenityRest.lastResponse().getBody().asString());
    }

    public static WrongAppIdKey onEndPoint(String typeErrorKey){
        return Tasks.instrumented(WrongAppIdKey.class,typeErrorKey);
    }


}
