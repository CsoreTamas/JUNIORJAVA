import org.junit.jupiter.api.Test;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class TasksTest {
    @Test
    void shouldGetIntersectionOfTwoLists() {
        List<Integer> expected = List.of(4, 5, 6);
        List<Integer> firstList = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> secondList = List.of(4, 5, 6, 7, 8, 9, 10);

        assertEquals(expected, FirstTask.getIntersection(firstList, secondList));
    }

    @Test
    void shouldGetAListWithReversedWords() {
        List<String> words = List.of("hello", "geza", "idk", "");
        List<String> expected = List.of("olleh", "azeg", "kdi", "");

        assertEquals(expected, SecondTask.getReversedList(words));
    }

    @Test
    void shouldGetEveryPalindromeWord() {
        List<String> words = List.of("hello", "level", "geza", "racecar", "idk", "madam", " ");
        List<String> expected = List.of("level", "racecar", "madam", " ");

        assertEquals(expected, ThirdTask.getPalindromes(words));
    }

    @Test
    void shouldCountTheUniqueLetters() {
        String actual = "qwertzuiopq";
        assertEquals(10, ForthTask.countUniqueChars(actual));
    }

    @Test
    void shouldReturnTrueWhenListContainsDuplicates() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 9);
        assertTrue(FifthTask.hasDuplicates(numbers));
    }

    @Test
    void shouldReturnFalseWhenListContainsOnlyUniqueNumbers() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        assertFalse(FifthTask.hasDuplicates(numbers));
    }

    @Test
    void shouldReturn1CauseTheFirstListContainsMoreUniqueElement() {
        List<Integer> firstList = List.of(1, 2, 3, 4, 5, 6, 7, 7, 8);
        List<Integer> secondList = List.of(1, 1, 2, 3, 4, 5, 6, 7, 7);
        assertEquals(1, SixthTask.elementComparator(firstList, secondList));
    }

    @Test
    void shouldReturn2CauseTheSecondListContainsMoreUniqueElement() {
        List<Integer> firstList = List.of(1, 1, 2, 3, 4, 5, 6, 7, 7);
        List<Integer> secondList = List.of(1, 1, 2, 3, 4, 5, 6, 7, 8);
        assertEquals(2, SixthTask.elementComparator(firstList, secondList));
    }

    @Test
    void shouldReturn0CauseTheTwoListContainsSameAmountUniqueElement() {
        List<Integer> firstList = List.of(1, 2, 3, 4, 4, 5, 6, 7, 7);
        List<Integer> secondList = List.of(1, 1, 2, 3, 4, 5, 6, 7);
        assertEquals(0, SixthTask.elementComparator(firstList, secondList));
    }

    @Test
    void shouldAddNewEmailToTheList() {
        Set<String> emails = new LinkedHashSet<>();
        SeventhTask seventhTask = new SeventhTask(emails);
        String email = "idk@idk.com";

        assertTrue(seventhTask.addEmail(email));
    }

    @Test
    void shouldNotAddNewEmail() {
        Set<String> emails = new LinkedHashSet<>();
        SeventhTask seventhTask = new SeventhTask(emails);
        String email = "idk@idk.com";
        seventhTask.addEmail(email);

        assertFalse(seventhTask.addEmail("idk@idk.com"));
    }

    @Test
    void shouldNotUpdateAnOldEmailCauseItsDoNotExist() {
        Set<String> emails = new LinkedHashSet<>();
        SeventhTask seventhTask = new SeventhTask(emails);
        String email = "idk@idk.com";
        seventhTask.addEmail(email);

        assertFalse(seventhTask.updateEmail("idk@idk.hu", "idk@idk.com"));
    }

    @Test
    void shouldNotUpdateAnOldEmailCauseTheNewAlreadyExist() {
        Set<String> emails = new LinkedHashSet<>();
        SeventhTask seventhTask = new SeventhTask(emails);
        String alreadyExistEmail = "idk@idk.com";
        seventhTask.addEmail(alreadyExistEmail);
        String modifierEmail = "modifieremail@email.hu";
        seventhTask.addEmail(modifierEmail);

        assertFalse(seventhTask.updateEmail(modifierEmail, alreadyExistEmail));
    }

    @Test
    void shouldUpdateAnEmail() {
        Set<String> emails = new LinkedHashSet<>();
        SeventhTask seventhTask = new SeventhTask(emails);
        String newEmail = "idk@idk.com";
        String modifierEmail = "modifieremail@email.hu";
        seventhTask.addEmail(modifierEmail);

        assertTrue(seventhTask.updateEmail(modifierEmail, newEmail));
    }

    @Test
    void shouldDeleteAnEmail() {
        Set<String> emails = new LinkedHashSet<>();
        SeventhTask seventhTask = new SeventhTask(emails);
        String newEmail = "idk@idk.com";
        seventhTask.addEmail(newEmail);
        String modifierEmail = "modifieremail@email.hu";
        seventhTask.addEmail(modifierEmail);

        assertTrue(seventhTask.deleteEmail(newEmail));
    }

    @Test
    void shouldNotDeleteAnEmailCauseDoesNotExist() {
        Set<String> emails = new LinkedHashSet<>();
        SeventhTask seventhTask = new SeventhTask(emails);
        String modifierEmail = "modifieremail@email.hu";
        seventhTask.addEmail(modifierEmail);

        assertFalse(seventhTask.deleteEmail("idk@idk.com"));
    }
}
