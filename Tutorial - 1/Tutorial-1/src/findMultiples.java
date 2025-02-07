import java.util.ArrayList;
import java.util.Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 *
 * @author klaus
 */
public class findMultiples {

    /*
     *Find an index where a value in the array occurs for the second time
     * Returns -1 if no such index exists
     */
    public static int findDuplicate(ArrayList<Integer> numbers){
        for(int i = 0; i < numbers.size(); i++)
            for(int j = 0; j < i; j++)
                if(numbers.get(i) == numbers.get(j))
                    return i;
        return -1;  // Failure case
    }

    /*
     * Find an index where a value in the array occurs for the third time
     * Returns -1 if no such index exists
     */
    public static int findTriplicate(ArrayList<Integer> numbers) {

//        for(int i=0;i< numbers.size();i++)
//            for (int j = 0; j < i; j++)
//                for(int k=0; k<j;k++)
//                    if (numbers.get(i) == numbers.get(j)&& numbers.get(i) == numbers.get(k))
//                        return i;
//        return -1;  // Failure case

        for (int i = 0; i < numbers.size(); i++) {
            int count = 1;
            for (int j = 0; j < i; j++) {
                if (numbers.get(i) == numbers.get(j)) {
                    count++;
                }
                if (count == 2) {
                    return i;
                }
            }

        }
        return  -1;

    }

    public static ArrayList<Integer> createInput(int size, int repeats, boolean shuffle){
        ArrayList<Integer> result = new ArrayList<>(size);
        for (int i = repeats; i < size; i++)
            result.add(i);
        for(int i = 0; i < repeats; i++)
            result.add(0);
        if (shuffle)
            Collections.shuffle(result);
        return result;
    }

    /*
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // How many values to generate
        int numValues = 100000;
        // Whether the input should be shuffled
        boolean shuffle = true;
        // Whether to look for triplicate values
        boolean triplicates = false;
        // Whether to print data. Only use with small numbers of values.
        boolean printData = false;

        // Create some data, either sorted or unsorted
        ArrayList<Integer> data = createInput(numValues, (triplicates ? 3 : 2), shuffle);
        // Optionally print the data (to check correctness)
        if(printData){
            System.out.print("Input values: ");
            for(int i=0;i<data.size(); i++)
                System.out.print(data.get(i) + " ");
            System.out.println();
        }

        // Run one of the find functions;
        // Check time before and after to measure runtime
        long start = System.currentTimeMillis();
        // Pick the function based on whether we are looking for triplicates
        int result = triplicates ? findTriplicate(data) : findDuplicate(data);
        long now = System.currentTimeMillis();
        double elapsed = (now - start) / 1000.0;
        if(result >= 0)
            System.out.println("Result: " + result + " (value: " + data.get(result) + ")");
        else
            System.out.println("Result: nothing found");
        System.out.println("Elapsed time = " + elapsed + " seconds");

    }

}