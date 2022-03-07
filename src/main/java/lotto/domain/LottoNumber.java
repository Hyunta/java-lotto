package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.IntStream;

public class LottoNumber implements Comparable<LottoNumber> {
    public static final int MIN_BOUND = 1;
    public static final int MAX_BOUND = 45;

    private static final Map<Integer, LottoNumber> LOTTO_NUMBER_CACHE;

    private final int number;

    static {
        LOTTO_NUMBER_CACHE = new HashMap<>();
        IntStream.range(MIN_BOUND, MAX_BOUND)
                .forEach(number -> LOTTO_NUMBER_CACHE.put(number, new LottoNumber(number)));
    }

    public LottoNumber(int number) {
        checkRange(number);
        this.number = number;
    }

    public static LottoNumber valueOf(int number) {
        checkRange(number);
        return LOTTO_NUMBER_CACHE.get(number);
    }

    private static void checkRange(int number) {
        if (MIN_BOUND > number || MAX_BOUND < number) {
            throw new IllegalArgumentException("[ERROR] 1부터 45까지의 번호로 입력해주세요.");
        }
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public int compareTo(LottoNumber o) {
        return Integer.compare(this.number, o.number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
