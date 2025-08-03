package reader;

import game.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class PropertiesReader {
    private final Properties properties;

    public PropertiesReader(String filePath) {
        properties = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream(filePath)) {
            properties.load(input);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public Map<String, List<Card>> getHands() {
        Map<String, List<Card>> hands = new HashMap<>();

        for (String key : properties.stringPropertyNames()) {
            String value = properties.getProperty(key);

            String[] cardStrings = value.split(",");

            List<Card> cards = new ArrayList<>();
            for (String cardString : cardStrings) {
                Card card = cardParse(cardString);
                cards.add(card);
            }
            hands.put(key, cards);
        }
        return hands;
    }

    public Card cardParse(String cardString) {
        String[] cardParts = cardString.split("-");

        CardColor color = CardColor.valueOf(cardParts[0]);
        CardValue value = CardValue.valueOf(cardParts[1]);

        return new Card(color, value);
    }

    public static void evaluator() {
        PropertiesReader reader = new PropertiesReader("application.properties");

        Map<String, List<Card>> hands = reader.getHands();

        HungarianPokerHandEvaluator evaluator = HungarianPokerHandEvaluator.getInstance();

        for (Map.Entry<String, List<Card>> entry : hands.entrySet()) {
            String handName = entry.getKey();
            List<Card> cards = entry.getValue();
            Hand hand = new Hand(cards);
            HandType result = evaluator.evaluate(hand);
            System.out.println(handName + "---->" + result);
        }
    }
}
