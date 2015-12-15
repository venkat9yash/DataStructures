import com.sun.xml.internal.fastinfoset.util.CharArray;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Arrays;

/**
 * Created by YashGunapati1 on 7/30/15.
 */
public class ArrayClient {
    public static void printMatrix(int input[][]){
        int m = input.length;
        int n = input[0].length;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                System.out.print(input[i][j] + " ");
            }
            System.out.print("\n");
        }

    }
    public static int[][] multiplyMatrix(int A[][], int B[][]){
        int mA = A.length;
        int nB = B[0].length;
        int nA = A[0].length;

        int[][] result = new int[mA][nB];

        for(int i = 0 ; i < mA; i++){
            for(int j=0; j < nB; j++){
                for(int k=0; k <nA; k++){
                    result[i][j] += A[i][k] * B[k][j];
                }

            }
        }

        return result;

    }
    public static void matrixSpiralPrint(int input[][]) {
        double max_offset =  Math.ceil(input.length * 0.5) ;
        for (int i = 0; i < max_offset; i++) {

            caluculateSpiral(input, i);
        }
    }
    public static void caluculateSpiral(int input[][], int offset){
        int max_offset = input.length - offset -1;
        if(offset == max_offset){
            System.out.println(input[offset][offset]);
            return;
        }

        for(int i=offset; i<max_offset; i++){
            System.out.println(input[i][offset]);
        }
        for(int j=offset; j<max_offset; j++){
            System.out.println(input[max_offset][j]);
        }
        for(int i=max_offset; i>offset; i--){
            System.out.println(input[i][max_offset]);
        }
        for(int j=max_offset; j>offset; j--){
            System.out.println(input[offset][j]);
        }
        return;

    }
    public static void minDifference(int input[]){
        int min_value = input[0];
        int max_difference = 0;
        for(int i=0; i < input.length; i++){
            int min_difference_now = input[i] - min_value;
            if(min_difference_now > max_difference){
                max_difference = min_difference_now;
            }
            if(min_value > input[i]){
                min_value = input[i];
            }
        }
        System.out.println(max_difference);
    }
    public static void pivotPartition(int input[], int pivot){
        int pivot_value = input[pivot];
        int smaller_index =0;
        for(int i=0; i < input.length; i++){
            if(input[i] < pivot_value){
                int temp = input[i];
                input[i] = input[smaller_index];
                input[smaller_index] = temp;
                smaller_index++;
            }

        }
        int larger_index = input.length - 1;
        for(int i=input.length - 1; i >= 0; i--){
            if(input[i] > pivot_value){
                int temp = input[i];
                input[i] = input[larger_index];
                input[larger_index] = temp;
                larger_index--;
            }

        }
        for(int i=0; i<input.length; i++){
            System.out.println(input[i]);
        }

    }
    public static void matrixShootZero(int input[][]){
        int m = input.length;
        int n = input[0].length;
        boolean rows[] = new boolean[m];
        boolean cols[] = new boolean[n];
        for(int i=0; i < m; i++){
            for(int j=0; j<n; j++){
                if(input[i][j] == 0){
                    rows[i] = true;
                    cols[j] = true;
                }

            }
        }
        for(int i=0; i<m; i++ ){
            if(rows[i]){
                for(int j=0; j<n; j++){
                    input[i][j] = 0;
                }
            }
        }
        for(int j=0; j<n; j++ ){
            if(cols[j]){
                for(int i=0; i<m; i++){
                    input[i][j] = 0;
                }
            }
        }
        printMatrix(input);
    }
    public static int[][] rotate90(int input[][]){
        int m = input.length;
        int n = input[0].length;
        int rotate[][] = new int[n][m];
        for(int i=m-1; i >= 0; i--){
            for(int j=0; j<= n-1; j++){
                rotate[j][Math.abs(i - (m -1))] = input[i][j];

            }
        }
        return rotate;
    }
    public static void inplace90(int input[][]){
        int n = input.length;
        int m1=0, n1=0;
        for(int i=n-1; i >= 0; i--){
            for(int j=0; j<= n-1; j++){
                m1 = Math.abs(i - (n -1));
                n1 = Math.abs(j - (n -1));
                System.out.println(input[i][j] + ":" + input[j][m1] + ":" + input[m1][n1] + ":"  + input[n1][i]);

            }
        }

    }
    public static int[] pushZerosToLast(int input[]){
        int i=0;
        int zeroIndex=0;
        int j = input.length;
        while(i < j){
            if(input[i] != 0){
                int temp = input[zeroIndex];
                input[zeroIndex] = input[i];
                input[i] = temp;
                zeroIndex++;

            }
            i++;
        }

        return input;
    }
    public static int[] removeDuplicatesInPlace(int input[]){
        int i=0;
        int calculated_lenght = 0;
        HashMap<Integer,Integer> storage = new HashMap<Integer, Integer>();
        int j=input.length;
        while(i < j){
            if(!storage.containsKey(input[i])){
                storage.put(input[i],1);
                input[calculated_lenght] = input[i];
                calculated_lenght++;
            }
            i++;
        }
        for(int x=j-1; x >= calculated_lenght; x-- ){
            input[x] = -1;
        }
        System.out.println("Length is :" + calculated_lenght);
        return input;
    }
    public static int[][] inplaceRotate90(int input[][]){
        int m = input.length - 1;
        int index = 0;
        for(int i=0; i <= m/2  ; i++){
            for (int j=0 + index; j<m-index; j++){
                int temp = input[j][m-i];
                input[j][m-i] = input[i][j] ;
                int temp2 = input[m-i][m-j];
                input[m-i][m-j] = temp;
                int temp3 = input[m-j][i];
                input[m-j][i] = temp2;
                input[i][j] = temp3;
                System.out.print(input[i][j]);
                System.out.print(input[j][m-i]);
                System.out.print(input[m-i][m-j]);
                System.out.print(input[m-j][i]);
                System.out.println();
            }
            index++;
        }

        return input;
    }
    public static int[] rotateByOrder(int[] input, int order){
        int length = input.length ;
        for(int i=0; i<order; i++){
            int lastElement = input[length - 1];
            for(int j=length - 1; j>0; j--){
                input[j] = input[j-1];
            }
            input[0]=lastElement;
        }
        return input;
    }
    public static int[] addition(int[] a, int[] b){
        ArrayList<Integer> output = new ArrayList<Integer>();
        return a;
    }

    public static void main(String args[]){
        //matrix A
        int mA = 3;
        int nA = 3;
        int mB = 3;
        int nB = 3;
        int A[][] = new int[mA][nA];
        int B[][] = new int[mB][nB];
        for(int i=0; i < mA; i++){
            for(int j=0; j < nA; j++){
                A[i][j] = i + j;
            }
        }
        for(int i=0; i < mB; i++){
            for(int j=0; j < nB; j++){
                B[i][j] = i + j;
            }
        }
       // printMatrix(multiplyMatrix(A,B));
       // A[2][1] = 0;
        //matrixShootZero(A);
        //matrixSpiralPrint(A);
        //int sampleArray[] = {5,62,9,4,13,89};
        //minDifference(sampleArray);
        //pivotPartition(sampleArray,2);
        //int image[][] = {{9, 4, 1 },{7 ,5, 2}};
        //printMatrix(rotate90(image));
        //int[][] input = {{1,2,3},{6,7,4},{3,1,5}};
        //inplace90(input);
        int[] input = {15,4,3,6,6,15,1,4};
        //for(int output : removeDuplicatesInPlace(input)){
           // System.out.println(output);
        //}
        //printMatrix(inplaceRotate90(input));
        for(int output : rotateByOrder(input,4)){
             System.out.print(output);
        }

    }
}
