package co.com.lulobank.tasks;

import co.com.lulobank.models.entities.ServiceResponse;
import io.restassured.http.ContentType;
import lombok.SneakyThrows;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static co.com.lulobank.utils.constans.GeneralConstant.KEY_SERVICE;
import static co.com.lulobank.utils.properties.ServicesProperties.keyServiceValue;

public class PostRequest implements Task {

    private String requestConsume;

    public PostRequest(String requestConsume) {
        this.requestConsume = requestConsume;
    }

    @SneakyThrows
    @Override
    public <T extends Actor> void performAs(T actor) {

            actor.attemptsTo(
                    Post.to("").with(
                            request -> request.contentType(ContentType.JSON)
                                    .header(KEY_SERVICE, keyServiceValue)
                                    .body(requestConsume).log().all().relaxedHTTPSValidation()
                    )
            );
        SerenityRest.lastResponse().prettyPrint();
        ServiceResponse.objectService().setRequest(requestConsume);
        ServiceResponse.objectService().setResponse(SerenityRest.lastResponse().getBody().asString());
    }

    public static PostRequest onTheEndPoint(String requestConsume){
        return Tasks.instrumented(PostRequest.class,requestConsume);
    }

}
