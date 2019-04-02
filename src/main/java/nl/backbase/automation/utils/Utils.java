package nl.backbase.automation.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {

    public String getDateFormated(String date) throws ParseException {
        Date date1= new SimpleDateFormat("yyyy-MM-dd").parse(date);
        return (new SimpleDateFormat("dd MMM yyyy").format(date1)).toString();
    }
}
