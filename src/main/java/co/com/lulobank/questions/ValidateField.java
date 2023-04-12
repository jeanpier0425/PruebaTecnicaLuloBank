package co.com.lulobank.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidateField implements Question<Boolean> {

   private String field;

    public ValidateField(String field) {
        this.field = field;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return SerenityRest.lastResponse().getBody().asString().contains(field);
    }

    public static ValidateField andTheResponse(String field){
        return new ValidateField(field);
    }
}
