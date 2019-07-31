
import sAuth.*;

import org.json.simple.*;
import org.json.simple.parser.JSONParser;



public class coudeups {



    public static void main(String[] args) {
        extanplejson();
        try {
            authRead read_obj = new authRead(Res.user_data_file);
            Res.user_username=read_obj.getUSERNAME();
            Res.user_password=read_obj.getPASSWORD();
            read_obj=null;

            if(!Res.user_username.equals("")){
                new Home_page();
            }else {
                new Login_page();
            }

        }catch (Exception e){
            new Login_page();
        }





    }



    public static void extanplejson(){
        // Making a request to url and getting response



        try {
            HttpHandler sh = new HttpHandler();
            String jsonStr = sh.makeServiceCall("http://localhost/cloudeups/getdata.php?u=asd");
            JSONObject jsonObject = (JSONObject) new JSONParser().parse(jsonStr);
            //System.out.println(" asdadasdsadasd   "+((JSONObject) jsonObject.get("0") ).get("filename") );
            //JSONArray ar=(JSONArray) jsonObject.get("1");
            // JSONObject c =(JSONObject) ar.get(1);
            //System.out.println(" asdadasdsadasd   "+c.get("id").toString());



        }catch (Exception e){
            System.out.println(" errorrr  ");

        }



    }




}
