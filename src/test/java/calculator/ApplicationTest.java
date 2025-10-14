package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

    @Test
    void 기본_구분자_사용() {
        assertSimpleTest(() -> {
            run("1,2:3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 기본_구분자_사용_및_양쪽_공백_존재() {
        assertSimpleTest(() -> {
            run("  1,2:3    \n\t");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 기본_구분자_사용_및_사이에_공백_존재() {
        assertSimpleTest(() -> {
            run("1,2  :  3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_구분자_1개_세미콜론_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1;2,3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_구분자_1개_공백_사용() {
        assertSimpleTest(() -> {
            run("// \\n1 2 3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_구분자_1개_숫자_사용() {
        assertSimpleTest(() -> {
            run("//5\\n15253");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_구분자_여러개_세미콜론_느낌표_사용() {
        assertSimpleTest(() -> {
            run("//;!\\n1;2!3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_구분자_여러개_공백_숫자_사용() {
        assertSimpleTest(() -> {
            run("// 5\\n1 253");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_구분자_여러개_숫자만_사용() {
        assertSimpleTest(() -> {
            run("//567\\n1526374");
            assertThat(output()).contains("결과 : 10");
        });
    }

    @Test
    void 구분자_여러개_연속_입력() {
        assertSimpleTest(() -> {
            run("1,,2,3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 구분자_양쪽_입력() {
        assertSimpleTest(() -> {
            run(",1,2,3,");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 공백만_입력1() {
        assertSimpleTest(() -> {
            run("");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 공백만_입력2() {
        assertSimpleTest(() -> {
            run("  ");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 정수_오버플로우_미발생() {
        assertSimpleTest(() -> {
            run("2147483647,2147483647");
            assertThat(output()).contains("결과 : 4294967294");
        });
    }

    @Test
    void 숫자만_입력() {
        assertSimpleTest(() -> {
            run("123");
            assertThat(output()).contains("결과 : 123");
        });
    }

    @Test
    void 커스텀_구분자_0개이하_공백_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//\\n123"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 숫자_0_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,0,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 숫자_0만_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 음수_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 음수만_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자_형식_오류1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(";//;\\n1;2;3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
