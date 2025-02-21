package selectionsort;

import java.util.Random;

/**
 *
 * @author klaus
 */
public class SelectionSort {
    public static void sort(int[] values){
        int lastUnsorted = values.length - 1; // end of the unsorted section
        while(lastUnsorted > 0){ 
            // find the maximal unsorted element...
            int maxIndex = 0;             // this will be its index
            int maxValue = values[0];     // and this will be its value
            for(int i=1; i<=lastUnsorted; i++)
                if(values[i] > maxValue){ // new maximal value
                    maxIndex = i;
                    maxValue = values[i];
                }
            // then swap it with the last one, and add it to the sorted section
            values[maxIndex] = values[lastUnsorted];
            values[lastUnsorted] = maxValue;
            lastUnsorted--;
        }
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
        int numValues = 100000; 
        // Whether to print results. Only use with small numbers of values.
        boolean printResults = false; 
        
        
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
