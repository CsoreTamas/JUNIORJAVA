import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HungarianPokerHandEvaluatorTest {
    @Test
    void shouldReturnPoker() {
        Hand hand = new Hand(List.of(
                new Card(CardColor.PIROS, CardValue.ASZ),
                new Card(CardColor.MAKK, CardValue.ASZ),
                new Card(CardColor.ZOLD, CardValue.ASZ),
                new Card(CardColor.TOK, CardValue.ASZ),
                new Card(CardColor.ZOLD, CardValue.IX),
                new Card(CardColor.MAKK, CardValue.FELSO),
                new Card(CardColor.TOK, CardValue.FELSO)
        ));
        HungarianPokerHandEvaluator evaluator = HungarianPokerHandEvaluator.getInstance();
        HandType handType = evaluator.evaluate(hand);

        assertEquals(HandType.POKER, handType);
    }

    @Test
    void shouldReturnFlush() {
        Hand hand = new Hand(List.of(
                new Card(CardColor.PIROS, CardValue.ASZ),
                new Card(CardColor.PIROS, CardValue.ASZ),
                new Card(CardColor.PIROS, CardValue.KIRALY),
                new Card(CardColor.PIROS, CardValue.ASZ),
                new Card(CardColor.PIROS, CardValue.IX),
                new Card(CardColor.PIROS, CardValue.FELSO),
                new Card(CardColor.PIROS, CardValue.FELSO)
        ));
        HungarianPokerHandEvaluator evaluator = HungarianPokerHandEvaluator.getInstance();
        HandType handType = evaluator.evaluate(hand);

        assertEquals(HandType.FLUSH, handType);
    }

    @Test
    void shouldReturnAlmostFlush() {
        Hand hand = new Hand(List.of(
                new Card(CardColor.PIROS, CardValue.ASZ),
                new Card(CardColor.PIROS, CardValue.ASZ),
                new Card(CardColor.PIROS, CardValue.KIRALY),
                new Card(CardColor.PIROS, CardValue.ASZ),
                new Card(CardColor.PIROS, CardValue.IX),
                new Card(CardColor.TOK, CardValue.FELSO),
                new Card(CardColor.PIROS, CardValue.FELSO)
        ));
        HungarianPokerHandEvaluator evaluator = HungarianPokerHandEvaluator.getInstance();
        HandType handType = evaluator.evaluate(hand);

        assertEquals(HandType.ALMOST_FLUSH, handType);
    }

    @Test
    void shouldReturnNothing() {
        Hand hand = new Hand(List.of(
                new Card(CardColor.TOK, CardValue.VII),
                new Card(CardColor.ZOLD, CardValue.VIII),
                new Card(CardColor.PIROS, CardValue.KIRALY),
                new Card(CardColor.MAKK, CardValue.ALSO),
                new Card(CardColor.TOK, CardValue.IX),
                new Card(CardColor.ZOLD, CardValue.FELSO),
                new Card(CardColor.MAKK, CardValue.FELSO)
        ));
        HungarianPokerHandEvaluator evaluator = HungarianPokerHandEvaluator.getInstance();
        HandType handType = evaluator.evaluate(hand);

        assertEquals(HandType.NOTHING, handType);
    }
}
