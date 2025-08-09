package fourth.task;

import java.util.List;

public class FourthTaskMain {
    public static void main(String[] args) {
        List<OutDoorActivity> activityList = List.of(
                new Hiking(20, 10),
                new Hiking(100, 0),
                new Running(500, 42),
                new Running(60, 0),
                new Cycling(60, 500),
                new Cycling(10, 23)
        );
        for (Activity activity : activityList) {
            System.out.println(activity);
        }
    }
}

