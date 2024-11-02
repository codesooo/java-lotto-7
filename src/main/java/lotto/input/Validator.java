package lotto.input;

/**
 * 입력 값 유효성 검증 메서드
 */
public class Validator {
    public static void validateNotEmpty(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 값을 입력하세요.");
        }
    }

    public static void validateNumericInput(String input) {
        if (!input.matches("^[0-9]+$")) {
            throw new IllegalArgumentException("[ERROR] 입력에 숫자만 포함될 수 있습니다.");
        }
    }

    public static void validateCommaSeparatedNumericInput(String input) {
        if (!input.matches("^[0-9,]+$")) {
            throw new IllegalArgumentException("[ERROR] 입력에 숫자와 쉼표만 포함될 수 있습니다.");
        }
    }

    public static void validatePurchasePrice(Long price) {
        if (price % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000의 배수여야 합니다.");
        }
    }

    public static void validateRange(int number, int min, int max) {
        if (number < min || number > max) {
            throw new IllegalArgumentException("[ERROR] 입력된 숫자는 " + min + " 이상 " + max + " 이하여야 합니다.");
        }
    }
}
