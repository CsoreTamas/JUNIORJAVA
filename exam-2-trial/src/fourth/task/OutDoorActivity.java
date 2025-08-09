package fourth.task;

public abstract sealed class OutDoorActivity extends AbstractActivity permits Cycling, Running, Hiking {

    public OutDoorActivity(int durationMinutes) {
        super(durationMinutes);
    }
}
