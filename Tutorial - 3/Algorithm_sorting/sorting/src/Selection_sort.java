public class Selection_sort {
    public static void sort(int[] values){
        int lastUnsorted = values.length - 1; // end of the unsorted section
        while(lastUnsorted > 0){
// find the maximal unsorted element...
            int maxIndex = 0; // this will be its index
            int maxValue = values[0]; // and this will be its value
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

}
