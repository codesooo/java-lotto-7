package lotto;

import lotto.input.InputReader;
import lotto.output.OutputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        InputReader inputReader = new InputReader();
        OutputView outputView = new OutputView();

        // 로또 구입 금액 입력
        outputView.printPurchasePrompt();
        Long purchasePrice = inputReader.purchasePrice();
        Long purchaseCnt = purchasePrice / 1000;

        // 구매한 로또 번호 생성
        outputView.printLottoPurchaseCount(purchaseCnt);
        List<Lotto> lottoNumbers = LottoGenerator.generateLottos(purchaseCnt);
        outputView.printPurchasedLottoNumbers(lottoNumbers);

        // 당첨 번호 입력
        outputView.printWinningPrompt();
        List<Integer> winningNumbers = inputReader.winningNumbers();

        // 보너스 번호 입력
        outputView.printBonusPrompt();
        int bonusNumber = inputReader.bonusNumber();


    }
}
