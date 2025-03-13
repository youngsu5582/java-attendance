import java.time.LocalTime;

public record OperationTime(
        LocalTime enterTime,
        LocalTime exitTime
) {
    public boolean isInTime(final LocalTime time) {
        if(time.equals(enterTime) || time.equals(exitTime)){
            return true;
        }
        return enterTime.isBefore(time) && exitTime.isAfter(time);
    }
}
