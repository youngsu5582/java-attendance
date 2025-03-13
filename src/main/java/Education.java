import java.time.LocalDate;

public record Education(
        EducationTimeTable educationTimeTable
) {
    public boolean isOperation(final LocalDate localDate) {
        return educationTimeTable.isOperation(localDate.getDayOfWeek());
    }
}
