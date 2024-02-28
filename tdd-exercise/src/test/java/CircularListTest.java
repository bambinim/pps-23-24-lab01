import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tdd.CircularList;
import tdd.SimpleCircularList;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    private CircularList list;

    @BeforeEach
    void beforeEach() {
        this.list = new SimpleCircularList();
    }

    @Test
    void testInitiallyEmpty() {
        assertTrue(list.isEmpty());
    }

    @Test
    void testAddAndNext() {
        this.list.add(0);
        assertEquals(0, this.list.next().get());
    }

    @Test
    void testPrevious() {
        this.list.add(0);
        this.list.add(1);
        this.list.next();
        assertEquals(0, this.list.previous().get());
    }


    @Test
    void testMultipleAddsAndNexts() {
        this.list.add(0);
        this.list.add(1);
        this.list.add(2);
        assertAll(
            () -> assertEquals(0, this.list.next().get()),
            () -> assertEquals(1, this.list.next().get()),
            () -> assertEquals(2, this.list.next().get())
        );        
    }

    @Test
    void testSize() {
        this.list.add(0);
        this.list.add(1);
        assertEquals(2, this.list.size());
    }

    @Test
    void testNonEmpty() {
        this.list.add(0);
        assertFalse(this.list.isEmpty());
    }

    @Test
    public void testReset() {
        this.list.add(0);
        this.list.add(1);
        this.list.add(2);
        this.list.next();
        this.list.next();
        this.list.reset();
        assertEquals(0, this.list.next().get());
    }

    @Test
    void testNextCircularity() {
        this.list.add(0);
        this.list.add(1);
        this.list.next();
        this.list.next();
        assertEquals(0, this.list.next().get());
    }

    @Test
    void testPreviousOnFirstElement() {
        this.list.add(0);
        this.list.add(1);
        assertEquals(1, this.list.previous().get());
    }

    @Test
    void testNextAndPreviousOnEmptyList() {
        assertAll(
            () -> assertTrue(this.list.next().isEmpty()),
            () -> assertTrue(this.list.previous().isEmpty())
        );
    }

}
