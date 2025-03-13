import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static util.TimeUtil.createDate;
import static util.TimeUtil.createTime;

class OperationTest {
    Operation operation = new Operation(
            new OperationTimeTable(
                    Map.of(
                            DayOfWeek.MONDAY, new OperationTime(createTime(10, 0), createTime(23, 0)),
                            DayOfWeek.FRIDAY, new OperationTime(createTime(10, 0), createTime(23, 0))
                    )
            ),
            Set.of(LocalDate.of(2025, 3, 13))
    );

    @Test
    void operation_case() {
        final var result = operation.isOperation(LocalDateTime.of(createDate(2025, 3, 14), createTime(10, 0)));
        assertThat(result).isTrue();
    }

    @Test
    void not_operation_case() {
        final var result = operation.isOperation(LocalDateTime.of(createDate(2025, 3, 13), createTime(10, 0)));
        assertThat(result).isFalse();
    }
}
