package lotto.domain.generator;

import lotto.domain.Lotto;

import java.util.List;

public class LottoFactory {
    public static List<Lotto> createLottos(Long count) {
        return LottoGenerator.generateLottos(count);
    }
}
