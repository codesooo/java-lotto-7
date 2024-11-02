package lotto.domain.prize;

import lotto.domain.Lotto;

import java.util.List;

/**
 * DefaultPrizeCalculationStrategy 클래스는 기본적인 당첨 여부 계산 전략을 제공합니다.
 */
public class DefaultPrizeCalculationStrategy implements PrizeCalculationStrategy {
    /**
     * 사용자의 로또 번호와 당첨 번호, 보너스 번호를 비교하여 해당 로또의 상금을 결정합니다.
     *
     * @param winningNumbers 당첨 번호 목록
     * @param bonusNumber 보너스 번호
     * @param userLotto 사용자 로또 번호
     * @return 해당 로또 번호가 당첨된 LottoPrize 객체
     */
    @Override
    public LottoPrize calculate(List<Integer> winningNumbers, int bonusNumber, Lotto userLotto) {
        int matchCount = (int) winningNumbers.stream()
                .filter(userLotto.getNumbers()::contains)
                .count();
        boolean bonusMatch = userLotto.getNumbers().contains(bonusNumber);

        if (matchCount == 5 && bonusMatch) {
            return LottoPrize.FIVE_MATCHES_WITH_BONUS;
        }

        return LottoPrize.findPrizeByMatchCount(matchCount);
    }
}

