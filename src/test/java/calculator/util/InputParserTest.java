package calculator.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class InputParserTest {

    @Test
    void 입력값_파싱() {
        String input = InputParser.parseInput("  1,2,3  ");
        assertThat(input).isEqualTo("1,2,3");
    }
}