package lotto.input;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;

public class InputReader {

    public Long purchasePrice() {
        String input = Console.readLine();

        validateNotEmpty(input);    // 입력이 비어있는지 검증

        Long price = Long.parseLong(input);

        validatePurchasePrice(price);   // 구입 금액이 1,000의 배수인지 검증

        return price;
    }

    public List<Integer> winningNumbers() {
        String input = Console.readLine();

        validateNotEmpty(input);    // 입력이 비어있는지 검증

        // 입력에 숫자와 쉼표만 있는지 검증
        validateCommaSeparatedNumericInput(input);

        // 쉼표로 구분된 입력을 정수 리스트로 변환
        List<Integer> numbers = parseIntegerList(input);

        // 각 숫자가 1 이상, 45 이하인지 검증
        for (int number : numbers) {
            validateRange(number, 1, 45);
        }

        return numbers;
    }

    public int bonusNumber() {
        String input = Console.readLine();

        validateNotEmpty(input);    // 입력이 비어있는지 검증
        validateNumericInput(input);    // 숫자만 포함되어 있는지 검증

        int number = Integer.parseInt(input);

        // 숫자가 1 이상, 45 이하인지 검증
        validateRange(number, 1, 45);
        return number;
    }
    private void validateNotEmpty(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 값을 입력하세요.");
        }
    }

    private void validateNumericInput(String input) {
        if (!input.matches("^[0-9]+$")) {
            throw new IllegalArgumentException("[ERROR] 입력에 숫자만 포함될 수 있습니다.");
        }
    }

    private void validateCommaSeparatedNumericInput(String input) {
        if (!input.matches("^[0-9,]+$")) {
            throw new IllegalArgumentException("[ERROR] 입력에 숫자와 쉼표만 포함될 수 있습니다.");
        }
    }

    private void validatePurchasePrice(Long price) {
        if (price % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000의 배수여야 합니다.");
        }
    }

    private void validateRange(int number, int min, int max) {
        if (number < min || number > max) {
            throw new IllegalArgumentException("[ERROR] 입력된 숫자는 " + min + " 이상 " + max + " 이하여야 합니다.");
        }
    }

    private List<Integer> parseIntegerList(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

}
