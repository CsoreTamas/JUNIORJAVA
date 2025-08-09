package second.task;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SecondTaskTest {
    @Test
    void shouldSearchTheWinner() {
        List<Competitor> competitors = List.of(
                new Competitor("Alice", 25),
                new Competitor("Bob", 35),
                new Competitor("Charlie", 50),
                new Competitor("Alice", 32),
                new Competitor("Diana", 48),
                new Competitor("Eli", 20)
        );
        Competitor winner = new Competitor("Alice", 57);
        assertEquals(winner, CompetitorUnit.countApples(competitors));
    }
}
