package game;

import exception.InvalidHandException;

import java.util.List;

public class Hand {
    private final List<Card> cards;

    public Hand(List<Card> cards) {
        if (cards.size() != 7) {
            throw new InvalidHandException("The hand must contain 7 cards.");
        }
        this.cards = cards;
    }

    public List<Card> getCards() {
        return cards;
    }
}
