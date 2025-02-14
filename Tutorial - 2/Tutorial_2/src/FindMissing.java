import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class FindMissing {

    /*
     * Find the smallest missing nonnegative value
     */
    public static int findMissing(ArrayList<Integer> numbers) {
        for(int i=0;i<numbers.size();i++){
            if(!numbers.contains(i))
                return i;
        }
        return -1;  // Dummy value
    }

    public static int findMissingSorted(ArrayList<Integer> numbers) {
        if(numbers.get(0)>0)
            return 0;
        for(int i=1;i< numbers.size();i++)
            if(numbers.get(i)- numbers.get(i-1)>1)//gap found
                return numbers.get(i-1)+1;
        //no gap found, then missing value in last value
        return numbers.get(numbers.size()-1)+1;
    }

    public static ArrayList<Integer> createInput(int size, boolean shuffle) {
        ArrayList<Integer> result = new ArrayList<>(size);
        for (int i = 0; i < size; i++)
            result.add(i);
        if (shuffle)
            Collections.shuffle(result);
        //randomly remove one element to create a missing value
        int indexNum=7;
        result.remove(indexNum);
        return result;
    }

    /*
     * @param args the command line arguments
     */

}