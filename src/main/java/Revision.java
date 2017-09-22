import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.TimeZone;

public class Revision {

    public ZonedDateTime timestamp;
    public String utcTime;

    public Revision(String utcTime) {
        timestamp = changeTimeZone(utcTime);
        this.timestamp = timestamp;
    }

    public ZonedDateTime changeTimeZone(String utcTime) {
        this.utcTime = utcTime;
        Instant instantTime = Instant.parse(utcTime);
        ZonedDateTime localTimeStamp = instantTime.atZone(ZoneId.of("UTC-5"));
        return localTimeStamp;
    }

    public String getUtcTime(){
        return this.utcTime;
    }

    public ZonedDateTime getTimestamp() {
        return this.timestamp;
    }
}