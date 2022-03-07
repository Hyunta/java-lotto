package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumberGeneratorTest {
    @Test
    @DisplayName("랜덤으로 생성할 때 숫자 6개를 만들어내는가")
    void Generate_6_Number() {
        List<List<Integer>> randomNumbers = LottoNumberGenerator.generateAutoNumbers(1);
        assertThat(randomNumbers.get(0).size()).isEqualTo(6);
    }

    @Test
    @DisplayName("랜덤으로 생성한 모든 숫자가 1~45 사이에 위치하는가")
    void Is_Between_1_To_45() {
        List<List<Integer>> randomNumbers = LottoNumberGenerator.generateAutoNumbers(1);
        List<Integer> lotto = randomNumbers.get(0);
        assertThat(lotto.stream()
                .allMatch(i -> i >= 1 && i <= 45)).isTrue();
    }

}
