package co.com.lulobank.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidateTheStatus implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return String.valueOf(SerenityRest.lastResponse().getStatusCode());
    }

    public static ValidateTheStatus code(){
        return new ValidateTheStatus();
    }
}
