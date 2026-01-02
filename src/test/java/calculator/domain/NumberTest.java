package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import calculator.constant.ErrorMessage;
import org.junit.jupiter.api.Test;

class NumberTest {

    @Test
    void 숫자_아닌_오류() {
        assertThatThrownBy(() -> Number.from("a"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(ErrorMessage.FORMAT_ERROR.getErrorMessage());
    }

    @Test
    void 숫자_정상_저장() {
        Number.from("1");
    }

    @Test
    void 더하기() {
        Number number = Number.from("1");
        int result = number.addNumber(2);
        assertThat(result).isEqualTo(3);
    }
}