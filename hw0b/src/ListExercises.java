import java.util.ArrayList;
import java.util.List;

public class ListExercises {

    /** Returns the total sum in a list of integers */
	public static int sum(List<Integer> L) {
        int sum=0;
        int num=L.size();
        for (int i=0;i<num;i++)
        {
            sum+=L.get(i);
        }
        return sum;
    }

    /** Returns a list containing the even numbers of the given list */
    public static List<Integer> evens(List<Integer> L) {
        List<Integer> out=new ArrayList<>();
        int num=L.size();
        for(int i=0;i<num;i++) if((L.get(i))%2==0) out.add(L.get(i));
        return out;
    }

    /** Returns a list containing the common item of the two given lists */
    public static List<Integer> common(List<Integer> L1, List<Integer> L2) {
        List<Integer> out= new ArrayList<>();
        int num1= L1.size();
        int num2= L2.size();
        for(int i=0;i<num1;i++)
        {
            for(int j=0;j<num2;j++) if(L1.get(i)==L2.get(j)) out.add(L1.get(i));
        }
        return out;
    }


    /** Returns the number of occurrences of the given character in a list of strings. */
    public static int countOccurrencesOfC(List<String> words, char c) {
        int sum=0;
        int num= words.size();
        for(int i=0;i<num;i++)
        {
            int len=words.get(i).length();
            for(int j=0;j<len;j++) if(c==words.get(i).charAt(j))sum++;
        }

        return sum;
    }
}
