package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

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
