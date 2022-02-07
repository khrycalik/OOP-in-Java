import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class ResultPrinter {
    // 2022-01-27 13:00:00 (Europe/Paris) => 2022-01-27 09:00:00 (America/Argentina/Buenos_Aires)


    void print(ZonedDateTime toconvert, ZonedDateTime converted) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.printf("%s %s => %s %s\n", toconvert.format(formatter),toconvert.getZone() , converted.format(formatter), converted.getZone());
    } 
}
