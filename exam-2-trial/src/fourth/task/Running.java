package fourth.task;

public non-sealed class Running extends OutDoorActivity {
    private double distanceKm;

    public Running(int durationMinutes, double distanceKm) {
        super(durationMinutes);
        this.distanceKm = distanceKm;
    }

    @Override
    public double caloriesBurned() {
        return durationMinutes() * 10 + distanceKm * 5;
    }

    @Override
    public boolean isIntense() {
        return super.isIntense();
    }

    @Override
    public String toString() {
        return String.format("Running: %.1f kcal burned! Was Intense? --> %b", caloriesBurned(), isIntense());
    }
}
