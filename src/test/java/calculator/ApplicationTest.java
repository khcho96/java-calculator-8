package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import calculator.constant.ErrorMessage;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ApplicationTest extends NsTest {
    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @ParameterizedTest
    @MethodSource("successInputProvider")
    void 성공_케이스(String input, int expectedResult) {
        assertSimpleTest(() -> {
            run(input);
            assertThat(output()).contains("결과 : " + expectedResult);
        });
    }

    static Stream<Arguments> successInputProvider() {
        return Stream.of(
                Arguments.of("//;\\n1,2:3;4", 10),
                Arguments.of("//;\\n1234", 1234),
                Arguments.of("1,2,3", 6),
                Arguments.of("1,2:3", 6),
                Arguments.of("123", 123)
        );
    }

    @ParameterizedTest
    @MethodSource("failureInputProvider")
    void 실패_케이스(String input) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(input))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(ErrorMessage.FORMAT_ERROR.getErrorMessage())
        );
    }

    static Stream<Arguments> failureInputProvider() {
        return Stream.of(
                Arguments.of("//;\\na,b:c;d"),
                Arguments.of("//;\\nabcd"),
                Arguments.of("a,b,c"),
                Arguments.of("//;-\\n1-2:3;4"),
                Arguments.of("//;\\\\n1,2:3;4"),
                Arguments.of("//;\\n//-\\n1,2-3;4"),
                Arguments.of("//;\\n1,2\\3;4")
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

