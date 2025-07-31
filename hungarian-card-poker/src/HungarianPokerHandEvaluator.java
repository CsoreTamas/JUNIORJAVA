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
        if (valueFrequency(hand).containsValue(4)) {
            return HandType.POKER;
        } else if (colorFrequency(hand).containsValue(7)) {
            return HandType.FLUSH;
        } else if (colorFrequency(hand).containsValue(4) || colorFrequency(hand).containsValue(5) || colorFrequency(hand).containsValue(6)) {
            return HandType.ALMOST_FLUSH;
        } else {
            return HandType.NOTHING;
        }
    }

    private Map<CardValue, Integer> valueFrequency(Hand hand) {
        Map<CardValue, Integer> valueFrequency = new HashMap<>();
        for (Card card : hand.getCards()) {
            if (!valueFrequency.containsKey(card.getValue())) {
                valueFrequency.put(card.getValue(), 1);
            } else {
                valueFrequency.put(card.getValue(), valueFrequency.get(card.getValue()) + 1);
            }
        }
        return valueFrequency;
    }

    private Map<CardColor, Integer> colorFrequency(Hand hand) {
        Map<CardColor, Integer> colorFrequency = new HashMap<>();
        for (Card card : hand.getCards()) {
            if (!colorFrequency.containsKey(card.getColor())) {
                colorFrequency.put(card.getColor(), 1);
            } else {
                colorFrequency.put(card.getColor(), colorFrequency.get(card.getColor()) + 1);
            }
        }
        return colorFrequency;
    }
}
