package game;

import exception.InvalidHandException;

import java.util.List;

public record Hand(List<Card> cards) {
    public Hand {
        if (cards.size() != 7) {
            throw new InvalidHandException("The hand must contain 7 cards.");
        }
    }
}
