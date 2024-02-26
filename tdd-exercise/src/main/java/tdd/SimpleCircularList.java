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
        if (this.isEmpty()) {
            return Optional.empty();
        }
        int element = this.list.get(this.list.get(this.currentPosition));
        this.currentPosition = this.currentPosition + 1 == this.list.size() ? 0 : this.currentPosition + 1;
        return Optional.of(element);
    }

    @Override
    public Optional<Integer> previous() {
        if (this.isEmpty()) {
            return Optional.empty();
        }
        this.currentPosition = this.currentPosition - 1 >= 0 ? this.currentPosition - 1 : this.list.size() - 1;
        return Optional.of(this.list.get(this.currentPosition));
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
