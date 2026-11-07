import java.util.List;
import java.lang.Math;

public class ArrayDeque61B<T> implements Deque61B<T>{

    int size;
    int nextLast;
    int nextFirst;
    T[] items;
    int volume;

    public ArrayDeque61B(){
        size = 0;
        nextLast = 1;
        nextFirst = 0;
        items = (T[]) new Object[8];
        volume = 8;
    }

    public void resizingUp(){
        
    }

    @Override
    public void addFirst(T x) {
        items[nextFirst] = x;
        nextFirst = Math.floorMod(nextFirst - 1, volume);
        size++;
    }

    @Override
    public void addLast(T x) {
        items[nextLast] = x;
        nextLast = Math.floorMod(nextLast - 1, volume);
        size++;
    }

    @Override
    public List<T> toList() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toList'");
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isEmpty'");
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T removeFirst() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeFirst'");
    }

    @Override
    public T removeLast() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeLast'");
    }

    @Override
    public T get(int index) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public T getRecursive(int index) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getRecursive'");
    }

}
