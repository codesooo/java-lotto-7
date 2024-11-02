package lotto.domain.prize;

import lotto.Lotto;

import java.util.List;

public class LottoResultCalculator {

    // 당첨 번호, 사용자 로또 번호 비교 => 일치 갯수에 따라 상금 반환
    public static LottoPrize calculatePrize(List<Integer> winningNumbers, int bonusNumber, Lotto userLotto) {
        int matchCount = countMatches(winningNumbers, userLotto.getNumbers());
        boolean bonusMatch = userLotto.getNumbers().contains(bonusNumber);
        return determinePrize(matchCount, bonusMatch);
    }

    // 당첨 번호, 사용자 번호 간의 일치 개수 계산
    private static int countMatches(List<Integer> winningNumbers, List<Integer> userNumbers) {
        return (int) winningNumbers.stream()
                .filter(userNumbers::contains)
                .count();
    }

    // 일치 개수와 보너스 번호 존재 여부에 따라 상금 반환
    private static LottoPrize determinePrize(int matchCount, boolean bonusMatch) {
        if (matchCount == 5 && bonusMatch) {
            return LottoPrize.FIVE_MATCHES_WITH_BONUS;
        }
        return findPrizeByMatchCount(matchCount);
    }

    // 매칭 개수에 따라 해당하는 LottoPrize 반환
    private static LottoPrize findPrizeByMatchCount(int matchCount) {
        for (LottoPrize prize : LottoPrize.values()) {
            if (prize.getMatchCount() == matchCount) {
                return prize;
            }
        }
        return null;
    }
}
