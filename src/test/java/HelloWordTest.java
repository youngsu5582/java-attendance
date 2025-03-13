import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloWordTest {
    @Test
    void some(){
        final String str = "HelloWorld!";
        assertThat(str).isEqualTo("HelloWorld!");
    }

}
