package mergesort;

import java.util.Random;

/**
 *
 * @author klaus
 */
public class MergeSort {

    // Merge (sorted) ranges values[first]...values[mid] and values[mid+1]...values[last]
    private static void mergeRanges(int[] values, int first, int mid, int last){
        // TO DO: implement the merge function
    }


    // Auxiliary recursive function
    // Sorts the range values[first]...values[last]
    private static void sortRange(int[] values, int first, int last){
        if(last > first){    // Otherwise there is nothing to do (single value)   
            int mid = (first + last) / 2;
            sortRange(values, first, mid);      // Recursively sort first half
            sortRange(values, mid + 1, last);   // Recursively sort second half
            mergeRanges(values, first, mid, last); // Merge sorted halves
        }
    }

    public static void sort(int[] values){
        sortRange(values, 0, values.length - 1);
    }
    
    public static int[] randomValues(int howMany){
        int[] result = new int[howMany];
        Random random = new Random();
        for(int i=0; i<howMany; i++)
           result[i] = random.nextInt() % (10 * howMany);
        return result;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // How many values to generate
        int numValues = 30; 
        // Whether to print results. Only use with small numbers of values.
        boolean printResults = true; 
        
        
        int[] a = randomValues(numValues);
        if(printResults){
            System.out.print("Before sorting: ");
            for(int i=0;i<numValues; i++)
                System.out.print(a[i] + " ");
            System.out.println();
        }
        long start = System.currentTimeMillis();
        sort(a);
        long now = System.currentTimeMillis();
        double elapsed = (now - start) / 1000.0;
        if(printResults){
            System.out.print("After sorting: ");
            for(int i=0;i<numValues; i++)
                System.out.print(a[i] + " ");
            System.out.println();
        }
    	System.out.println();
        System.out.println("Elapsed time = " + elapsed + " seconds");    
    }    
}
