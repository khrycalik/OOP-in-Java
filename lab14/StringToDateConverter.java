import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class StringToDateConverter {
    public ZonedDateTime convert(String s) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z");
        ZonedDateTime z = ZonedDateTime.parse(s, formatter);
        return z;
    } 
}
