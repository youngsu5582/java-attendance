package crew;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public record EductionTime(
        LocalTime enterTime,
        LocalTime exitTime
) {
    public int diffEnterTime(final LocalTime time) {
        return (int) ChronoUnit.MINUTES.between(enterTime, time);
    }
}
