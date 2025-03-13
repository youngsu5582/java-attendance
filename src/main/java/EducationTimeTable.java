import crew.EductionTime;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Map;

public record EducationTimeTable(Map<DayOfWeek, EductionTime> map) {
    private static final int LATE_MINUTE = 5;
    private static final int PRESENT_MINUTE = 30;

    public AttendanceResult checkAttendance(final DayOfWeek dayOfWeek, final LocalTime time) {
        final EductionTime eductionTime = getClassTime(dayOfWeek);
        final int diffTime = eductionTime.diffEnterTime(time);

        if (diffTime <= LATE_MINUTE) {
            return AttendanceResult.PRESENT;
        } else if (diffTime <= PRESENT_MINUTE) {
            return AttendanceResult.LATE;
        } else {
            return AttendanceResult.ABSENT;
        }
    }

    public boolean isOperation(final DayOfWeek dayOfWeek) {
        return map.containsKey(dayOfWeek);
    }

    private EductionTime getClassTime(final DayOfWeek dayOfWeek) {
        final EductionTime eductionTime = map.get(dayOfWeek);
        if (eductionTime == null) {
            throw new IllegalArgumentException("오늘은 교육하는 날이 아닙니다.");
        }
        return eductionTime;
    }
}
