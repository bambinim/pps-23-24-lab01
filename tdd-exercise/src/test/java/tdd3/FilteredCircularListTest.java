package tdd3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FilteredCircularListTest {

    CircularList list;

    @BeforeEach
    void beforeEach() {
        this.list = new FilteredCircularList();
    }

    @Test
    void testNextElementFromBeginningOfList() {
        this.list.add(0);
        this.list.add(1);
        this.list.add(2);
        assertEquals(Optional.of(1), this.list.filteredNext((x) -> x > 0));
    }

    @Test
    void testPredicateWithoutMatch() {
        this.list.add(0);
        this.list.add(1);
        this.list.add(2);
        assertTrue(this.list.filteredNext((x) -> x > 2).isEmpty());
    }

    @Test
    void testCircularity() {
        this.list.add(0);
        this.list.add(1);
        this.list.add(2);
        this.list.next();
        this.list.next();
        assertEquals(0, this.list.filteredNext((x) -> x == 0).get());
    }

    @Test
    void testEmptyList() {
        assertTrue(this.list.filteredNext((x) -> x == 0).isEmpty());
    }
}
