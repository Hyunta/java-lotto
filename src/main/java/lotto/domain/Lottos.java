package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Lottos {
    private static final int UNIT_AMOUNT = 1000;

    private Money money;
    private List<ChoiceNumber> lottos;
    private LottoResult result;

    public Lottos(Money money) {
        this.money = money;
        this.lottos = new ArrayList<>();
        this.result = new LottoResult();
        purchaseLotto();
    }

    private void purchaseLotto() {
        IntStream.range(0, getLottoCount(money))
                .forEach(i -> lottos.add((new ChoiceNumber())));
    }

    public double getYield() {
        return result.sumOfPrize() / money.getAmount();
    }


    private int getLottoCount(Money money) {
        return money.getAmount() / UNIT_AMOUNT;
    }

    public int getLottosSize() {
        return lottos.size();
    }

    public LottoResult getResult(WinningNumber winningNumber) {
        for (ChoiceNumber lotto : lottos) {
            LottoRank lottoRank = winningNumber.findLottoRank(lotto);
            if (lottoRank != null) {
                result.add(lottoRank);
            }
        }
        return result;
    }

    public List<ChoiceNumber> getLottos() {
        return lottos;
    }
}
