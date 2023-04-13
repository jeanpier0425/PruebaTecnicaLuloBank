package co.com.lulobank.questions;

import co.com.lulobank.models.entities.ServiceResponse;
import co.com.lulobank.models.users.User;
import co.com.lulobank.utils.compare.CreateCompare;
import co.com.lulobank.utils.jsonUtils.JsonManage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidateUpdateResponse implements Question<Boolean> {

    private User requestCreated;
    private User createResponse;
    private String typeMethod;

    public ValidateUpdateResponse(String typeMethod) {
        this.typeMethod = typeMethod;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        try {
            requestCreated = JsonManage.jsonToModel(JsonManage.readJsonResponsePersonal(
                    ServiceResponse.getRequest()
                    , "RequestCreated"), User.class);

            createResponse = JsonManage.jsonToModel(JsonManage.readJsonResponsePersonal(
                    ServiceResponse.getResponse()
                    , "createResponse"),User.class);

        }catch (Exception e)
        {
            throw new RuntimeException(e);
        }
        return CreateCompare.CompareDataInResponse(requestCreated,createResponse,typeMethod);
    }

    public static ValidateUpdateResponse onService(String typeMethod){
        return new ValidateUpdateResponse(typeMethod);
    }
}
