public class Card {
    CardColor color;
    CardValue value;

    public Card(CardColor color, CardValue value) {
        this.color = color;
        this.value = value;
    }

    public CardColor getColor() {
        return color;
    }

    public CardValue getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.format("Value: %s | Color: %s", value, color);
    }
}
