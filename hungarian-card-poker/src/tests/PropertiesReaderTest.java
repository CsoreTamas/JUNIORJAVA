package tests;

import game.Card;
import game.CardColor;
import game.CardValue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reader.PropertiesReader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PropertiesReaderTest {
    @Test
    void shouldReadProperties() {
        PropertiesReader reader = new PropertiesReader("test.properties");
        Map<String, List<Card>> hand = reader.getHands();
        List<Card> cards = hand.get("KEZ1");
        Card expectedCard = new Card(CardColor.PIROS, CardValue.ASZ);
        assertEquals(expectedCard, cards.getFirst());
    }

    @Test
    void shouldGetHands() {
        PropertiesReader reader = new PropertiesReader("test.properties");
        Map<String, List<Card>> expected = new HashMap<>();
        expected.put("KEZ1", List.of(
                new Card(CardColor.PIROS, CardValue.ASZ),
                new Card(CardColor.MAKK, CardValue.ASZ),
                new Card(CardColor.ZOLD, CardValue.ASZ),
                new Card(CardColor.TOK, CardValue.ASZ),
                new Card(CardColor.ZOLD, CardValue.IX),
                new Card(CardColor.MAKK, CardValue.FELSO),
                new Card(CardColor.TOK, CardValue.FELSO)
        ));
        assertEquals(expected, reader.getHands());
    }

    @Test
    void shouldParseTheCards() {
        PropertiesReader reader = new PropertiesReader("test.properties");
        reader.cardParse("PIROS-IX");
        Card card = new Card(CardColor.PIROS, CardValue.IX);
        Assertions.assertEquals(card, reader.cardParse("PIROS-IX"));
    }
}
