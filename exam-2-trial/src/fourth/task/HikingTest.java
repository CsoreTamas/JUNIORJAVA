package fourth.task;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HikingTest {
    @Test
    void shouldCalculateKcalAndDecideIntense() {
        OutDoorActivity hikingMountEverest = new Hiking(500, 8000);
        OutDoorActivity hobbyHiking = new Hiking(50, 10);

        double hikingMountEverestKcal = hikingMountEverest.caloriesBurned();
        double hobbyHikingKcal = hobbyHiking.caloriesBurned();

        assertEquals(3500, hikingMountEverestKcal);

        assertFalse(hikingMountEverest.isIntense());

        assertEquals(350, hobbyHikingKcal);

        assertFalse(hobbyHiking.isIntense());
    }
}
