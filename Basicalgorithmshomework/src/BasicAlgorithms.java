
public class BasicAlgorithms {
    public static void main(String[] args) {

        int[] numbers = {1, 1, 1, 1, 1, 1, 1, 1,};
        int largestElement = numbers[0];
        for (int number : numbers) {     // Java offered the for each loop
            if (largestElement < number) {
                largestElement = number;
            }
        }
        System.out.println("The largest element is: " + largestElement);

        int smallestElement = numbers[0];
        for (int number : numbers) {     // Java offered the for each loop
            if (number < smallestElement) {
                smallestElement = number;
            }
        }
        System.out.println("The smallest element is: " + smallestElement);

        int grater = 0;
        for (int number : numbers) {     // Java offered the for each loop
            if (100 < number) {
                grater++;
            }
        }
        System.out.println("The number of elements what is greater than 100:  " + grater);

        int between = 0;
        for (int number : numbers) {     // Java offered the for each loop
            if (number > -50 && number < 78) {
                between++;
            }
        }
        System.out.println("The number of elements what is between -50 and 78:  " + between);

        int divisibleByTwo = 0;
        for (int number : numbers) {     // Java offered the for each loop
            if (number % 2 == 0) {
                divisibleByTwo++;
            }
        }
        System.out.println("The number of elements what is divisible by 2:  " + divisibleByTwo);

        int divisibleByThree = 0;
        for (int number : numbers) {     // Java offered the for each loop
            if (number % 3 == 0) {
                divisibleByThree++;
            }
        }
        System.out.println("The number of elements what is divisible by 3:  " + divisibleByThree);

        int foundSeventyThree = 0;
        for (int number : numbers) {     // Java offered the for each loop
            if (number == 73) {
                foundSeventyThree++;
            }
        }
        System.out.println("The number of 73: " + foundSeventyThree);

        boolean checkHundred = false;
        for (int number : numbers) {     // Java offered the for each loop
            if (number == 100) {
                checkHundred = true;
                break;
            }
        }
        System.out.println("There is 100 in the array?: " + checkHundred);

        boolean isThereMoreThanHundred = false;
        for (int number : numbers) {     // Java offered the for each loop
            if (number > 100) {
                isThereMoreThanHundred = true;
                break;    // Java offered the "break;" but if I want to be honest I should have known that I "have" to put it after I know it's true.
            }
        }
        System.out.println("There is a number greater than 100?: " + isThereMoreThanHundred);

        boolean isFound = false;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 7) {
                System.out.println("The index of the first 7 in the array: " + i);
                isFound = true;
            }
        }
        if (!isFound) {
            System.out.println(-1);
        }

        int sum = 0;
        for (int number : numbers) {     // Java offered the for each loop
            sum += number;
        }
        System.out.println("The sum of the elements in the array is: " + sum);

        int prod = 1;
        for (int number : numbers) {     // Java offered the for each loop
            prod *= number;
        }
        System.out.println("The product of the elements in the array is: " + prod);

        int followingSum = 0;
        for (int i = 0; i < numbers.length; i++) {
            //  0  1  2  3
            //  +  +  +  -
            // +1 +2 +3 -4  ------> 3
            // Can you explain why "if (i % 3 == 0 && i != 0)" was it not good? The pattern was the same and the final result as well. (I think)
            if (i % 4 == 0) {
                followingSum -= numbers[i];
            } else {
                followingSum += numbers[i];
            }
        }
        System.out.println("The pattern sum is: " + followingSum);
    }
}