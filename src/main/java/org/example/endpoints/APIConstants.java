package org.example.endpoints;
import org.example.utils.PropertyReaderUtil;
public class APIConstants {

    // public static String BASE_URL  = UtilsExcel.fetchDataFromXLSX("Sheet1","BaseUrl","Value");

    public static String BASE_URL;
    public static String CREATE_UPDATE_BOOKING_URL;


    static {
        try {
            BASE_URL = PropertyReaderUtil.readKey("url");
            CREATE_UPDATE_BOOKING_URL = PropertyReaderUtil.readKey("CREATE_UPDATE_BOOKING_URL");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    //public static String BASE_URL  = "https://restful-booker.herokuapp.com";


    //public static String CREATE_UPDATE_BOOKING_URL  = "/booking";

}
