import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static util.TimeUtil.createTime;

class OperationTimeTableTest {
    @Test
    @DisplayName("운영을 하는 시간대면 참을 반환한다.")
    void operation_case() {
        final OperationTimeTable operationTimeTable = new OperationTimeTable(
                Map.of(DayOfWeek.MONDAY, new OperationTime(createTime(10, 0), createTime(23, 0))));
        final boolean result = operationTimeTable.checkTime(DayOfWeek.MONDAY, createTime(10, 0));
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("운영 하는 시간대가 아니면 거짓을 반환한다.")
    void not_operation_case_not_in_time() {
        final OperationTimeTable operationTimeTable = new OperationTimeTable(
                Map.of(DayOfWeek.MONDAY, new OperationTime(createTime(13, 0), createTime(18, 0))));
        final boolean result = operationTimeTable.checkTime(DayOfWeek.MONDAY, createTime(18, 1));
        assertThat(result).isFalse();
    }
    @Test
    @DisplayName("운영 하는 요일이 아니면 거짓을 반환한다.")
    void not_operation_case_not_in_day_of_week(){
        final OperationTimeTable operationTimeTable = new OperationTimeTable(
                Map.of(DayOfWeek.MONDAY, new OperationTime(createTime(13, 0), createTime(18, 0))));
        final boolean result = operationTimeTable.checkTime(DayOfWeek.TUESDAY, createTime(13,1));
        assertThat(result).isFalse();
    }
}
