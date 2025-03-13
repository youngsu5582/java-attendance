import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

public record Operation(
        OperationTimeTable operationTimeTable,
        Set<LocalDate> notOperationDates
) {
    public boolean isOperation(final LocalDateTime localDateTime) {
        return checkTime(localDateTime) && checkOperationDate(localDateTime.toLocalDate());
    }

    public boolean isOperation(final LocalDate localDate) {
        return operationTimeTable.isOperation(localDate.getDayOfWeek()) && checkOperationDate(localDate);
    }

    private boolean checkTime(final LocalDateTime localDateTime) {
        return operationTimeTable.checkTime(localDateTime.getDayOfWeek(), localDateTime.toLocalTime());
    }

    private boolean checkOperationDate(final LocalDate localDate) {
        return !notOperationDates.contains(localDate);
    }
}
