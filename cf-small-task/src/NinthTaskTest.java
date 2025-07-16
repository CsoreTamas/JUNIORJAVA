import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NinthTaskTest {
    @Test
    void shouldAddTheFirstElementToTheList() {
        NinthTask list = new NinthTask();
        assertTrue(list.add("hello"));
    }

    @Test
    void shouldAppendAnElementToTheEndOfTheList() {
        NinthTask list = new NinthTask();
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
        NinthTask list = new NinthTask();
        list.add("hello");
        assertEquals("hello", list.get(0));
    }

    @Test
    void shouldGetTheLastElementOfTheList() {
        NinthTask list = new NinthTask();
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
        NinthTask list = new NinthTask();
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
        NinthTask list = new NinthTask();
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
        NinthTask list = new NinthTask();
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
        NinthTask list = new NinthTask();
        assertFalse(list.remove("idk"));
    }

    @Test
    void shouldDeleteTheFirstElement() {
        NinthTask list = new NinthTask();
        list.add("idk");
        assertTrue(list.remove("idk"));
    }

    @Test
    void shouldDeleteAnElement() {
        NinthTask list = new NinthTask();
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
        NinthTask list = new NinthTask();
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
        NinthTask list = new NinthTask();
        assertFalse(list.clear());
    }

    @Test
    void shouldClearAllList() {
        NinthTask list = new NinthTask();
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
        NinthTask list = new NinthTask();
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
        NinthTask list = new NinthTask();
        assertTrue(list.isEmpty());
    }
}

