import java.util.Scanner;

public class SquareNumberLister {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = PrimeLister.getValidNumberFromTheUser(scanner);
        for (int i = 1; i < number; i++) {
            if (isSquareNumber(i)){
                System.out.println(i);
            }
        }
    }

    public static boolean isSquareNumber(int number) {
        if (number <= 0) {
            return false;
        }
        for (int i = 1; i <= number; i++) {
            if (i * i == number){
                return true;
            }
        }
return false;
    }

}
