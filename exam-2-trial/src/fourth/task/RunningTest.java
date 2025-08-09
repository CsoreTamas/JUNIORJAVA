package fourth.task;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RunningTest {
    @Test
    void shouldCalculateKcalAndDecideIntense() {
        OutDoorActivity runningMarathon = new Running(500, 42);
        OutDoorActivity hobbyRunning = new Running(50, 0);

        double runningMarathonKcal = runningMarathon.caloriesBurned();
        double hobbyRunningKcal = hobbyRunning.caloriesBurned();

        assertEquals(5210, runningMarathonKcal);

        assertTrue(runningMarathon.isIntense());

        assertEquals(500, hobbyRunningKcal);

        assertFalse(hobbyRunning.isIntense());
    }
}
