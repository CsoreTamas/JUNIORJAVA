import java.util.Comparator;
import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;

public class FunctionalInterfaces {

    //1. Simple Predicate
    //Write a Predicate<Integer> that checks if a number is greater than 10.
    //Test it on 5, 15.
    Predicate<Integer> predicate = n -> n > 10;

    //2. String Length Function
    //Write a Function<String, Integer> that returns the length of a string.
    Function<String, Integer> functionLambda = string -> string.length();
    //Method Reference
    Function<String, Integer> function = String::length;

    //3. String Printer Consumer
    //Write a Consumer<String> that prints "Name: " followed by the string.
    Consumer<String> consumerLambda = s -> System.out.println(s);
    //Method Reference
    Consumer<String> consumer = System.out::println;

    //4. Random Number Supplier
    //Write a Supplier<Double> that returns a random double between 0 and 1.
    Supplier<Double> supplierLambda = () -> Math.random();
    //Method Reference
    Supplier<Double> supplier = Math::random;

    //5. Decide the Interface
    //Given the lambda (x, y) -> x + y, decide whether it matches
    // BiFunction<Integer,Integer,Integer> or BinaryOperator<Integer> (and explain the difference).
    BinaryOperator<Integer> binarySum = (a, b) -> a + b;
    //Method Reference
    BinaryOperator<Integer> binaryOperator = Integer::sum;
    //NOTE BinaryOperator is better because the return type is the same as the input type.

    //6. Comparator Lambda
    //Write a Comparator<String> that sorts strings alphabetically ignoring case.
    Comparator<String> stringComparator = (s1, s2) -> s1.compareToIgnoreCase(s2);
    //Method Reference
    Comparator<String> sComparator = String::compareToIgnoreCase;

    //7. Chained Functions
    //Define two Function<Integer,Integer>: one adds 5, another multiplies by 2.
    //Use andThen and compose to show different results.
    Function<Integer, Integer> addFive = x -> x + 5;
    Function<Integer, Integer> multiplyByTwo = x -> x * 2;
    //1. add 2. multiply
    int andThan = addFive.andThen(multiplyByTwo).apply(5);
    //1. multiply 2. add
    int compose = addFive.compose(multiplyByTwo).apply(5);


    //8. Negating Predicates
    //Write a Predicate<String> that checks if a string is empty.
    //Then negate it using .negate().
    Predicate<String> isEmpty = s -> s.isEmpty();
    //Method Reference
    Predicate<String> isEmptyMethodReference = String::isEmpty;
    Predicate<String> negate = isEmpty.negate();

    //9. Method Reference
    //Express the following lambda as a method reference:
    //Function<String,Integer> f = s -> Integer.parseInt(s);
    Function<String, Integer> f = Integer::parseInt;

    //10. Consumer Chaining
    //Write two Consumer<String>: one prints the string, another prints its length.
    //Chain them with andThen.
    Consumer<String> print = s -> System.out.println(s);
    //Method Reference
    Consumer<String> printS = System.out::println;
    Consumer<String> printLength = s -> System.out.println(s.length());

    Consumer<String> combinedConsumer = print.andThen(printLength);

    //11. BinaryOperator Example
    //Write a BinaryOperator<Integer> that returns the maximum of two integers.
    BinaryOperator<Integer> witchIsGreater = (a, b) -> a > b ? a : b;

    //12. Decide the Interface
    //Given the lambda () -> "Hello", decide whether it’s a Supplier<String> or something else.
    Supplier<String> printHello = () -> "Hello";

    //13. BiFunction Example
    //Write a BiFunction<String,String,Integer> that takes two strings and returns the length of their concatenation.
    BiFunction<String, String, Integer> biFunction = (s1, s2) -> (s1 + s2).length();

    //14. UnaryOperator Example
    //Write a UnaryOperator<String> that trims a string and converts it to uppercase.
    UnaryOperator<String> unaryOperator = s -> s.trim().toUpperCase();
    //trim() --> cut the spaces at the beginning and at the end of the string

    //15. Function Composition Chain
    //Chain three Function<String,String> lambdas:
    //add "Hello " prefix
    //convert to uppercase
    //add "!" suffix
    //Apply it to "world".
    //NOTE
    // PREFIX ---> adds a string to the START of 's'
    Function<String, String> addPrefix = s -> "Hello " + s;
    Function<String, String> toUpperCase = s -> s.toUpperCase();
    //Method Reference
    Function<String, String> toUpperCaseMethodReference = String::toUpperCase;
    //NOTE:
    // SUFFIX ---> adds a string to the END of the 's'
    Function<String, String> addSuffix = s -> s + "!";
    Function<String, String> fullFunction = addPrefix.andThen(toUpperCase).andThen(addSuffix);
    String result = fullFunction.apply("world");

    //16. Custom Functional Interface
    //Create your own @FunctionalInterface called TriFunction<T,U,V,R> with a method apply(T t, U u, V v).
    //Implement it with a lambda (a,b,c) -> a + b + c for integers.
    @FunctionalInterface
            //public interface<>{}
    interface TriFunction<T, U, V, R> {
        R apply(T t, U u, V v);
    }

    TriFunction<Integer, Integer, Integer, Integer> triFunction = (a, b, c) -> a + b + c;

    //17. Using Predicate in Practice
    //Write a method that accepts a Predicate<String> and applies it to filter a list of words.
    //Pass different lambdas to test (e.g., startsWith "A", contains "b").
    public static List<String> filter(List<String> words, Predicate<String> condition) {
        return words.stream()
                .filter(condition)
                .collect(Collectors.toList());
    }

    //18. Recognize the Type
    //What functional interface fits the lambda (String s) -> s.equals("test")?
    //(Answer: Predicate<String>)
    static Predicate<String> isTest = s -> s.equals("test");

    //19. Higher-Order Function
    //Write a method that takes a Function<Integer,Integer> as parameter and applies it 5 times in a row to the number 2.
    public static int applyFiveTimes(Function<Integer, Integer> function) {
        int num = 2;
        for (int i = 0; i < 5; i++) {
            num = function.apply(num);
        }
        return num;
    }

    //20. Lambda Guessing
    //Given the lambda (x, y) -> x.compareTo(y), identify the correct interface (Comparator<T>).
    //Explain why it’s not a BiFunction<T,T,Integer> even though signatures look similar.
    //NOTE
    // A Comparator and BiFunction can return the same number from the same lambda expression, but only the
    // Comparator gives that number a specific meaning in java e.g., sorting.

    public static void main(String[] args) {
        //17.
        List<String> words = List.of("Apple", "Iphone", "Anaconda", "Doby", "Nike", "Bag");

        List<String> startsWithA = filter(words, word -> word.toLowerCase().startsWith("a"));
        List<String> containsB = filter(words, word -> word.toLowerCase().contains("b"));

        //18.
        System.out.println(isTest.test("test"));

        //19.
        Function<Integer, Integer> addOne = x -> x + 1;
        int result = applyFiveTimes(addOne); // applyFiveTimes(x -> x + 1)
    }
}
