package game;

import java.util.HashMap;
import java.util.Map;

public class HungarianPokerHandEvaluator {
    private static HungarianPokerHandEvaluator INSTANCE = new HungarianPokerHandEvaluator();

    private HungarianPokerHandEvaluator() {
    }

    public static HungarianPokerHandEvaluator getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new HungarianPokerHandEvaluator();
        }
        return INSTANCE;
    }

    public HandType evaluate(Hand hand) {
        Map<CardColor, Integer> colorFrequency = new HashMap<>();
        Map<CardValue, Integer> valueFrequency = new HashMap<>();

        for (Card card : hand.cards()) {
            colorFrequency.merge(card.getColor(), 1, Integer::sum);
            valueFrequency.merge(card.getValue(), 1, Integer::sum);
        }

        if (valueFrequency.containsValue(4)) {
            return HandType.POKER;
        } else if (colorFrequency.containsValue(7)) {
            return HandType.FLUSH;
        } else if (colorFrequency.containsValue(4) || colorFrequency.containsValue(5) || colorFrequency.containsValue(6)) {
            return HandType.ALMOST_FLUSH;
        } else {
            return HandType.NOTHING;
        }
    }
}
