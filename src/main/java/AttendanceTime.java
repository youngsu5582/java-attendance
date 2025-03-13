import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public record AttendanceTime(LocalDateTime time) {
    public static AttendanceTime from(final LocalDate date, final LocalTime time) {
        return new AttendanceTime(LocalDateTime.of(date, time));
    }

    public DayOfWeek getDayOfWeek() {
        return time.getDayOfWeek();
    }

    public LocalTime toLocalTime() {
        return time.toLocalTime();
    }
}
