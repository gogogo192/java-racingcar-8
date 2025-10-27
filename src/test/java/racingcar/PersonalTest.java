package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PersonalTest extends NsTest {

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;


    @Test
    void 기능_테스트_우승자1명() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains(
                            "pobi : -",
                            "woni : ",
                            "최종 우승자 : pobi"
                    );
                },
                MOVING_FORWARD, STOP
        );
    }


    @Test
    void 기능_테스트_우승자2명() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("최종 우승자 : pobi, woni");
                },
                MOVING_FORWARD, MOVING_FORWARD
        );
    }
    @Test
    void 예외_테스트_자동차이름5자초과() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woniislong", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("자동차 이름은 1~5글자여야 합니다")
        );
    }

    @Test
    void 예외_테스트_자동차이름빈문자열() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,,woni", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("자동차 이름은 1~5글자여야 합니다")
        );
    }


    @Test
    void 예외_테스트_숫자이외입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "abc"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("숫자를 입력해야 합니다")
        );
    }


    @Test
    void 예외_테스트_0이하입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("1 이상이어야 합니다")
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}