package co.com.lulobank.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidateErrorMessage implements Question<String> {
    @Override
    public String answeredBy(Actor actor) {
        return SerenityRest.lastResponse().getBody().path("error").toString();
    }

    public static ValidateErrorMessage onService(){
        return new ValidateErrorMessage();
    }
}