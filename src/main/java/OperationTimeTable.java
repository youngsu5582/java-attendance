import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Map;

public record OperationTimeTable(Map<DayOfWeek, OperationTime> map) {
    public boolean checkTime(final DayOfWeek dayOfWeek, final LocalTime time) {
        if (map.containsKey(dayOfWeek)) {
            final OperationTime operationTime = map.get(dayOfWeek);
            return operationTime.isInTime(time);
        }
        return false;
    }

    public boolean isOperation(final DayOfWeek dayOfWeek) {
        return map.containsKey(dayOfWeek);
    }
}
