import java.util.ArrayList;
import java.util.List;
import java.lang.Math;

public class ArrayDeque61B<T> implements Deque61B<T>{

    private int size;
    private int nextLast;
    private int nextFirst;
    private T[] items;
    private int volume;

    public ArrayDeque61B(){
        size = 0;
        nextLast = 1;
        nextFirst = 0;
        items = (T[]) new Object[8];
        volume = 8;
    }

    private void resizingUp(){
        T[] newItems = (T[]) new Object[2 * volume];
        int count = 0;
        for(int i = nextFirst + 1; Math.floorMod(i, volume) != nextLast; i++)
        {
            newItems[count] = items[Math.floorMod(i, volume)];
            count++;
        }
        items = newItems;
        volume = 2 * volume;
        nextFirst = volume - 1;
        nextLast = count;
    }

    private void resizingDown(){
        T[] newItems = (T[]) new Object[volume / 2];
        int count = 0;
        for(int i = nextFirst + 1; Math.floorMod(i, volume) != nextLast; i++)
        {
            newItems[count] = items[Math.floorMod(i, volume)];
            count++;
        }
        items = newItems;
        volume = volume / 2;
        nextFirst = volume - 1;
        nextLast = count;
    }

    @Override
    public void addFirst(T x) {
        items[nextFirst] = x;
        nextFirst = Math.floorMod(nextFirst - 1, volume);
        size++;
        if(size >= volume) resizingUp();
    }

    @Override
    public void addLast(T x) {
        items[nextLast] = x;
        nextLast = Math.floorMod(nextLast + 1, volume);
        size++;
        if(size >= volume) resizingUp();
    }

    @Override
    public List<T> toList() {
        List<T> returnList = new ArrayList<>();
        for(int i = 1; i <= size; i++){
            returnList.add(items[Math.floorMod(nextFirst + i, volume)]);
        }
        return returnList;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T removeFirst() {
        int thisFirst = Math.floorMod(nextFirst + 1, volume);
        T x = items[thisFirst];
        nextFirst = thisFirst;
        size--;
        if(size <= volume/2) resizingDown();
        return x;
    }

    @Override
    public T removeLast() {
        int thisLast = Math.floorMod(nextLast - 1, volume);
        T x = items[thisLast];
        nextLast = thisLast;
        size--;
        if(size <= volume/2) resizingDown();
        return x;
    }

    @Override
    public T get(int index) {
        if((index < 0 )||(index >= size)) return null;
        return items[nextFirst + index +1];
    }

    @Override
    public T getRecursive(int index) {
        throw new UnsupportedOperationException("No need to implement getRecursive for proj 1b");
    }

}
