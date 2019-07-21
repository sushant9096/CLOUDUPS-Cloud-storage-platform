package sAuth;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

public class authRead {
     private String FILENAME;
     private String USERNAME;
     private String PASSWORD;

     public authRead(String filename) throws Exception{
         this.FILENAME=filename;

         JSONObject jsonObject = (JSONObject) readJsonSimpleDemo(FILENAME);
         USERNAME= (String) jsonObject.get("username");
         PASSWORD= (String) jsonObject.get("password");


     }

    public String getFILENAME() {
        return FILENAME;
    }

    public String getUSERNAME() {
        return USERNAME;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public static Object readJsonSimpleDemo(String filename) throws Exception {
        FileReader reader = new FileReader(filename);
        JSONParser jsonParser = new JSONParser();
        return jsonParser.parse(reader);
    }




}
