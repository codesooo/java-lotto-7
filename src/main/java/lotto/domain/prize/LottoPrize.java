package lotto.domain.prize;

public enum LottoPrize {
    THREE_MATCHES(3, 5_000),
    FOUR_MATCHES(4, 50_000),
    FIVE_MATCHES(5, 1_500_000),
    FIVE_MATCHES_WITH_BONUS(5, 30_000_000),
    SIX_MATCHES(6, 2_000_000_000);

    private final int matchCount;
    private final int prizeAmount;

    LottoPrize(int matchCount, int prizeAmount) {
        this.matchCount = matchCount;
        this.prizeAmount = prizeAmount;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }
    public String toFormattedString(int count) {
        if (this == FIVE_MATCHES_WITH_BONUS) {
            return String.format("%d개 일치, 보너스 볼 일치 (%s원) - %d개", matchCount, String.format("%,d", prizeAmount), count);
        }
        return String.format("%d개 일치 (%s원) - %d개", matchCount, String.format("%,d", prizeAmount), count);
    }
}
