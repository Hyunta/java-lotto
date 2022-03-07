package lotto.domain;

import static java.util.stream.Collectors.toList;
import static lotto.domain.LottoNumber.MAX_BOUND;
import static lotto.domain.LottoNumber.MIN_BOUND;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class LottoNumberGenerator {
    private static final List<Integer> numbers = IntStream.rangeClosed(MIN_BOUND, MAX_BOUND).boxed().collect(toList());
    private static final int CHOICE_NUMBER_SIZE = 6;

    private LottoNumberGenerator() {
    }

    public static List<List<Integer>> generateAutoNumbers(int autoCount) {
        return IntStream.range(0, autoCount)
                .mapToObj(i -> collectRandomNumbers())
                .collect(toList());
    }

    private static List<Integer> collectRandomNumbers() {
        Collections.shuffle(numbers);
        return numbers.stream()
                .limit(CHOICE_NUMBER_SIZE)
                .collect(toList());
    }
}
