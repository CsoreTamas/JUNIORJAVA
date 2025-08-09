package fourth.task;

public non-sealed class Cycling extends OutDoorActivity {
    private double averageSpeedKmH;

    public Cycling(int durationMinutes, double averageSpeedKmH) {
        super(durationMinutes);
        this.averageSpeedKmH = averageSpeedKmH;
    }

    @Override
    public double caloriesBurned() {
        return durationMinutes() * averageSpeedKmH * 0.2;
    }

    @Override
    public boolean isIntense() {
        return super.isIntense();
    }

    @Override
    public String toString() {
        return String.format("Cycling: %.1f kcal burned! Was Intense? --> %b", caloriesBurned(), isIntense());
    }
}
