# stream()

It converts a collection into a Stream to perform functional operations on it.  
Use:
List<String> names = List.of("Anna","Bela","Jozsi");
Stream<String> stream = names.stream();

# map()
It transforms the elements of the stream into another representation. For example:
You can convert a text to uppercase or select only one field from an object.
Use:
```java
List<String> upperCase = names.stream()
        .map(String::toUpperCase)
        .toList();
```  

# filter()
Based on a logical condition, it filters out the elements that do not meet the given criterion.
This way, only the "appropriate" elements remain in the stream.
Use:
```java
List<String> startingWithA = names.stream()
        .filter(n -> n.startsWith("A"))
        .toList();
```    

# sorted()
It sorts the elements of the stream based on the default or specified sorting rule.
Use:
```java
List<String> sorted = names.stream()
        .sorted() //Base: ABC
        .toList();
```  

# distinct()
It removes duplicate elements from the stream.
Use:
```java
List<String> names = List.of("Anna","Bela","Jozsi","Jozsi");
List<String> uniques = names.stream()
        .distinct()
        .toList();
```  

# count()
It counts how many elements are in the stream.
Use:
```java
long pieces = names.stream()
        .filter(n -> n.startsWith("A"))
        .count();
```  
 
# flatMap()
It merges multiple inner streams into a single unified stream. For example:
Splitting sentences into words.
Use:
```java
List<String> sentences = List.of("Hello I","am the","King of streams");
List<String> words = sentences.stream()
        .flatMap(s -> Arrays.stream(s.split(" ")))
        .toList();
```  

# reduce()
It combines the elements into a single value based on a reduction logic
summation, multiplication, minimum, maximum
Use:
```java
int result = IntStream.rangeClosed(1,5)
        .reduce(0, Integer::sum);
```  

# collect()
It collects the processed elements of the stream into a final structure.
List, Set, Map or even a single String.
Use:
```java
List<String> list = names.stream()
        .filter(n -> n.length() > 2)
        .collect(Collectors.toList());
```  

# .max() / .min()
It finds the largest or smallest element in the stream based on a comparator.
Use:
```java
Optional<String> longest = names.stream()
        .max(Comparator.comparing(String::length));
```  
# forEach()
It performs an operation on each element of the stream.
Use:
```java
names.stream()
        .forEach(n -> System.out.print("Welcome " + n));
```  

# Collectors.toList()
It converts the elements of the stream into a list.
Collectors.groupingBy()
It groups the elements by a given key and organizes them into a Map.
first letter, fields
Use:
```java
Map<Character, List<String>> grouping = names.stream()
        .collect(Collectors.groupingBy(n -> n.charAt(0)));
```  

# Collectors.partitioningBy()
It splits the elements into two groups based on a boolean condition.
Use:
```java
List<Integer> numbers = List.of(1,2,3,4,5,6);
Map<Boolean, List<Integer>> evenOdd = numbers.stream()
        .collect(Collectors.partitioningBy(n -> n % 2 == 0));
```  

# Collectors.joining()
It concatenates the textual elements of the stream into a single String using a specified delimiter.
Use:
```java
String concatenation = names.stream()
        .collect(Collectors.joining(", "));
```  

# parallel()
It enables parallel processing of the stream. This can improve performance when working with large amounts of data.
Use:
```java
int parallelSum = IntStream.rangeClosed(1, 1_000_000)
        .parallel()
        .reduce(0, Integer::sum);
```  