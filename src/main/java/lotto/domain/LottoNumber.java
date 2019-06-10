package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    private static final List<LottoNumber> numbers = new ArrayList<>();
    private final int number;

    static {
        for (int i = MIN_LOTTO_NUMBER; i <= MAX_LOTTO_NUMBER; i++) {
            numbers.add(new LottoNumber(i));
        }
    }

    private LottoNumber(int lottoNumber) {
        this.number = lottoNumber;
    }

    public static LottoNumber valueOf(int lottoNumber) {
        if (lottoNumber < MIN_LOTTO_NUMBER || lottoNumber > MAX_LOTTO_NUMBER) {
            throw new InvalidLottoNumberException(String.format("로또 번호는 %d 이상 %d 이하여야 합니다.",
                    MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER));
        }
        return numbers.get(lottoNumber - 1);
    }

    public int getNumber() {
        return number;
    }

    public static int getMaxLottoNumber() {
        return MAX_LOTTO_NUMBER;
    }

    public static int getMinLottoNumber() {
        return MIN_LOTTO_NUMBER;
    }

    @Override
    public int compareTo(LottoNumber another) {
        return Integer.compare(number, another.number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return "LottoNumber{" +
                "number=" + number +
                '}';
    }
}
