import java.util.ArrayList;
import java.util.List;

public class RecamansSequence {
    public static void main(String[] args) {
        System.out.println(calculateRecamansSequence(10));
    }

    public static List<Integer> calculateRecamansSequence(int number) {
        List<Integer> numbers = new ArrayList<>();
        int previousIndex = 0;
        numbers.add(previousIndex);
        for (int i = 1; i < number; i++) {
            // get the (i-1) element of the list and subtract i
            int calculatingNumber = previousIndex - i;
            //a(n-1)-n if it not already in the list and greater than 0!!
            if (calculatingNumber > 0 && !numbers.contains(calculatingNumber)) {
                // than (i - 1) - i
                previousIndex = calculatingNumber;
                numbers.add(calculatingNumber);
            } else { //a(n-1)+n if it smaller than 0 and if it in the list!!
                // than (i - 1) + i
                calculatingNumber = previousIndex + i;
                numbers.add(calculatingNumber);
                previousIndex = calculatingNumber;
            }
        }
        return numbers;
    }
}
