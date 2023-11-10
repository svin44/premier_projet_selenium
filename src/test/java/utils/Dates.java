package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Dates {

    public static String getToday(){
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String currentDate = formatter.format((date));
        return currentDate;
    }
}
