import java.util.List;

public record Attendances(List<Attendance> attendances) {
    public boolean add(final Attendance attendance) {
        return attendances.add(attendance);
    }
}
