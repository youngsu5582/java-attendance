import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static util.TimeUtil.createTime;

class OperationTimeTest {
    @Test
    @DisplayName("운영 시간이면 참을 반환한다.")
    void return_true_is_in_time() {
        final OperationTime operationTime = new OperationTime(createTime(10, 0), createTime(18, 0));
        final var result = operationTime.isInTime(createTime(10, 1));
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("운영 시간 이전이면 거짓을 반환한다.")
    void return_false_when_is_before_enter_time() {
        final OperationTime operationTime = new OperationTime(createTime(10, 0), createTime(18, 0));
        final var result = operationTime.isInTime(createTime(9, 59));
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("운영 시간 이후이면 거짓을 반환한다.")
    void return_false_when_is_after_exit_time() {
        final OperationTime operationTime = new OperationTime(createTime(10, 0), createTime(18, 0));
        final var result = operationTime.isInTime(createTime(18, 1));
        assertThat(result).isFalse();
    }
}
