package lotto.output;

import java.util.List;

public class OutputView {
    public void printLottoPrompt() {
        System.out.println("================== 로또 발매기 ==================\n\n");
    }

    public void printPurchasePrompt() {
        System.out.print("구입할 로또 금액을 입력하세요 : ");
    }

    public void printWinningPrompt() {
        System.out.print("당첨 번호를 입력하세요 : ");
    }

    public void printBonusPrompt() {
        System.out.print("보너스 번호를 입력하세요 : ");
    }

    public void printLottoPurchaseCount(int lottoCnt) {
        System.out.println(lottoCnt + "개를 구매했습니다.");
    }
    public void printPurchasedLottoNumbers(List<Integer> purchaseLottoNumList) {
        System.out.println(purchaseLottoNumList);
    }

}
