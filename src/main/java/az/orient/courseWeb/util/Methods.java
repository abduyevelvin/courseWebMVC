package az.orient.courseWeb.util;

import java.util.Random;

public class Methods {

    public static final String generateUniqueNumber(){
        String res = null;
        Random r = new Random();
        res = String.valueOf(r.nextInt(9999999));

        return res;
    }
}
