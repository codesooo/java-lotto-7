package lotto.output;

import lotto.Lotto;
import lotto.domain.prize.LottoPrize;

import java.util.List;
import java.util.Map;

public class OutputView {
    public void printPurchasePrompt() {
        System.out.println("구입할 로또 금액을 입력하세요 : ");
    }

    public void printWinningPrompt() {
        System.out.println("당첨 번호를 입력하세요 : ");
    }

    public void printBonusPrompt() {
        System.out.println("보너스 번호를 입력하세요 : ");
    }

    public void printLottoPurchaseCount(Long lottoCnt) {
        System.out.println(lottoCnt + "개를 구매했습니다.");
    }
    public void printPurchasedLottoNumbers(List<Lotto> lottoList) {
        for (Lotto lotto : lottoList) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void printPrizeCount(Map<LottoPrize, Integer> prizeCountMap) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        for (LottoPrize prize : LottoPrize.values()) {
            int count = prizeCountMap.getOrDefault(prize, 0);
            System.out.println(prize.toFormattedString(count));
        }
    }

    public void printYield(double yield) {
        System.out.printf("총 수익률은 %.2f%%입니다.%n", yield);
    }

}
