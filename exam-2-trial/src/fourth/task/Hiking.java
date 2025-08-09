package fourth.task;

public final class Hiking extends OutDoorActivity {
    private double elevation;

    public Hiking(int durationMinutes, double elevation) {
        super(durationMinutes);
        this.elevation = elevation;
    }

    @Override
    public double caloriesBurned() {
        return durationMinutes() * 7;
    }

    @Override
    public boolean isIntense() {
        return super.isIntense();
    }

    @Override
    public String toString() {
        return String.format("Hiking: %.1f kcal burned! Was Intense? --> %b", caloriesBurned(), isIntense());
    }
}
