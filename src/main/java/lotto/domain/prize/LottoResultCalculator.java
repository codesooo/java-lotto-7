package lotto.domain.prize;

import lotto.domain.Lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResultCalculator {
    private final PrizeCalculationStrategy strategy;

    public LottoResultCalculator(PrizeCalculationStrategy strategy) {
        this.strategy = strategy;
    }

    public Map<LottoPrize, Integer> calculateResults(List<Lotto> lottoNumbers, List<Integer> winningNumbers, int bonusNumber) {
        Map<LottoPrize, Integer> prizeCountMap = new HashMap<>();

        // 각 로또 번호와 당첨 번호 비교
        for (Lotto lotto : lottoNumbers) {
            LottoPrize prize = strategy.calculate(winningNumbers, bonusNumber, lotto);
            if (prize != null) {
                prizeCountMap.put(prize, prizeCountMap.getOrDefault(prize, 0) + 1);
            }
        }

        return prizeCountMap;
    }
}
