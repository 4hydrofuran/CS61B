import java.util.List;
import java.util.ArrayList; // import the ArrayList class

public class LinkedListDeque61B<T> implements Deque61B<T>{

    Node sentinal;
    int size;

    public LinkedListDeque61B(){
        sentinal = new Node();
        size = 0;
    }

    private class Node{
        T index;
        Node head;
        Node tail;

        Node(T input, Node head, Node tail){
            this.head = head;
            this.tail = tail;
            index = input;
        }
        Node(){
            head = this;
            tail = this;
            index = null;
        }
    }

    @Override
    public void addFirst(T x) {
        Node newNode = new Node(x, sentinal, sentinal.tail);
        sentinal.tail.head = newNode;
        sentinal.tail = newNode;
        size++;
    }

    @Override
    public void addLast(T x) {
        Node newNode = new Node(x, sentinal.head, sentinal);
        sentinal.head.tail = newNode;
        sentinal.head = newNode;
        size++;
    }

    @Override
    public List<T> toList() {
        List<T> data = new ArrayList<>();
        Node temp = sentinal.tail;
        for(int i =0; i<size; i++){
            data.add(temp.index);
            temp = temp.tail;
        }
        return data;
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isEmpty'");
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'size'");
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
