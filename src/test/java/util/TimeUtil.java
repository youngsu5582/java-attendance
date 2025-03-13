package util;

import java.time.LocalDate;
import java.time.LocalTime;

public class TimeUtil {
    public static LocalTime createTime(final int hour, final int minute) {
        return LocalTime.of(hour, minute);
    }

    public static LocalDate createDate(final int year, final int month, final int day) {
        return LocalDate.of(year, month, day);
    }
}
