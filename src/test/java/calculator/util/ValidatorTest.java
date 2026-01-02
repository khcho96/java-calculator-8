package calculator.util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import calculator.constant.ErrorMessage;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ValidatorTest {

    @ParameterizedTest
    @MethodSource("passInputProvider")
    void 검증_통과(String input) {
        Validator.validateInputFormat(input);
    }

    static Stream<Arguments> passInputProvider() {
        return Stream.of(
                Arguments.of("//;\\n1,2:3;4"),
                Arguments.of("//;\\n1234"),
                Arguments.of("//;\\na,b:c;d"),
                Arguments.of("//;\\nabcd"),
                Arguments.of("1,2,3"),
                Arguments.of("1,2:3"),
                Arguments.of("123"),
                Arguments.of("a,b,c")
        );
    }

    @ParameterizedTest
    @MethodSource("failInputProvider")
    void 검증_예외_발생(String input) {
        assertThatThrownBy(() -> Validator.validateInputFormat(input))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(ErrorMessage.FORMAT_ERROR.getErrorMessage());
    }

    static Stream<Arguments> failInputProvider() {
        return Stream.of(
                Arguments.of("//;-\\n1-2:3;4"),
                Arguments.of("//;\\\\n1,2:3;4"),
                Arguments.of("//;\\n//-\\n1,2-3;4"),
                Arguments.of("//;\\n1,2\\3;4")
        );
    }
}