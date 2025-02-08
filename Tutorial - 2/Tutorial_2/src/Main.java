import java.util.ArrayList;
import java.util.Collections;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // How many values to generate
        int numValues = 10;
        // Whether to print data. Only use with small numbers of values.
        boolean printData = true;
        // Whether to sort the data
        boolean sort = true;

        // Create some data, either sorted or unsorted
        ArrayList<Integer> data = FindMissing.createInput(numValues, true);
        // Optionally print the data (to check correctness)
        if(printData){
            System.out.print("Input values: ");
            for(int i=0;i<data.size(); i++)
                System.out.print(data.get(i) + " ");
            System.out.println();
        }

        if(sort)
            Collections.sort(data);

        // Run the find function;
        // Check time before and after to measure runtime
        long start = System.currentTimeMillis();
        int result = FindMissing.findMissingSorted(data);
        long now = System.currentTimeMillis();
        double elapsed = (now - start) / 1000.0;
        if(result >= 0)
            System.out.println("Result: " + result + " (value: " + data.get(result) + ")");
        else
            System.out.println("Result: nothing found");
        System.out.println("Elapsed time = " + elapsed + " seconds");

    }

}