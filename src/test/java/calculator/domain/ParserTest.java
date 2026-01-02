package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class ParserTest {

    @Test
    void 기본구분자_문자열_파싱() {
        Parser parser = Parser.from("1,2:3");
        List<String> result = parser.parseTarget();
        assertThat(result).containsExactly("1", "2", "3");
    }

    @Test
    void 커스텀구분자_문자열_파싱() {
        Parser parser = Parser.from("//;\\n1,2:3;4");
        List<String> result = parser.parseTarget();
        assertThat(result).containsExactly("1", "2", "3", "4");
    }
}