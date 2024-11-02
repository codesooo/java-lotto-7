package lotto.domain.prize;

import lotto.domain.Lotto;

import java.util.List;

public interface PrizeCalculationStrategy {
    LottoPrize calculate(List<Integer> winningNumbers, int bonusNumber, Lotto userLotto);
}
