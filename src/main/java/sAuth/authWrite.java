package sAuth;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.nio.file.Files;
import java.nio.file.Paths;

public class authWrite {

    public authWrite(String filename,String Username,String password) throws Exception {
        JSONObject sampleObject = new JSONObject();
        sampleObject.put("username", Username);
        sampleObject.put("password", password);

        Files.write(Paths.get(filename), sampleObject.toJSONString().getBytes());
    }
}
