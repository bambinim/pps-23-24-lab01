package tdd2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CircularIteratorTest {

    private List<Integer> list;

    @BeforeEach
    void beforeEach() {
        this.list = new ArrayList<>();
    }

    @Test
    void testEmptyListIterator() {
        var iterator = new CircularIterator(this.list, false);
        assertAll(
            () -> assertFalse(iterator.hasNext()),
            () -> assertThrows(NoSuchElementException.class, () -> iterator.next())
        );
    }

    @Test
    void testForwardIterator() {
        this.list.add(0);
        this.list.add(1);
        this.list.add(2);
        var iterator = new CircularIterator(this.list, false);
        assertAll(
            () -> assertEquals(0, iterator.next()),
            () -> assertEquals(1, iterator.next()),
            () -> assertEquals(2, iterator.next())
        );
    }

    @Test
    void testBackwardIterator() {
        this.list.add(0);
        this.list.add(1);
        this.list.add(2);
        var iterator = new CircularIterator(this.list, true);
        assertAll(
            () -> assertEquals(2, iterator.next()),
            () -> assertEquals(1, iterator.next()),
            () -> assertEquals(0, iterator.next())
        );
    }

    @Test
    void testForwardCircularity() {
        this.list.add(0);
        this.list.add(1);
        var iterator = new CircularIterator(this.list, false);
        iterator.next();
        iterator.next();
        assertEquals(0, iterator.next());
    }

    @Test
    void testBackwardCircularity() {
        this.list.add(0);
        this.list.add(1);
        var iterator = new CircularIterator(this.list, true);
        assertEquals(1, iterator.next());
    }
}
