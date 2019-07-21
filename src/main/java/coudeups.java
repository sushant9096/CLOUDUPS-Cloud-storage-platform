
import sAuth.*;

import org.json.simple.*;
import org.json.simple.parser.JSONParser;



public class coudeups {
    private static String url = "https://api.androidhive.info/contacts/";


    public static void main(String[] args) {
        try {
            authRead read_obj = new authRead(Res.user_data_file);
            Res.user_username=read_obj.getUSERNAME();
            Res.user_password=read_obj.getPASSWORD();

            if(!Res.user_username.equals("")){
                new Home_page();
            }else {
                new Login_page();
            }

        }catch (Exception e){
            new Login_page();
        }





    }



    private void extanplejson(){
        // Making a request to url and getting response



        try {
            HttpHandler sh = new HttpHandler();
            String jsonStr = sh.makeServiceCall(url);
            JSONObject jsonObject = (JSONObject) new JSONParser().parse(jsonStr);
            System.out.println(" asdadasdsadasd   "+jsonObject.get("contacts").toString());
            JSONArray ar=(JSONArray) jsonObject.get("contacts");
             JSONObject c =(JSONObject) ar.get(1);
            System.out.println(" asdadasdsadasd   "+c.get("name").toString());



        }catch (Exception e){}



    }




}
