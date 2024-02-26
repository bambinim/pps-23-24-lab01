package tdd2;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CircularListTest {

    private CircularList list;

    @BeforeEach
    void beforeEach() {
        this.list = new IteratorCircularList();
    }

    @Test
    void testEmpty() {
        assertTrue(this.list.isEmpty());
    }

    @Test
    void testAddAndSize() {
        this.list.add(0);
        this.list.add(1);
        assertEquals(2, this.list.size());
    }

    @Test
    void testNonEmpty() {
        this.list.add(0);
        this.list.add(1);
        assertFalse(this.list.isEmpty());
    }

    @Test
    void testForwardIterator() {
        this.list.add(0);
        this.list.add(1);
        var iterator = this.list.forwardIterator();
        assertAll(
            () -> assertEquals(0, iterator.next()),
            () -> assertEquals(1, iterator.next()),
            () -> assertEquals(0, iterator.next())
        );
    }

    @Test
    void testBackwardIterator() {
        this.list.add(0);
        this.list.add(1);
        var iterator = this.list.backwardIterator();
        assertAll(
            () -> assertEquals(1, iterator.next()),
            () -> assertEquals(0, iterator.next()),
            () -> assertEquals(1, iterator.next())
        );
    }
}
