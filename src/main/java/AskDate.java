import java.time.LocalDate;

public record AskDate(
        LocalDate date
) {
    public LocalDate yesterday() {
        return date.minusDays(1);
    }

    public LocalDate firstDate() {
        return date.withDayOfMonth(1);
    }
}
