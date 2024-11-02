package lotto.domain.generator;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

/**
 * 랜덤 로또 번호 생성 클래스
 * */
public class LottoGenerator {
    public static List<Lotto> generateLottos(Long count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6); // 올바른 메서드 호출
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }

}
