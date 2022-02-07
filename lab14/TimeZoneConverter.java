import java.time.ZoneId;
import java.time.ZonedDateTime;

public class TimeZoneConverter {
    public ZonedDateTime convert(ZonedDateTime zdt, ZoneId zi) {
        return zdt.withZoneSameInstant(zi);
    }   
}
