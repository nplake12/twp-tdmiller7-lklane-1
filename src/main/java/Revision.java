import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.TimeZone;

public class Revision {

    public String timestamp;
    public String utcTime;

    public Revision(String utcTime) {
        timestamp = changeTimeZone(utcTime);
        this.timestamp = timestamp;
    }

    private String changeTimeZone(String utcTime) {
        Instant timestamp = Instant.parse(utcTime);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        ZonedDateTime estZonedDate = timestamp.atZone(ZoneId.of("America/New_York"));
        return estZonedDate.format(formatter);
    }


    public String getUtcTime(){
        return this.utcTime;
    }

    public String getTimestamp() {
        return this.timestamp;
    }
}