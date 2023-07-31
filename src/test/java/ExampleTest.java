import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ExampleTest {

    @Test
    void test() {
        String hello = "Hello World";

        assertThat(hello).isEqualTo("Hello World");
    }
}
