package tdd2;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class IteratorCircularList implements CircularList {

    private List<Integer> list = new ArrayList<>();

    @Override
    public void add(int element) {
        this.list.add(element);
    }

    @Override
    public int size() {
        return this.list.size();
    }

    @Override
    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    @Override
    public Iterator<Integer> forwardIterator() {
        return new CircularIterator(this.list, false);
    }

    @Override
    public Iterator<Integer> backwardIterator() {
        return new CircularIterator(this.list, true);
    }

}
