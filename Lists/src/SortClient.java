import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;

/**
 * Created by YashGunapati1 on 8/10/15.
 */
public class SortClient {
    int helper[];
    int inputArray[];

    public  void mergeSort(int[] input){
        int arrayLength = input.length;
        this.helper = new int[arrayLength];
        this.inputArray = input;
        sort(0, arrayLength - 1);
        System.out.println(Arrays.toString(inputArray));

    }
    public void sort(int low, int high){
        if(low < high) {
            int mid = low + (high - low) / 2;
            sort(low, mid);
            sort(mid + 1, high);
            merge(low, mid, high);
        }

    }
    public void merge(int low, int mid, int high){
        System.out.println(low + " " + mid + " " + high );
        for(int i=low; i<= high; i++ ){
            this.helper[i] = this.inputArray[i];
        }
        int i= low;
        int j = mid + 1;
        int k = low;
        while(i <= mid && j <= high){
            if(this.helper[i] <= this.helper[j]){
                this.inputArray[k] = this.helper[i];
                i++;
            }
            else{
                this.inputArray[k] = this.helper[j];
                j++;
            }
            k++;

        }

        while(i <= mid){
            this.inputArray[k] = this.helper[i];
            k++;
            i++;
        }
        System.out.println(Arrays.toString(inputArray));

    }
    public void quickSort(int input[]){
        this.inputArray = input;
        int high = input.length - 1;
        partition(0, high);
        System.out.println(Arrays.toString(inputArray));

    }
    public void partition(int low, int high){
        int pivot = this.inputArray[low + (high - low) / 2];
        System.out.println(pivot);
        int i = low;
        int j = high;
        while(i <= j){
            while(this.inputArray[i] < pivot){
                i++;
            }
            while(this.inputArray[j] > pivot){
                j--;
            }
            if(i <= j) {
                int temp = this.inputArray[i];
                this.inputArray[i] = this.inputArray[j];
                this.inputArray[j] = temp;
                i++;
                j--;
            }
        }
        System.out.println(i + " " + j );
        System.out.println(Arrays.toString(inputArray));
        if(low < j){
            partition(low, j);

        }
        if(i < high){
            partition(i, high);
        }
    }
    public static int mypartition(int[] input, int low, int high){
        int pivot = input[low + (high - low) / 2];
        int i = low;
        int j = high;
        while(i <= j){
            while(input[i] < pivot){
                i++;
            }
            while(input[j] > pivot){
                j--;
            }
            if(i <=j){
                int temp = input[i];
                input[i] = input[j];
                input[j] = temp;
                i++;
                j--;
            }
        }
        return i;
    }
    public static void myquicksort(int[] input, int start, int end){
        int index = mypartition(input,start,end);
        if(index - 1> start){
            myquicksort(input, start, index-1);
        }
        if(index < end){
            myquicksort(input, index, end);
        }
    }
    public static void sortStringByAnagram(String[] anagrams){
        Hashtable<String, ArrayList<String>>store = new Hashtable<String, ArrayList<String>>();
        for(String anagram: anagrams){
            char[] charArray = anagram.toCharArray();
            Arrays.sort(charArray);
            String sortedAnagram = new String(charArray);
            if(!store.containsKey(sortedAnagram)){
                store.put(anagram, new ArrayList<String>());
            }
            ArrayList<String> values = store.get(sortedAnagram);
            values.add(anagram);

        }
        for(String key: store.keySet()){
            for(String result : store.get(key)){
                System.out.println(result);
            }

        }

    }
    public static void sortAnagrams(String input[]){
        Hashtable<String, LinkedList<String>> buckets = new Hashtable<String, LinkedList<String>>();
        String anagram;
        LinkedList<String> bucket_list;
        for(String s: input){
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            anagram = new String(charArray);
            if(buckets.containsKey(anagram)){
                bucket_list = buckets.get(anagram);
                bucket_list.addLast(s);
                buckets.put(anagram, bucket_list);
            }
            else{
                bucket_list = new LinkedList<String>();
                bucket_list.addLast(s);
                buckets.put(anagram,bucket_list);
            }
        }
        for(LinkedList<String> list : buckets.values()){
            list.printList();
        }

    }
    public static void mergeIntoLarger(int[] A, int[] B){
        int k = A.length - 1;
        int i = B.length - 1;
        int j = k - i - 1 ;

        while(i >=0 && j>= 0){
            if(A[j] > B[i]){
                A[k] = A[j];
                j--;
            }
            else{
                A[k] = B[i];
                i--;
            }
            System.out.println(A[k]);
            k--;

        }

    }
    public static void insertionSort(int[] input){
        int low = 0;
        int high = input.length - 1;
        for(int i = low + 1; i<= high; i++){
            int j = i - 1;
            int temp = input[i];
            while(j >= 0 && input[j] > temp){
                input[j+1] = input[j];
                j--;
            }
            input[j+1] = temp;
            for(int x=0; x < input.length; x++){
                System.out.print(input[x] + " ");
            }
            System.out.println("\n");
        }


    }
    public static int median(int input[], int low, int high){
        int i = low, j = high;
        int pivot = input[(i + j) / 2];
        while(i <= j){
            while(i <= high & input[i] < pivot){
                i++;
            }
            while(j >= low & input[j] > pivot){
                j--;
            }
            if(i <=j){
                int temp = input[i];
                input[i] = input[j];
                input[j] = temp;
                i++;
                j--;
            }
        }


        return i - 1;

    }
    public static int maxDiff(int input[]){
        myquicksort(input,0,input.length - 1);
        for(int x=0; x < input.length; x++){
            System.out.print(input[x] + " ");
        }
        int minDifference = input[1] - input[0];
        for(int i=2; i < input.length; i++){
            int j = i-1;
            int temp_difference = input[i] - input[j];
            if(minDifference > temp_difference){
                minDifference = temp_difference;
            }
        }
        return minDifference;
    }
    public static int findMedian(int input[]){
        int low = 0;
        int count = 0;
        int high = input.length - 1;
        int expected = (low + high) / 2;
        int middle = median(input, low, high);
        while(expected != middle){
            middle = median(input,low, high);

        }

        return middle;

    }
    public static void main(String args[]){
        //SortClient obj = new SortClient();
        //int new_array[] = {9,3,4,3,10,11,1};
        //obj.mergeSort(new_array);
        //obj.quickSort(new_array);
        //String[] anagrams = {"abc", "xyz", "bca", "efg", "zxy"};
        //sortStringByAnagram(anagrams);
       // String[] input = {"abc","efg","xyz","cda","gfe"};
        //sortAnagrams(input);
        //int[] large = {1,2,4,6,0,0,0,0};
        //int[] smaller ={3,5,7,8};
        //mergeIntoLarger(large,smaller);
        //int[] input = {-20, -3916237, -357920, -3620601, 7374819, -7330761, 30, 6246457, -6461594, 266854, -520, -470 };
        //myquicksort(input, 0, input.length - 1);
        //for(int x=0; x < input.length; x++){
        //    System.out.print(input[x] + " ");
        //}
       // insertionSort(input);
       // System.out.println("\n" + maxDiff(input));
        int [] input = {0, 1, 2, 4, 6, 5, 3};
        System.out.println(input[findMedian(input)]);


    }
}
