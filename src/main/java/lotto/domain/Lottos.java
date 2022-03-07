package lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<List<Integer>> inputNumbers) {
        this.lottos = createLottos(inputNumbers);
    }

    private List<Lotto> createLottos(List<List<Integer>> inputNumbers) {
        return inputNumbers.stream()
                .map(Lotto::new)
                .collect(Collectors.toList());
    }

    public LottoResult createLottoResult(WinningNumber winningNumber) {
        Map<LottoRank, Integer> RankMap = LottoRank.initLottoRankMap();
        lottos.stream()
                .map(winningNumber::findLottoRank)
                .forEach(lottoRank -> addRank(RankMap, lottoRank));
        return new LottoResult(RankMap);
    }

    private void addRank(Map<LottoRank, Integer> RankMap, LottoRank lottoRank) {
        RankMap.put(lottoRank, RankMap.get(lottoRank) + 1);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
