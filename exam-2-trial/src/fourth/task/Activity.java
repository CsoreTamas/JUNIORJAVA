package fourth.task;

public interface Activity {
    double caloriesBurned();

    int durationMinutes();

    default boolean isIntense() {
        double durationHour = (double) durationMinutes() / 60;
        return (caloriesBurned() / durationHour) > 600;
    }
}
