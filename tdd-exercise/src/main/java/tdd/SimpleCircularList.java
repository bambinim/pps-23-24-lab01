package tdd;

import java.util.Optional;

public class SimpleCircularList implements CircularList {

    @Override
    public void add(int element) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public Optional<Integer> next() {
        return Optional.of(0);
    }

    @Override
    public Optional<Integer> previous() {
        return Optional.of(0);
    }

    @Override
    public void reset() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return 0;
    }
    
}
