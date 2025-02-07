import static java.util.Arrays.sort;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

//        Selection_sort s1;
//        s1 = new Selection_sort();
        int[] value = {22,50,10,60,92,5,800,100,2};
        for(int j : value){
            System.out.println(j);
        }
        sort(value);
        for(int i : value){
            System.out.print(i);
        }

    }
}