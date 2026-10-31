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
        T value;
        Node head;
        Node tail;

        Node(T input, Node head, Node tail){
            this.head = head;
            this.tail = tail;
            value = input;
        }
        Node(){
            head = this;
            tail = this;
            value = null;
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
            data.add(temp.value);
            temp = temp.tail;
        }
        return data;
    }

    @Override
    public boolean isEmpty() {
        return (size == 0) ? true : false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T removeFirst() {
        T temp = sentinal.tail.value;
        sentinal.tail = sentinal.tail.tail;
        sentinal.tail.head = sentinal;
        if(size != 0) size -= 1;
        return temp;
    }

    @Override
    public T removeLast() {
        T temp = sentinal.head.value;
        sentinal.head = sentinal.head.head;
        sentinal.head.tail = sentinal;
        if(size != 0) size -= 1;
        return temp;
    }

    @Override
    public T get(int index) {
        if(!(index < size()&&index >= 0)) return null;
        List<T> tempList = toList();
        return tempList.get(index);

    }

    @Override
    public T getRecursive(int index) {
        if(!(index < size()&&index >= 0)) return null;
        Node temp = sentinal;
        return getRecursiveHelper(temp, index);
    }

    private T getRecursiveHelper(Node p, int num){
        if(num > 0){
            p = p.tail;
            return getRecursiveHelper(p, num-1);
        }
        return p.tail.value;
    }


}
