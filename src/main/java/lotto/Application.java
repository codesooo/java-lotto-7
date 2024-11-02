package lotto;

import lotto.domain.prize.LottoPrize;
import lotto.input.InputReader;
import lotto.output.OutputView;
import lotto.domain.prize.LottoResultCalculator;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        // 당첨 여부 계산
        Map<LottoPrize, Integer> prizeCountMap = new HashMap<>();
        int totalPrizeAmount = 0;

        for (Lotto lotto : lottoNumbers) {
            LottoPrize prize = LottoResultCalculator.calculatePrize(winningNumbers, bonusNumber, lotto);
            if (prize != null) {
                prizeCountMap.put(prize, prizeCountMap.getOrDefault(prize, 0) + 1);
                totalPrizeAmount += prize.getPrizeAmount();
            }
        }

        // 당첨 결과 출력
        outputView.printPrizeCount(prizeCountMap);


        // 수익률 계산
        double yield = (double) totalPrizeAmount / purchasePrice * 100;
        outputView.printYield(yield);


    }
}
