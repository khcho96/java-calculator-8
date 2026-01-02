package calculator.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import calculator.constant.ErrorMessage;
import org.junit.jupiter.api.Test;

class NumberConvertorTest {

    @Test
    void 숫자_변환_성공() {
        Integer number = NumberConvertor.convertToNumber("3");
        assertThat(number).isEqualTo(3);
    }

    @Test
    void 숫자_변환_오류() {
        assertThatThrownBy(() -> NumberConvertor.convertToNumber("a"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(ErrorMessage.FORMAT_ERROR.getErrorMessage());
    }
}