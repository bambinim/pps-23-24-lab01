package tdd2;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class CircularIterator implements Iterator<Integer> {

    private final List<Integer> list;
    private final boolean iterateBackwards;
    private int currentPosition = 0;

    public CircularIterator(final List<Integer> sourceList, final boolean iterateBackwards) {
        this.list = sourceList;
        this.iterateBackwards = iterateBackwards;
    }

    @Override
    public boolean hasNext() {
        return !list.isEmpty();
    }

    @Override
    public Integer next() {
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }

        return this.iterateBackwards ? this.nextBackwardElement() : this.nextForwardElement();
    }

    private Integer nextForwardElement() {
        int element = this.list.get(this.currentPosition);
        this.currentPosition = this.currentPosition + 1 == this.list.size() ? 0 : this.currentPosition + 1;
        return element;
    }

    private Integer nextBackwardElement() {
        this.currentPosition = this.currentPosition - 1 < 0 ? this.list.size() - 1 : this.currentPosition - 1;
        return this.list.get(this.currentPosition);
    }

}
