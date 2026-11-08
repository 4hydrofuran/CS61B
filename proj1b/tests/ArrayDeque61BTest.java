import jh61b.utils.Reflection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;

public class ArrayDeque61BTest {

//     @Test
//     @DisplayName("ArrayDeque61B has no fields besides backing array and primitives")
//     void noNonTrivialFields() {
//         List<Field> badFields = Reflection.getFields(ArrayDeque61B.class)
//                 .filter(f -> !(f.getType().isPrimitive() || f.getType().equals(Object[].class) || f.isSynthetic()))
//                 .toList();
//
//         assertWithMessage("Found fields that are not array or primitives").that(badFields).isEmpty();
//     }
    
    @Test
    public void addFirstTest(){
        Deque61B<Integer> ad1 = new ArrayDeque61B<>();
        assertThat(ad1.size()).isEqualTo(0);
        ad1.addFirst(6);
        ad1.addFirst(5);
        ad1.addFirst(4);
        ad1.addFirst(3);
        assertThat(ad1.size()).isEqualTo(4);
        assertThat(ad1.toList()).containsExactly(3,4,5,6).inOrder();
        ad1.addFirst(6);
        ad1.addFirst(5);
        ad1.addFirst(4);
        ad1.addFirst(3);
        ad1.addFirst(2);
        assertThat(ad1.size()).isEqualTo(9);
        assertThat(ad1.toList()).containsExactly(2,3,4,5,6,3,4,5,6).inOrder();
    
    }
    
    @Test
    public void addLastTest(){
        Deque61B<Integer> ad1 = new ArrayDeque61B<>();
        assertThat(ad1.size()).isEqualTo(0);
        ad1.addLast(6);
        ad1.addLast(5);
        ad1.addLast(4);
        ad1.addLast(3);
        assertThat(ad1.size()).isEqualTo(4);
        assertThat(ad1.toList()).containsExactly(6,5,4,3).inOrder();
        ad1.addLast(6);
        ad1.addLast(5);
        ad1.addLast(4);
        ad1.addLast(3);
        ad1.addLast(2);
        assertThat(ad1.size()).isEqualTo(9);
        assertThat(ad1.toList()).containsExactly(6,5,4,3,6,5,4,3,2).inOrder();
    }
        
    @Test 
    public void removeFirstTest(){
        Deque61B<Integer> ad1 = new ArrayDeque61B<>();
        ad1.addFirst(6);
        ad1.addFirst(5);
        ad1.addFirst(4);
        ad1.addFirst(3);
        ad1.addFirst(6);
        ad1.addFirst(5);
        ad1.addFirst(4);
        ad1.addFirst(3);
        ad1.addFirst(2);
        assertThat(ad1.toList()).containsExactly(2,3,4,5,6,3,4,5,6).inOrder();
        assertThat(ad1.removeFirst()).isEqualTo(2);
        assertThat(ad1.size()).isEqualTo(8);
        for(int i = 8; i > 2; i--){
            ad1.removeFirst();
        }
        assertThat(ad1.size()).isEqualTo(2);
        assertThat(ad1.removeFirst()).isEqualTo(5);
        assertThat(ad1.removeFirst()).isEqualTo(6);
        assertThat(ad1.size()).isEqualTo(0);
        assertThat(ad1.removeFirst()).isNull();
        assertThat(ad1.size()).isEqualTo(0);
    }

    @Test 
    public void removeLastTest(){
        Deque61B<Integer> ad1 = new ArrayDeque61B<>();
        ad1.addLast(6);
        ad1.addLast(5);
        ad1.addLast(4);
        ad1.addLast(3);
        ad1.addLast(6);
        ad1.addLast(5);
        ad1.addLast(4);
        ad1.addLast(3);
        ad1.addLast(2);
        assertThat(ad1.toList()).containsExactly(6,5,4,3,6,5,4,3,2).inOrder();
        assertThat(ad1.removeLast()).isEqualTo(2);
        assertThat(ad1.size()).isEqualTo(8);
       
        for(int i = 8; i > 2; i--){
            ad1.removeLast();
        }
        assertThat(ad1.size()).isEqualTo(2);
        assertThat(ad1.removeLast()).isEqualTo(5);
        assertThat(ad1.removeLast()).isEqualTo(6);
        assertThat(ad1.size()).isEqualTo(0);
        assertThat(ad1.removeLast()).isNull();
        assertThat(ad1.size()).isEqualTo(0);
    }

    @Test 
    public void getTest(){
        Deque61B<Integer> ad1 = new ArrayDeque61B<>();
        ad1.addFirst(6);
        ad1.addFirst(5);
        ad1.addFirst(4);
        ad1.addFirst(3);
        assertThat(ad1.get(0)).isEqualTo(3);
        assertThat(ad1.get(541542465)).isNull();
        assertThat(ad1.get(-54)).isNull();
    }

    @Test 
    public void isEmptyTest(){
        Deque61B<Integer> ad1 = new ArrayDeque61B<>();
        assertThat(ad1.isEmpty()).isTrue();
        ad1.addFirst(6);
        assertThat(ad1.isEmpty()).isFalse();
    }

    @Test 
    public void toListTest(){
        Deque61B<Integer> ad1 = new ArrayDeque61B<>();
        assertThat(ad1.toList()).isNull();
        ad1.addFirst(1);
        ad1.addLast(2);
        assertThat(ad1.toList()).containsExactly(1,2).inOrder();
    }
}
