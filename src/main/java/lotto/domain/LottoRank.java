package lotto.domain;

import java.util.Arrays;

public enum LottoRank {
    FIFTH(3, 5000),
    FOURTH(4, 50000),
    THIRD(5, 1500000),
    SECOND(5, 30000000),
    FIRST(6, 2000000000);

    private final int correctNumber;
    private final int prizeAmount;

    LottoRank(final int correctNumber, final int prizeAmount) {
        this.correctNumber = correctNumber;
        this.prizeAmount = prizeAmount;
    }

    public int getCorrectNumber() {
        return correctNumber;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }

    public static LottoRank valueOf(int sameCount, boolean bonus) {
        if (sameCount == 5) {
            return checkSecondOrThird(bonus);
        }
        return Arrays.stream(LottoRank.values())
                .filter(lottoRank -> lottoRank.getCorrectNumber() == sameCount)
                .findFirst()
                .orElse(null);
    }

    private static LottoRank checkSecondOrThird(boolean bonus) {
        if (bonus) {
            return SECOND;
        }
        return THIRD;
    }
}
