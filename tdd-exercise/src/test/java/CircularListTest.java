import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
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
        assertEquals(this.list.next(), Optional.of(0));
    }

    @Test
    void testPrevious() {
        this.list.add(0);
        this.list.add(1);
        this.list.next();
        assertEquals(this.list.previous(), Optional.of(0));
    }


    @Test
    void testMultipleAddsAndNexts() {
        this.list.add(0);
        this.list.add(1);
        this.list.add(2);
        assertAll(
            () -> assertEquals(this.list.next(), Optional.of(0)),
            () -> assertEquals(this.list.next(), Optional.of(1)),
            () -> assertEquals(this.list.next(), Optional.of(2))
        );        
    }

}
