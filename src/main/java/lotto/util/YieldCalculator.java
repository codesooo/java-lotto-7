package lotto.util;

import lotto.domain.prize.LottoPrize;

import java.util.Map;

/**
 * 수익률 계산을 담당 클래스
 */
public class YieldCalculator {
    public static double calculateYield(Map<LottoPrize, Integer> prizeCountMap, Long purchasePrice) {
        int totalPrizeAmount = prizeCountMap.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrizeAmount() * entry.getValue())
                .sum();
        return (double) totalPrizeAmount / purchasePrice * 100;
    }
}
