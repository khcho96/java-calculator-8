package calculator.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import calculator.constant.ErrorMessage;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CalculatorServiceTest {

    private final CalculatorService calculatorService = new CalculatorService();

    @ParameterizedTest
    @MethodSource("SuccessInputProvider")
    void 결과값_반환_성공(String input, int expectedResult) {
        int result = calculatorService.calculate(input);
        assertThat(result).isEqualTo(expectedResult);
    }

    static Stream<Arguments> SuccessInputProvider() {
        return Stream.of(
                Arguments.of("//;\\n1,2:3;4", 10),
                Arguments.of("//;\\n1234", 1234),
                Arguments.of("1,2,3", 6),
                Arguments.of("1,2:3", 6),
                Arguments.of("123", 123)
        );
    }

    @ParameterizedTest
    @MethodSource("FailureInputProvider")
    void 결과값_반환_실패(String input) {
        assertThatThrownBy(() -> calculatorService.calculate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.FORMAT_ERROR.getErrorMessage());
    }

    static Stream<Arguments> FailureInputProvider() {
        return Stream.of(
                Arguments.of("//;\\na,b:c;d"),
                Arguments.of("//;\\nabcd"),
                Arguments.of("a,b,c")
        );
    }
}