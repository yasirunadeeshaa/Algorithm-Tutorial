public class Matrices {

    static int multiplyCount;
    public static void printMatrix(int[][] matrix){
        int dimension = matrix.length;
        for(int i = 0; i < dimension; i++){
            for(int j = 0; j < dimension; j++)
                System.out.print(matrix[i][j] + " ");
            System.out.println();
            System.out.println();
        }
    }

    public static int[][] multiply(int[][] A, int[][] B){
        multiplyCount ++;
        int dimension = A.length;
        int[][] result = new int[dimension][dimension];
        for(int i = 0; i < dimension; i++) {       // row in A
            for (int j = 0; j < dimension; j++) {  // column in B
                result[i][j] = 0;
                for (int k = 0; k < dimension; k++)
                    result[i][j] += A[i][k] * B[k][j];
            }
        }
        return result;
    }

    // Brute force version of matrix power
    public static int[][] slowPower(int[][] matrix, int exponent){
        int dimension = matrix.length;
        int[][] result = new int[dimension][dimension];
        for(int i =0;i<dimension;i++){
            for(int j=0;j<dimension;j++){
                result[i][j]=matrix[i][j];
            }
        }
        for(int i =1;i<exponent;i++){
            result=multiply(result, matrix);
        }
        return result;
    }

    // Divide-and-conquer version of matrix power
    public static int[][] fastPower(int[][] matrix, int exponent){
        if(exponent == 1){
            return matrix;
        }
        int[][] result_half = fastPower(matrix,exponent/2);

        int[][] result_even = multiply(result_half,result_half);

        if(exponent/2 ==0){
            return result_even;
        }
        return multiply(result_even,matrix);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Try changing the dimension (needs to still be square) and exponent
        // to see how the runtime changes
        int[][] matrix = {{1,2},{3,4}};
        int exponent = 1000000;          //

        long start = System.currentTimeMillis();
        printMatrix(slowPower(matrix, exponent));
        long middle = System.currentTimeMillis();
        printMatrix(fastPower(matrix, exponent));
        long end = System.currentTimeMillis();
        System.out.println("Runtimes (ms): " + (middle-start) + ", " + (end-middle));
    }

}