package co.com.lulobank.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidateDeleteResponse implements Question<String> {
    @Override
    public String answeredBy(Actor actor) {
        return SerenityRest.lastResponse().getBody().path("id").toString();
    }

    public static ValidateDeleteResponse onEndPoint(){
        return new ValidateDeleteResponse();
    }

}
