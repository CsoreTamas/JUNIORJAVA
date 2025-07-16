import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EightTaskTest {
    @Test
    void shouldAddTheFirstElementToTheList() {
        EighthTask list = new EighthTask();
        assertTrue(list.add("hello"));
    }

    @Test
    void shouldAppendAnElementToTheEndOfTheList() {
        EighthTask list = new EighthTask();
        list.add("first");
        list.add("second");
        list.add("third");
        list.add("forth");
        list.add("fifth");
        list.add("sixth");
        assertTrue(list.add("last"));
    }

    @Test
    void shouldGetTheFirstElementOfTheList() {
        EighthTask list = new EighthTask();
        list.add("hello");
        assertEquals("hello", list.get(0));
    }

    @Test
    void shouldGetTheLastElementOfTheList() {
        EighthTask list = new EighthTask();
        list.add("first");
        list.add("second");
        list.add("third");
        list.add("forth");
        list.add("fifth");
        list.add("sixth");
        list.add("last");
        assertEquals("last", list.get(6));
    }

    @Test
    void shouldContainsLast() {
        EighthTask list = new EighthTask();
        list.add("first");
        list.add("second");
        list.add("third");
        list.add("forth");
        list.add("fifth");
        list.add("sixth");
        assertTrue(list.contains("sixth"));
    }

    @Test
    void shouldContainsFirst() {
        EighthTask list = new EighthTask();
        list.add("first");
        list.add("second");
        list.add("third");
        list.add("forth");
        list.add("fifth");
        list.add("sixth");
        assertTrue(list.contains("first"));
    }

    @Test
    void shouldNotContains() {
        EighthTask list = new EighthTask();
        list.add("first");
        list.add("second");
        list.add("third");
        list.add("forth");
        list.add("fifth");
        list.add("sixth");
        assertFalse(list.contains("that doesn't exist"));
    }

    @Test
    void shouldNotRemoveAnyElementEmptyList() {
        EighthTask list = new EighthTask();
        assertFalse(list.remove("idk"));
    }

    @Test
    void shouldDeleteTheFirstElement() {
        EighthTask list = new EighthTask();
        list.add("idk");
        assertTrue(list.remove("idk"));
    }

    @Test
    void shouldDeleteAnElement() {
        EighthTask list = new EighthTask();
        list.add("first");
        list.add("second");
        list.add("third");
        list.add("forth");
        list.add("fifth");
        list.add("sixth");
        assertTrue(list.remove("fifth"));
        assertEquals("sixth", list.get(4));
    }

    @Test
    void shouldGetTheListSize() {
        EighthTask list = new EighthTask();
        list.add("first");
        list.add("second");
        list.add("third");
        list.add("forth");
        list.add("fifth");
        list.add("sixth");
        list.add("last");
        assertEquals(7, list.size());
    }

    @Test
    void shouldNotClearCauseEmpty() {
        EighthTask list = new EighthTask();
        assertFalse(list.clear());
    }

    @Test
    void shouldClearAllList() {
        EighthTask list = new EighthTask();
        list.add("first");
        list.add("second");
        list.add("third");
        list.add("forth");
        list.add("fifth");
        list.add("sixth");
        list.add("last");
        assertEquals(7, list.size());
        assertTrue(list.clear());
        assertEquals(0, list.size());
    }

    @Test
    void shouldGetIsNotEmpty() {
        EighthTask list = new EighthTask();
        list.add("first");
        list.add("second");
        list.add("third");
        list.add("forth");
        list.add("fifth");
        list.add("sixth");
        list.add("last");
        assertFalse(list.isEmpty());
    }

    @Test
    void shouldGetIsEmpty() {
        EighthTask list = new EighthTask();
        assertTrue(list.isEmpty());
    }
}
