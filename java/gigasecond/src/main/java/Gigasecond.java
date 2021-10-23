import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Gigasecond {

    private LocalDateTime localDateTime;
    private static final long GIGA_SECOND = BigInteger.valueOf(10).pow(9).longValue();

    public Gigasecond(LocalDate moment) {
        this.localDateTime = moment.atStartOfDay();
    }

    public Gigasecond(LocalDateTime moment) {
        localDateTime = moment;
    }

    public LocalDateTime getDateTime() {
        return localDateTime.plusSeconds(GIGA_SECOND);
    }
}
