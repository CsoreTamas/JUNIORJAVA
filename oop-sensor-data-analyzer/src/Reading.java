import java.time.LocalTime;
import java.util.Objects;

public class Reading {
    private final double reading;
    private final LocalTime timestamp;

    public Reading(double reading, LocalTime timesTamp) {
        this.reading = reading;
        this.timestamp = timesTamp;
    }

    public double getReading() {
        return reading;
    }

    public LocalTime getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return String.format("%.2f at %s", reading, timestamp);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Reading reading1 = (Reading) o;
        return Double.compare(reading, reading1.reading) == 0 && Objects.equals(timestamp, reading1.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reading, timestamp);
    }
}
