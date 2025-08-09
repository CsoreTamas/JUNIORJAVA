package second.task;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CompetitorUnit {
    public static Competitor countApples(List<Competitor> list) {
        Map<String, Integer> applesMap = new HashMap<>();
        Competitor winner = new Competitor();
        for (Competitor competitor : list) {
            applesMap.merge(competitor.getName(), competitor.getAppleCount(), Integer::sum);
        }

        int appleCount = 0;
        for (Map.Entry<String, Integer> frequency : applesMap.entrySet()) {
            if (frequency.getValue() > appleCount) {
                appleCount = frequency.getValue();
                winner.setName(frequency.getKey());
                winner.setAppleCount(frequency.getValue());
            }
        }
        return winner;
    }
}
