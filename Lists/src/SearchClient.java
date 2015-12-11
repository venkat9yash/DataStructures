/**
 * Created by YashGunapati1 on 9/2/15.
 */
public class SearchClient {
    int storage[] = {};
    public static int searchFirstAfterK(int k, int[] searchArray){
        int low = 0;
        int high = searchArray.length - 1;

        int result=0;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(searchArray[mid] <= k){
                low = mid+1;

            }
            else if(searchArray[mid] > k){
                result = searchArray[mid];
                high=mid-1;
            }
            System.out.println(low + ":" + high);

        }
        return result;

    }
   /* public static int cyclicSearch(int[] storage, int k){
        int high = storage.length -1;
        int low = 0;
        int result = 0;
        while(low <= high){
            int mid = low + (high - low)/2;
             if(storage[low] < storage[mid]){
                 if(storage[mid] >= k && storage[low] <= k){
                     high = mid - 1;
                 }
                 else{
                     low = mid + 1;
                 }
             }
            else if(storage[low] > storage[mid]){
                 if(storage[mid] <= k && storage[high] >= k){
                     low = mid + 1;
                 }
                 else{
                     high = mid - 1;
                 }

             }
        }
        return result;
    }*/
    public static int searchRecursive(int[] searchArray, int k){
        int low = 0;
        int high = searchArray.length - 1;
        return search(searchArray, low, high, k);

    }
    public static int search(int[] numbers, int low, int high, int k){
        if(low <= high){
            int mid = low + (high - low)/2;
            if(numbers[mid] > k ){
                low = mid + 1;
                return search(numbers, low, high, k);

            }
            else if(numbers[mid] == k){
                return mid;
            }
            else{
                high = mid - 1;
                return search(numbers, low, high, k);

            }

        }
        else{
            return 0;
        }

    }
    public static int findString(String input[],String key ,int start, int end){
        int mid = start + (end-start)/2;
        if(input[mid].isEmpty()){
            int right=mid + 1;
            int left=mid - 1;
            while(true){
                if(left< start && right > end){
                    return -1;
                }
                else if(left >= start && !input[left].isEmpty()){
                    mid = left;
                    break;

                }
                else if(right <= end && !input[right].isEmpty()){
                    mid = right;
                    break;

                }
                left--;
                right++;

            }
        }
        if(input[mid].compareTo(key) > 0){
            return findString(input, key, start, mid-1);
        }
        else if(input[mid].compareTo(key) < 0){
            return findString(input, key, mid+1, end);
        }
        else{
            return mid;
        }


    }
    public static int findMin(int[] values){
        int min = 99;
        for(int i: values){
            if(i != -1){
                if(i < min){
                    System.out.println("paths" + i);
                    min = i;
                }
            }
        }
        if(min == -1)
            return -1;
        else
            return min;
    }
    public static int shortestPathToDestination(char[][] field,int[][] trace,int x2,int y2){
        System.out.println(x2 + "," + y2 );
        if(((x2 >= 0 && x2 < field[0].length) && (y2 >=0 && y2 < field.length)) && trace[x2][y2] != 1 ) {
            System.out.println("In Range");
            trace[x2][y2] = 1;
            if (field[x2][y2] == '/') {
                System.out.println("Found Values");
                return 1;
            }
            else if(field[x2][y2] == '#'){
                return -1;
            }
            else {
                int[] path_values = {shortestPathToDestination(field, trace , x2 + 0, y2 + 1), shortestPathToDestination(field, trace, x2 + 0, y2 - 1), shortestPathToDestination(field, trace , x2 + 1, y2),shortestPathToDestination(field, trace , x2 + -1,y2)};
                int min_path = findMin(path_values);
                if(min_path != -1)
                    return 1 + min_path;
                else
                    return -1;
            }
        }
        else{
            return -1;
        }

    }
    public static int findEqSeries(int[] input){
        int i=0;
        int j=input.length - 1;
        int sum_a=0, sum_b =0;
        while(i < j){
            sum_a = sum_a+ input[i];
            sum_b = sum_b + input[j];
            i++;
            j--;
        }
        if((input.length) % 2 !=0){
            sum_a = sum_a + input[i];
        }

        int mid = i;

        while(mid >0 && mid < input.length - 1){
            System.out.println(sum_a + ":" + sum_b);
            if(sum_a > sum_b){
                mid--;
                sum_a = sum_a - input[mid];
                sum_b = sum_b + input[mid];

            }
            else if(sum_a < sum_b){
                mid++;
                sum_a = sum_a + input[mid];
                sum_b = sum_b - input[mid];


            }
            else{
                return mid;
            }
        }

        return 0;
    }
    public static int findInRotation(int input[], int low, int high){
        int mid = low + (high - low)/2;
        return 0;
    }

    public static void main(String args[]){
        int[] sampleArray = {-14,-10,2,108,108,243,285,285,285,401};
        int[][] placeHolder = {{0,0,0},{0,0,0},{0,0,0}};
        char[][] map = {{'*','*','*'},{'*','*','/'},{'*','#','*'}};
        String[] strings = {"ab","","","abc","hello","","yash","",""};
        //System.out.println(findString(strings,"yash",0, strings.length-1));
       // System.out.println(shortestPathToDestination(map,placeHolder,0,0));
      //  System.out.println(searchFirstAfterK(108, sampleArray));
       // System.out.println(searchRecursive(sampleArray, 108));
        int[] input = {2,8,1,1,1,2,2,3};
        System.out.println(findEqSeries(input));

    }
}
