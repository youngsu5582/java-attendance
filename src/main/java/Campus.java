import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public record Campus(
        Operation operation,
        Education education
) {
    public List<LocalDate> ask(final AskDate askDate) {
        final var firstDate = askDate.firstDate();
        final var yesterdayTime = askDate.yesterday();
        return firstDate.datesUntil(yesterdayTime)
                .filter(date -> operation.isOperation(date) && education.isOperation(date))
                .collect(Collectors.toList());
    }
}
