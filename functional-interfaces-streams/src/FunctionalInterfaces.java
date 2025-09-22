import java.time.LocalDate;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FunctionalInterfaces {
    public static void main(String[] args) {
        //1. Write a Function<Integer, Integer> that doubles a number, and apply it to numbers 1–5.
        Function<Integer, Integer> multiplyBy2 = n -> n * 2;
        for (int i = 1; i < 5; i++) {
            System.out.println(multiplyBy2.apply(i));
        }

        //2. Create a Predicate<String> that checks if a string starts with "A". Test it with a list of words.
        Predicate<String> isStartsWithA = s -> s.startsWith("A");
        List<String> words = List.of("Apples", "Bananas", "TV", "Cup", "Chair", "TV", "Cup", "Apples");
        for (String word : words) {
            System.out.println(isStartsWithA.test(word));
        }

        //3. Use a Consumer<String> to print each element in a list of names with a prefix "Hello ".
        Consumer<String> addPrefix = s -> System.out.printf("Hello %s%n", s);
       /* for (String word : words) {
            addPrefix.accept(word);
        }
        */
        words.forEach(addPrefix);

        //4. Create a Supplier<LocalDate> that returns today’s date, and call it 3 times.
        Supplier<LocalDate> today = LocalDate::now;
        //Supplier<LocalDate> today = () -> LocalDate.now();
        for (int i = 0; i < 3; i++) {
            System.out.println(today.get());
        }

        //5. Use andThen() and compose() on two Function<Integer, Integer> lambdas (x -> x+1 and x -> x*2) and show the difference.
        Function<Integer, Integer> add1 = x -> x + 1;
        Function<Integer, Integer> times2 = x -> x * 2;
        //FIRST        SECOND
        Function<Integer, Integer> andThen = add1.andThen(times2);
        //SECOND       FIRST
        Function<Integer, Integer> compose = add1.compose(times2);

        System.out.println(andThen.apply(2));
        System.out.println(compose.apply(2));

        //6. From a list of numbers 1–20, filter only even numbers and collect them into a List<Integer>.
        List<Integer> evenNumbers = new ArrayList<>();
        Predicate<Integer> isEven = n -> n % 2 == 0;
        for (int i = 1; i <= 20; i++) {
            if (isEven.test(i)) {
                evenNumbers.add(i);
            }
        }
        System.out.println(evenNumbers);

        //7. Given a list of strings, convert them to uppercase using map().
        List<String> upperCaseList = words.stream()
                //.map(s -> s.toUpperCase())
                .map(String::toUpperCase).toList();
        System.out.println(upperCaseList);

        //8. Sort a list of strings by length using streams.
        List<String> sortedByLength = words.stream()
                //.sorted((s1,s2) ->Integer.compare(s1.length(),s2.length()))
                .sorted(Comparator.comparing(String::length)).toList();
        System.out.println(sortedByLength);

        //9. Given a list with duplicates, find the number of unique elements.
        long uniqueElement = words.stream().distinct().count();
        System.out.println(uniqueElement);

        //10. Given a list of sentences, split each into words and create a single list of words.
        List<String> sentences = List.of("Knock knock", "Who is there", "Hawai", "Hawai who", "I am good how are you");
        List<String> listOfWords = sentences.stream().flatMap(sentence -> Stream.of(sentence.split(" "))).toList();
        System.out.println(listOfWords);

        //11. Sum numbers from 1 to 100 using reduce().
        int sum = IntStream.range(1, 100).reduce(0, Integer::sum);
        //.reduce(0, (a, b) -> a + b);

        //12. Sort a list of employees (name, age) by age using a lambda Comparator.
        List<Employee> empList = new ArrayList<>(List.of(
                new Employee("Peti", 10),
                new Employee("Jani", 11),
                new Employee("Géza", 12),
                new Employee("Juli", 13)
        ));
        Comparator<Employee> employeeComparator = (e1, e2) -> Integer.compare(e1.age(), e2.age());
        empList.sort(employeeComparator);

        //13. From a list of integers, find the maximum odd number, return it as Optional<Integer>.
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Optional<Integer> result = numbers.stream()
                .filter(n -> n % 2 != 0)
                .max(Integer::compare);
        //.max((n1, n2) -> Integer.compare(n1, n2));

        //14. Given a list of words, group them by their first letter using Collectors.groupingBy.
        Map<Character, List<String>> groupByFirstChar = words.stream()
                .collect(Collectors.groupingBy(word -> word.charAt(0)));
        System.out.println(groupByFirstChar);

        //15. Partition a list of numbers into evens and odds using Collectors.partitioningBy.
        Map<Boolean, List<Integer>> evenOddMap = numbers.stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println(evenOddMap);

        //16. Define your own functional interface StringTransformer with one method transform(String input). Implement it using a lambda to reverse strings.
        StringTransformer StringReverser = input -> new StringBuilder(input).reverse().toString();
        System.out.println(StringReverser.transform("HELLO"));

        //17. Given a list of people (name, city, age), group them first by city, then by age group (<30, >=30).
        List<Person> listOfPeople = new ArrayList<>(List.of(
                new Person("Gizi", "Győr", 21),
                new Person("Béla", "Budapest", 10),
                new Person("Józsi", "Győr", 75),
                new Person("Fruzsi", "Budapest", 16),
                new Person("Tamás", "Debrecen", 64)
        ));
        Map<String, Map<String, List<Person>>> grouped = listOfPeople.stream()
                .collect(Collectors.groupingBy(
                        Person::city,
                        //person -> person.getCity(),
                        Collectors.groupingBy(person -> person.age() > 30 ? "<30" : ">30")
                ));
        System.out.println(grouped);

        //18. Use a parallel stream to sum numbers from 1 to 1,000,000 and compare performance with sequential streams.
        int sequentialSum = IntStream.range(1, 1_000_000).reduce(0, Integer::sum);
        int parallelSum = IntStream.range(1, 1_000_000).parallel().reduce(0, Integer::sum);

        //19.Collect a stream of integers into a custom CommaSeparatedString (e.g., [1,2,3] → "1,2,3").
        String StringResult = numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(","));
        System.out.println(StringResult);

        //20. Implement your own Collector that collects strings into a single string, separated by -, in uppercase (e.g., ["a", "b", "c"] → "A-B-C").
        Collector<String, StringBuilder, String> ownCollector = Collector.of(
                //Supplier: creates a new StringBuilder.
                StringBuilder::new,
                //Accumulator: appends the element, adding "-" if not the first element
                (sb, s) -> {
                    if (!sb.isEmpty()) {
                        sb.append("-");
                    }
                    sb.append(s);
                },
                //Combiner: merges two StringBuilders, adding "-" between them.
                (sb1, sb2) -> {
                    if (sb1.isEmpty()) {
                        return sb2;
                    }
                    if (sb2.isEmpty()) {
                        return sb1;
                    }
                    sb1.append("-").append(sb2);
                    return sb1;
                },
                //Finisher: converts StringBuilder to String and makes it uppercase.
                sb -> sb.toString().toUpperCase()
        );
        List<String> list = List.of("h", "e", "l", "l", "o");

        String resultString = list.stream().collect(ownCollector);
        System.out.println(resultString);

    }
}

