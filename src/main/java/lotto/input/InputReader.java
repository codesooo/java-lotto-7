package lotto.input;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import camp.nextstep.edu.missionutils.Console;

public class InputReader {
    public Long purchasePrice() {
        String input = Console.readLine();
        Validator.validateNotEmpty(input);
        Long price = Long.parseLong(input);
        Validator.validatePurchasePrice(price);
        return price;
    }

    public List<Integer> winningNumbers() {
        String input = Console.readLine();
        Validator.validateNotEmpty(input);
        Validator.validateCommaSeparatedNumericInput(input);
        List<Integer> numbers = Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        numbers.forEach(number -> Validator.validateRange(number, 1, 45));
        return numbers;
    }

    public int bonusNumber() {
        String input = Console.readLine();
        Validator.validateNotEmpty(input);
        Validator.validateNumericInput(input);
        int number = Integer.parseInt(input);
        Validator.validateRange(number, 1, 45);
        return number;
    }
}
