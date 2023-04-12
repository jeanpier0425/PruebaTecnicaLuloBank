package co.com.lulobank.utils.maps;

import co.com.lulobank.models.users.User;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

public class MapsFormat {
    private static ObjectMapper mapper = new ObjectMapper();

    public static User userToModel(Map<String,String> map){
        return mapper.convertValue(map, User.class);
    }

}
