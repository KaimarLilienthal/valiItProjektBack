package tallinnafotostuudiod.ee.valiItProjektBack.util;

public class TimeUtil {

    public static Integer timeStringToInteger(String timeString){
        String[] splitArray = timeString.split(":");
        String hourAsString = splitArray[0];
        int hourAsInteger = Integer.parseInt(hourAsString);
        return hourAsInteger;
    }
    public static String IntegerTotimeString(Integer hour){
        return String.format("%02d:00", hour);
    }

}
