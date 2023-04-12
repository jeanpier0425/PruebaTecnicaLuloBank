package co.com.lulobank.utils.compare;

import co.com.lulobank.models.entities.CreateResponse;
import co.com.lulobank.models.users.User;

public class CreateCompare {

    public static boolean compareData(User dataRequired, User dataobtained, String typeMethod) {

        boolean serviceValidation = dataRequired.getFirstName().equalsIgnoreCase(dataobtained.getFirstName()) &&
                dataRequired.getLastName().equalsIgnoreCase(dataobtained.getLastName());

        if (typeMethod.equalsIgnoreCase("put")) {
            serviceValidation = serviceValidation && dataRequired.getEmail().equalsIgnoreCase(dataobtained.getEmail());
        }
        return  serviceValidation;
    }

    public static boolean CompareDataInResponse(User dataRequired, CreateResponse dataobtained,String typeMethod) {
        return compareData(dataobtained.getUser(), dataRequired, typeMethod);
    }
}