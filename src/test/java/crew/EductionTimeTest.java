package crew;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static util.TimeUtil.createTime;

class EductionTimeTest {
    @Test
    @DisplayName("몇분이 차이나는지 계산한다.")
    void calculate_diff_time() {
        final EductionTime eductionTime = new EductionTime(createTime(10, 0), createTime(18, 0));
        final int diffTime = eductionTime.diffEnterTime(createTime(10, 5));
        assertThat(diffTime).isEqualTo(5);
    }
}
