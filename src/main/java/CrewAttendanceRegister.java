import crew.CrewNickname;

import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;

public record CrewAttendanceRegister(
        Map<CrewNickname, Attendances> crewAttendances
) {
    public boolean add(final CrewNickname crewNickname, final Attendance attendance) {
        final Attendances attendances = crewAttendances.getOrDefault(crewNickname, new Attendances(new ArrayList<>()));
        attendances.add(attendance);
        return Objects.equals(crewAttendances.put(crewNickname, attendances), attendances);
    }


}
