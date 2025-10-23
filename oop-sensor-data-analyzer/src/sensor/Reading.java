package sensor;

import java.time.LocalTime;
import java.util.Objects;

public record Reading(double reading, LocalTime timestamp) {

    @Override
    public String toString() {
        return String.format("%.2f at %s", reading, timestamp);
    }
}
