package lotto;

import lotto.domain.Lotto;
import lotto.domain.prize.LottoPrize;
import lotto.input.InputReader;
import lotto.output.OutputView;
import lotto.domain.generator.LottoFactory;
import lotto.domain.prize.LottoResultCalculator;
import lotto.domain.prize.DefaultPrizeCalculationStrategy;
import lotto.util.YieldCalculator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    private final InputReader inputReader;
    private final OutputView outputView;
    private final LottoFactory lottoFactory;
    private final LottoResultCalculator resultCalculator;
    private final YieldCalculator yieldCalculator;

    /**
     * Application 생성자 - 의존성 주입을 통해 필요한 객체를 전달받습니다.
     */
    public Application(InputReader inputReader, OutputView outputView, LottoFactory lottoFactory,
                       LottoResultCalculator resultCalculator, YieldCalculator yieldCalculator) {
        this.inputReader = inputReader;
        this.outputView = outputView;
        this.lottoFactory = lottoFactory;
        this.resultCalculator = resultCalculator;
        this.yieldCalculator = yieldCalculator;
    }

    /**
     * 로또 프로그램의 실행 흐름을 제어하는 메서드입니다.
     */
    public void run() {
        // 로또 구입 금액 입력
        outputView.printPurchasePrompt();
        Long purchasePrice = inputReader.purchasePrice();
        Long purchaseCnt = purchasePrice / 1000;

        // 로또 구매 개수와 번호 출력
        outputView.printLottoPurchaseCount(purchaseCnt);
        List<Lotto> lottoNumbers = lottoFactory.createLottos(purchaseCnt);
        outputView.printPurchasedLottoNumbers(lottoNumbers);

        // 당첨 번호 및 보너스 번호 입력
        outputView.printWinningPrompt();
        List<Integer> winningNumbers = inputReader.winningNumbers();
        outputView.printBonusPrompt();
        int bonusNumber = inputReader.bonusNumber();

        // 당첨 결과 계산 및 출력
        Map<LottoPrize, Integer> prizeCountMap = resultCalculator.calculateResults(lottoNumbers, winningNumbers, bonusNumber);
        outputView.printPrizeCount(prizeCountMap);

        // 수익률 계산 및 출력
        double yield = yieldCalculator.calculateYield(prizeCountMap, purchasePrice);
        outputView.printYield(yield);
    }

    /**
     * 프로그램의 시작점이며, 의존성 주입을 통해 Application 인스턴스를 구성합니다.
     */
    public static void main(String[] args) {
        Application app = new Application(
                new InputReader(),
                new OutputView(),
                new LottoFactory(),
                new LottoResultCalculator(new DefaultPrizeCalculationStrategy()),
                new YieldCalculator()
        );
        app.run();
    }
}
