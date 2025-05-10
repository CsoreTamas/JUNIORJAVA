//Write a method that takes in an array and returns the maximum difference between any two numbers.
public class ForthTask {
    public static void main(String[] args) {
        System.out.println(calculateTheGreatestDifference());
    }

    public static int calculateTheGreatestDifference(int... array) {
        int smallestNumber = array[0];
        int greatestNumber = array[0];
        for (int number : array) {
            if (number < smallestNumber) {
                smallestNumber = number;
            } else if (number > greatestNumber) {
                greatestNumber = number;
            }
        }
        return greatestNumber - smallestNumber;
    }
}
