package co.com.lulobank.utils.compare;

import co.com.lulobank.models.users.User;

public class UsersCompare {

    public static boolean compareUser(User user1, User user2){
        return  user1.getId().equalsIgnoreCase(user2.getId()) &&
                user1.getFirstName().equalsIgnoreCase(user2.getFirstName()) &&
                user1.getLastName().equalsIgnoreCase(user2.getLastName()) &&
                user1.getEmail().equalsIgnoreCase(user2.getEmail()) &&
                user1.getRegisterDate().equalsIgnoreCase(user2.getRegisterDate()) &&
                user1.getUpdatedDate().equalsIgnoreCase(user2.getUpdatedDate());
    }
}