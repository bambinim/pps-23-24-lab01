package tdd3;

import java.util.Optional;
import java.util.function.Predicate;
import tdd.SimpleCircularList;

public class FilteredCircularList extends SimpleCircularList implements CircularList {

    @Override
    public Optional<Integer> filteredNext(Predicate<? super Integer> predicate) {
        int numberOfNextCalls = 0;
        while (numberOfNextCalls < this.size()) {
            var nextValue = this.next();
            if (predicate.test(nextValue.get())) {
                return nextValue;
            }
            numberOfNextCalls += 1;
        }
        return Optional.empty();
    }

}
