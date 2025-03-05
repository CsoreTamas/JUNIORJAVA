
public class MethodPractice {
    public static void main(String[] args) {

        // 1)
        System.out.println(isGraterThan50(49));

        //2)
        System.out.println(getMax(20, 19));

        //3)
        System.out.println(compareTwoNumbers(2, 1));

        //4)
        printNumbers1To100();
        // nincs szükség sout-ra, mivel nem várunk vissza semmit / nem ad vissza értéket. (void)

        //5)
        printNumbersDivisibleBy5(20);

        //6)
        System.out.println(isPrime(5));

        //7)
        System.out.println(isDivisible(20, 3));

        //8)
        System.out.println(isProdEqualTo(1, 3, 3));

        //9)
        printCubicNumbers(4);

        //10)
        printCubicNumbersUpTo(64);

        //11)
        System.out.println(canSumToNumber(10, 5, 6, 3, 4));

        //12)
        System.out.println(repeatString("hello ", 4));

        //13)
        System.out.println(concatenateStrings("hello ", "tamas ", "vagyok"));


    }

    //1)
    public static boolean isGraterThan50(int number) {
        return number > 50;
    }

    //2)
    public static int getMax(int number1, int number2) {
        return Math.max(number1, number2);

    }

    //3)
    public static String compareTwoNumbers(int number1, int number2) {
        if (number2 < number1) {
            return "The first number is greater";
        } else if (number2 > number1) {
            return "The second number is greater";
        } else {
            return "The two numbers are equal";
        }
    }

    //4)
    public static void printNumbers1To100() {
        for (int i = 1; i <= 100; i++) {
            System.out.println(i);
        }
    }

    //5)
    public static void printNumbersDivisibleBy5(int number) {
        for (int i = 1; i <= number; i++) {
            if (i % 5 == 0) {
                System.out.println(i);
            }
        }
    }

    //6)
    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    //7)
    public static boolean isDivisible(int number, int divisor) {
        return number % divisor == 0;
    }

    //8)
    public static boolean isProdEqualTo(int number1, int number2, int number3) {
        return number1 * number2 == number3;
    }

    //9)
    public static void printCubicNumbers(int number) {
        for (int i = 0; i <= number; i++) {
            System.out.println((int) Math.pow(number, i));
            //numbernek az i-edik hatványát írom ki
        }
    }

    //10)
    public static void printCubicNumbersUpTo(int number) {
        for (int i = 1; i <= number; i++) {
            int result = (int) Math.pow(i, 3);
            //elmentem egy int változóba a köbös eredményeket
            if (result <= number) {
                //csak a number-ig írom ki a számokat.
                System.out.println(result);
            }
        }
    }

    //11)
    public static boolean canSumToNumber(int target, int... numbers) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                // megvizsgálunk minden lehetőséget a 2 for loopal
                // azért j = i + 1, mert ilyenkor ha az i pl 2 akkor a j 3 lesz amivel
                //azt érjük el, hogy nem nézünk ugyan azon a helyen lévő számot.
                if (numbers[i] + numbers[j] == target) {
                    //összeadjuk a numbers tömbnek az i-edig illetve
                    //azt a j-edik elemét.
                    return true;
                }
            }
        }
        return false;
    }

    //12)
    public static String repeatString(String repeat, int number) {
        if (number < 1) {
            return "";
        }
        String result = "";
        //léthre hozok 1 üres String változót
        for (int i = 0; i < number; i++) {
            result += repeat;
            //hozzá adom azt a szöveget amit beírok.
            //itt feldob egy olyan lehetőséget, hogy használjak StringBuildert,
            //de én egyelőre ígyhagynám.
        }
        return result;
    }

    //13)
    public static String concatenateStrings(String... strings) {
        StringBuilder sum = new StringBuilder();
        //létherehozok egy StringBuildert + elnevezem
        for (String s : strings) {
            sum.append(s);
            //StringBuilder (név).append(magyarul mellékel) (tömb[i]-edik eleme) / foreachnél pedig
            //az aktuális elem (s)
        }
        return sum.toString();
        //.toString() azért kell hogy átkonvertáljuk Stringé a Stringbuilderben tartalmát!
    }
}


