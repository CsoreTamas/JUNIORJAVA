package fourth.task;

public abstract class AbstractActivity implements Activity {
    private int durationMinutes;

    @Override
    public int durationMinutes() {
        return durationMinutes;
    }

    @Override
    public boolean isIntense() {
        return Activity.super.isIntense();
    }

    public AbstractActivity(int durationMinutes) {
        this.durationMinutes = durationMinutes;
    }
}
