package lotto.step2;

import lotto.step2.domain.Lotto;
import lotto.step2.domain.Lottos;
import lotto.step2.domain.WinningNumbers;
import lotto.step2.domain.WinningStatistics;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningStatisticsTest {

    @ParameterizedTest(name = "profitsTest")
    @MethodSource("arrayProvider")
    public void profitsTest(Lottos inputLottos, WinningNumbers winningNumbers, double expected) {
        WinningStatistics statistics = new WinningStatistics(inputLottos, winningNumbers);
        assertThat(statistics.profits()).isEqualTo(expected);
    }

    static Stream<Arguments> arrayProvider() {

        return Stream.of(
                Arguments.of(new Lottos(new ArrayList<Lotto>() {
                            {
                                add(new Lotto(new String[]{"1", "2", "3", "4", "5", "7"}));
                                add(new Lotto(new String[]{"1", "2", "3", "4", "7", "8"}));
                                add(new Lotto(new String[]{"1", "2", "3", "4", "7", "8"}));
                                add(new Lotto(new String[]{"1", "2", "3", "4", "5", "45"}));
                            }
                        }
                        )
                        , new WinningNumbers(new String[]{"1", "2", "3", "4", "5", "6"}, 45), 7900)
        );
    }
}
