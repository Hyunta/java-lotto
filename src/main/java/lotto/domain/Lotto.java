package lotto.domain;

import static java.util.stream.Collectors.toList;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private static final int CHOICE_NUMBER_SIZE = 6;

    private final List<LottoNumber> lotto;

    public Lotto(List<Integer> inputValues) {
        List<LottoNumber> lottoNumbers = inputValues.stream()
                .map(inputValue -> new LottoNumber(inputValue))
                .collect(toList());
        checkSize(lottoNumbers);
        checkDuplicateNumbers(lottoNumbers);
        this.lotto = lottoNumbers;
    }

    private void checkSize(List<LottoNumber> inputValues) {
        if (inputValues.size() != CHOICE_NUMBER_SIZE) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자를 입력해주세요");
        }
    }

    private void checkDuplicateNumbers(List<LottoNumber> inputValues) {
        HashSet<LottoNumber> lottoSet = new HashSet<>(inputValues);
        if (lottoSet.size() != inputValues.size()) {
            throw new IllegalArgumentException("[ERROR] 선택한 번호중에 중복되는 값이 있습니다.");
        }
    }

    public int countSameNumber(Lotto numbers) {
        return (int) lotto.stream()
                .filter(numbers.getLotto()::contains)
                .count();
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lotto.contains(lottoNumber);
    }

    public List<LottoNumber> getLotto() {
        return lotto;
    }

    @Override
    public String toString() {
        return lotto.toString();
    }
}
