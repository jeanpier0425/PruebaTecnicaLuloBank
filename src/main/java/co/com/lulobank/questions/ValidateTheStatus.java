package co.com.lulobank.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidateTheStatus implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        System.out.println("the status code is: "+String.valueOf(SerenityRest.lastResponse().getStatusCode()));
        return String.valueOf(SerenityRest.lastResponse().getStatusCode());
    }

    public static ValidateTheStatus code(){
        return new ValidateTheStatus();
    }
}
