package fourth.task;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CyclingTest {
    @Test
    void shouldCalculateKcalAndDecideIntense() {
        OutDoorActivity cyclingMarathon = new Cycling(500, 60);
        OutDoorActivity hobbyCycling = new Cycling(50, 10);

        double cyclingMarathonKcal = cyclingMarathon.caloriesBurned();
        double hobbyCyclingKcal = hobbyCycling.caloriesBurned();

        assertEquals(6000, cyclingMarathonKcal);

        assertTrue(cyclingMarathon.isIntense());

        assertEquals(100, hobbyCyclingKcal);

        assertFalse(hobbyCycling.isIntense());
    }
}
