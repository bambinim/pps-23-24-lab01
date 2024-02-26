package tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SimpleCircularList implements CircularList {

    private int currentPosition = 0;
    private List<Integer> list = new ArrayList<>();

    @Override
    public void add(int element) {
        this.list.add(element);
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public Optional<Integer> next() {
        return Optional.of(this.list.get(this.currentPosition++));
    }

    @Override
    public Optional<Integer> previous() {
        return Optional.of(this.list.get(--this.currentPosition));
    }

    @Override
    public void reset() {
        this.currentPosition = 0;
    }

    @Override
    public int size() {
        return this.list.size();
    }
    
}
