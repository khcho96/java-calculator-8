package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class DelimiterTest {

    @Test
    void 기본구분자로_문자열_파싱() {
        Delimiter delimiter = Delimiter.newInstance();

        List<String> result = delimiter.split("1,2:3").stream().toList();

        assertThat(result).containsExactly("1", "2", "3");
    }

    @Test
    void 커스텀구분자로_문자열_파싱() {
        Delimiter delimiter = Delimiter.newInstance();
        delimiter.addDelimiter(";");

        List<String> result = delimiter.split("1;2;3").stream().toList();

        assertThat(result).containsExactly("1", "2", "3");
    }

    @Test
    void 기본구분자_및_커스텀구분자로_문자열_파싱() {
        Delimiter delimiter = Delimiter.newInstance();
        delimiter.addDelimiter(";");

        List<String> result = delimiter.split("1,2:3;4").stream().toList();

        assertThat(result).containsExactly("1", "2", "3", "4");
    }
}