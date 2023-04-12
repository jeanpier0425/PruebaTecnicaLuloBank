package co.com.lulobank.utils.jsonUtils;

import co.com.lulobank.utils.properties.ServicesProperties;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.*;
import java.util.List;

import static co.com.lulobank.utils.constans.GeneralConstant.ARCHIVO_JSON_FORMAT;


public class JsonManage {


    private  static ObjectMapper mapper = new ObjectMapper();

    public static File readJsonResponsePersonal(String jsonString, String stringJsonName) throws IOException {
        createFileJsonResponsePersonalName(jsonString,stringJsonName);
        return new File(String.format(ServicesProperties.getJsonResponseDefaultPath(),System.getProperty("user.dir")) +
                String.format(ARCHIVO_JSON_FORMAT,stringJsonName));
    }

    public static void createFileJsonResponsePersonalName(String stringJson, String stringJsonName) {
        FileWriter flwriter = null;
        try {
            flwriter = new FileWriter(String.format(ServicesProperties.getJsonResponseDefaultPath(),System.getProperty("user.dir")) +
                    String.format(ARCHIVO_JSON_FORMAT,stringJsonName));
            BufferedWriter bfwriter = new BufferedWriter(flwriter);
            bfwriter.write(stringJson);
            bfwriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (flwriter != null) {
                try {
                    flwriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static <T> T jsonToModel(File file,Class<T> model) {

        T jsonData = null;
        try {
            jsonData = mapper.readValue(file, model);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonData;
    }
}
