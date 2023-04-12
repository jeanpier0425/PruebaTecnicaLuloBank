package co.com.lulobank.questions;

import co.com.lulobank.models.entities.ServiceResponse;
import co.com.lulobank.models.users.GetUserModel;
import co.com.lulobank.models.users.User;
import co.com.lulobank.utils.compare.UsersCompare;
import co.com.lulobank.utils.jsonUtils.JsonManage;
import co.com.lulobank.utils.maps.MapsFormat;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ValidateUser implements Question<Boolean> {

    private GetUserModel userServiceResponse;
    private User userTestRequired;

    public ValidateUser(List<Map<String,String>> users) {
        this.userTestRequired = MapsFormat.userToModel(users.get(0));
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        try {
            userServiceResponse = JsonManage.jsonToModel(JsonManage.readJsonResponsePersonal(
                    ServiceResponse.objectService().getResponse(), "User"),GetUserModel.class);
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
        return UsersCompare.compareUser(userServiceResponse.getDataUser(),userTestRequired);
    }

    public static ValidateUser with (List<Map<String,String>> users){
        return new ValidateUser(users);
    }

}
