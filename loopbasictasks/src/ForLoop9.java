public class ForLoop9 {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 1; i <= 20 ; i++) {
            sum += i;
        }
        float average = sum / 20.0f;
        System.out.println(average);
    }
}
