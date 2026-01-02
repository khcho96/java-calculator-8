package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import calculator.constant.ErrorMessage;
import java.util.List;
import org.junit.jupiter.api.Test;

class NumbersTest {

    @Test
    void 숫자가_아닌_문자_오류() {
        assertThatThrownBy(() -> Numbers.from(List.of("a", "1", "2")))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(ErrorMessage.FORMAT_ERROR.getErrorMessage());
    }

    @Test
    void 합계_구하기() {
        Numbers numbers = Numbers.from(List.of("1", "2", "3", "4", "5"));
        int result = numbers.calculateSum();
        assertThat(result).isEqualTo(15);
    }
}