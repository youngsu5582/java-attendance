import crew.EductionTime;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static util.TimeUtil.createTime;

class EducationTimeTableTest {

    @Test
    @DisplayName("5분 이하이면 출석으로 처리된다.")
    void present_case() {
        final EducationTimeTable educationTimeTable = new EducationTimeTable(
                Map.of(DayOfWeek.MONDAY, new EductionTime(createTime(13, 0), createTime(18, 0))));
        final AttendanceResult result = educationTimeTable.checkAttendance(DayOfWeek.MONDAY, createTime(13, 5));
        assertThat(result).isEqualTo(AttendanceResult.PRESENT);
    }

    @Test
    @DisplayName("5분을 초과하면 지각으로 처리된다.")
    void late_case_up_5() {
        final EducationTimeTable educationTimeTable = new EducationTimeTable(
                Map.of(DayOfWeek.MONDAY, new EductionTime(createTime(13, 0), createTime(18, 0))));
        final AttendanceResult result = educationTimeTable.checkAttendance(DayOfWeek.MONDAY, createTime(13, 6));
        assertThat(result).isEqualTo(AttendanceResult.LATE);
    }

    @Test
    @DisplayName("30분 이하이면 지각으로 처리된다.")
    void late_case_under_30() {
        final EducationTimeTable educationTimeTable = new EducationTimeTable(
                Map.of(DayOfWeek.MONDAY, new EductionTime(createTime(13, 0), createTime(18, 0))));
        final AttendanceResult result = educationTimeTable.checkAttendance(DayOfWeek.MONDAY, createTime(13, 30));
        assertThat(result).isEqualTo(AttendanceResult.LATE);
    }

    @Test
    @DisplayName("30분을 초과하면 결석으로 처리된다.")
    void absent_case_up_30() {
        final EducationTimeTable educationTimeTable = new EducationTimeTable(
                Map.of(DayOfWeek.MONDAY, new EductionTime(createTime(13, 0), createTime(18, 0))));
        final AttendanceResult result = educationTimeTable.checkAttendance(DayOfWeek.MONDAY, createTime(13, 31));
        assertThat(result).isEqualTo(AttendanceResult.ABSENT);
    }
}
