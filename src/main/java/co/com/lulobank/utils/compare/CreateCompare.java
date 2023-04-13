package co.com.lulobank.utils.compare;

import co.com.lulobank.models.users.User;

public class CreateCompare {

    public static boolean compareData(User dataRequired, User dataobtained, String typeMethod) {

        boolean serviceValidation = dataRequired.getFirstName().equalsIgnoreCase(dataobtained.getFirstName()) &&
                dataRequired.getLastName().equalsIgnoreCase(dataobtained.getLastName());

        if (typeMethod.equalsIgnoreCase("post")) {
            serviceValidation = serviceValidation && dataRequired.getEmail().equalsIgnoreCase(dataobtained.getEmail());
        }
        return  serviceValidation;
    }

    public static boolean CompareDataInResponse(User dataRequired, User dataobtained,String typeMethod) {
        return compareData(dataobtained, dataRequired, typeMethod);
    }
}