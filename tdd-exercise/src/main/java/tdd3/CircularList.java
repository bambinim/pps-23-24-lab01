package tdd3;

import java.util.Optional;
import java.util.function.Predicate;

public interface CircularList extends tdd.CircularList {

    public Optional<Integer> filteredNext(final Predicate<? super Integer> predicate);

}
