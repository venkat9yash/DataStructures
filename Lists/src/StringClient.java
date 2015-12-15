/**
 * Created by YashGunapati1 on 7/29/15.
 */

import java.util.Hashtable;
import java.util.Scanner;
import java.util.Arrays;
import java.lang.Character;
public class StringClient {
    public static boolean search(char input[], char key, int low, int high)
    {
        if(low > high) return false;
            System.out.println("Search is from " + low +" to " + high );
            int mid = low + (high - low)/2;
            System.out.println(mid);
            if(input[mid] == key){
                return true;
            }
            else if(key > input[mid]){
                return search(input, key, mid + 1, high);

            }
            else{
                return search(input, key, low, mid - 1);
            }

    }
    public static String reverseString(String input){
        String[] inputArray = input.split("\\s");
        StringBuffer output = new StringBuffer();
        int arrayLength = inputArray.length - 1;
        output.append(inputArray[arrayLength]);
        for(int i = arrayLength - 1; i >= 0; i--){
            output.append(" ");
            output.append(inputArray[i]);
        }
        return output.toString();

    }
    public static void permutations(String input, String subString){
        if(input.length() == 1){
            System.out.println(subString + input);
        }
        else{
            for(int i=0; i < input.length() ; i++){
                //System.out.println(input.substring(0,i) + input.substring(i + 1) + ',' + subString + input.charAt(i));
                permutations(input.substring(0,i) + input.substring(i+1), subString + input.charAt(i));
            }

        }

    }
    public static String panagram(String s){
        boolean stringIndex[] = new boolean[128];
        int asci_code = 0;
        for(char c : s.toLowerCase().toCharArray()){
            if(c != ' ') {
                asci_code = (int) c;
                stringIndex[asci_code] = true;
            }
        }
        for(int i=97; i <= 122; i++){
            if(!stringIndex[i]){
                return "not panagram";
            }
        }
        return "panagram";

    }
    public static void combinations(String prefix, String input){
        if(input.length() > 0){

            System.out.println(prefix + input.charAt(0));
            combinations(prefix + input.charAt(0), input.substring(1));

            combinations(prefix, input.substring(1));
        }
    }
    public static void substring(String input){
        if(input.length() > 0){
            for(int i=1; i <= input.length(); i++){
                System.out.println(input.substring(0,i));
            }
            substring(input.substring(1));
        }
    }
    public static int makePalindrome(String input){
        int i=0;
        int j = input.length()-1;
        int changes = 0;
        while(i < j){
            changes += Math.abs(Character.getNumericValue(input.charAt(i)) - Character.getNumericValue(input.charAt(j)));
            i++;
            j--;
        }
        return changes;
    }
    public static boolean isPalindrome(String input){
        char inputString[] = input.toCharArray();
        int firstIndex = 0;
        int lastIndex = inputString.length - 1;
        while(lastIndex >= firstIndex){
            if(!Character.isLetterOrDigit(inputString[firstIndex])){
                firstIndex++;
            }
            else if(!Character.isLetterOrDigit(inputString[lastIndex])){
                lastIndex--;
            }
            else{
                if(inputString[firstIndex] != inputString[lastIndex]){
                    return false;
                }
                else{
                    firstIndex++;
                    lastIndex--;
                }

            }
        }

        return true;
    }
    public static int convertToIntIndex(String index){
        char indexArray[] = index.toCharArray();
        int returnIndex = 0;
        for(int i=0; i < indexArray.length; i++){
            returnIndex = returnIndex *  26 + indexArray[i] - 'A' + 1;
        }
        return returnIndex;

    }
    public static boolean isUnique(String input){
        boolean testBuffer[] = new boolean[256];
        for(int i=0; i<input.length(); i++){
            int charValue = Character.getNumericValue(input.charAt(i));
            if(testBuffer[charValue]){
                return false;
            }
            else{
                testBuffer[charValue] = true;
            }
        }
        return true;

    }
    public static boolean arePermutations(String input1, String input2){
        if(input1.length() == input2.length()) {
            char inputString1[] = input1.toCharArray();
            char inputString2[] = input2.toCharArray();
            Arrays.sort(inputString1);
            Arrays.sort(inputString2);
            for(int i=0; i < input1.length(); i++){
                if(inputString1[i] != inputString2[i]){
                    return false;
                }
            }
            return true;
        }
        else {
            return false;
        }
    }
    public static String convertoHttp(String input){
        char inputString[] = input.trim().toCharArray();
        StringBuffer outputString = new StringBuffer();
        for(int i=0; i < inputString.length; i++){
            if(inputString[i] == ' '){
                outputString.append('%');
                outputString.append('2');
                outputString.append('0');

            }
            else{
                outputString.append(inputString[i]);

            }
        }
        return outputString.toString();

    }
    public static int intPalindrome(int value){
        int rev = 0;
        while((value % 10) > 0){
            rev = rev * 10  + (value % 10);
            value = value/10;

        }
        return rev;

    }
    public static String inplacereverse(String input){
        int start = 0;
        int end = input.length();
        int i=0, j=end - 1;
        while(i < j){
            input = input.substring(start,i) + input.charAt(j) + input.substring(i + 1 , j) + input.charAt(i) + input.substring(j + 1);
            i++;
            j--;
        }
        return input;
    }
    public static void basicCompression(String input){
        if(input != null) {
            StringBuffer outputString = new StringBuffer();
            char lastChar = input.charAt(0);
            //outputString.append(lastChar);
            int charCount = 1;
            for(int i = 1; i < input.length(); i++){
                if(input.charAt(i) == lastChar){
                    charCount++;
                }
                else{
                    outputString.append(lastChar);
                    if(charCount > 1) {
                        outputString.append(charCount);
                    }
                    charCount = 1;
                    lastChar = input.charAt(i);
                }

            }
            outputString.append(lastChar);
            if(charCount > 1 ) outputString.append(charCount);
            System.out.println(outputString);
        }


    }
    public static void difference(String s1, String s2){
        char[] s1Chars = s1.toCharArray();
        Arrays.sort(s1Chars);
        char[] s2Chars = s2.toCharArray();
        Arrays.sort(s2Chars);
        int s1Limit = s1Chars.length;
        int s2Limit = s2Chars.length;
        if((s1Limit < 0 || s1Limit > 10000) || (s2Limit < 0 || s2Limit > 10000)){
            System.out.println("Data out of bounds");
        }
        int difference = 0;
        int i=0, j=0;
        while(i < s1Limit && j < s2Limit){
            if(s1Chars[i] == s2Chars[j]){
                i++;
                j++;
            }
            else{
                difference++;
                if((int)s1Chars[i] < (int)s2Chars[j]){
                    i++;
                }
                else{
                    j++;
                }
            }
        }
        if(s1Limit == i){
            difference =difference + (s2Limit - j);
        }
        else if(s2Limit == j){
            difference =difference + (s1Limit - i);
        }

        System.out.println(difference);
    }
    public static int fact(int n){
        if(n == 1){
            return n;
        }
        else{
            return n * fact(n-1);
        }
    }
    public static void findOdd(int input[], int given){
        int n = input.length;
        int expected_sum = (given * (given+1))/2;
        int actual_sum = 0;
        int actual_product = 1;
        for(int i=0; i < n; i++){
            actual_sum += input[i];
            actual_product *= input[i];
        }
        if(given - n == 1) {
            System.out.println(expected_sum - actual_sum);
        }
        else if(given - n == 2){
            System.out.println(fact(given)-actual_product);

        }
    }
    public static int alternativeCheck(String input){
        char[] charArray = input.toCharArray();
        char previousChar = ' ';
        int deletions = 0;
        for(char c : charArray){
            if(c == previousChar){
                deletions++;
            }
            else {
                previousChar = c;
            }
        }
        return deletions;
    }
    public static boolean anagramPalindrome(String input){
        Hashtable<Character, Integer> charList = new Hashtable<Character, Integer>();
        boolean odd = true;
        if(input.length() % 2 == 0){
            odd = false;

        }
        int size = input.length();
        char[] charArray = input.toCharArray();
        for(char c : charArray){
            if(charList.containsKey(c)){
                System.out.println(charList.get(c));
                charList.put(c, charList.get(c) + 1);
            }
            else{
                charList.put(c, 1);
                System.out.println(c);
            }
        }
        int temp = 0;
        for(char c : charList.keySet()){
            temp = charList.get(c);
            System.out.println(c + ":" + temp);
            if(temp%2 != 0){
                if(odd){
                    odd = false;
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean areAnagrams(String s1, String s2){
        if(s1.length() == s2.length()){
            char[] s1Array = s1.toCharArray();
            char[] s2Array = s2.toCharArray();
            Arrays.sort(s1Array);
            Arrays.sort(s2Array);
            if(new String(s1Array).equals(new String(s2Array))) return true;
            else return false;
        }
        else{
            return false;
        }
    }
    public static String reverseStringInPlace(String input){
        int length = input.length()/2;
        int i =0;
        int j = input.length() - 1;
        while(i < length){
            System.out.println(input = input.substring(0,i) + input.charAt(j) + input.substring(i+1, j) + input.charAt(i) + input.substring(j + 1,input.length()));
            i++;
            j--;
        }
        return input;

    }
    public static void httpInPlace(String input, int orginal_len){
        char[] inputArray = input.toCharArray();
        int j = orginal_len - 1;
        int x = input.length() - 1;
        while(j >=0){
            if(inputArray[j] != ' '){
                inputArray[x] = inputArray[j];
                x--;
            }
            else{
                inputArray[x] = '0';
                inputArray[x-1]='2';
                inputArray[x-2]='%';
                x = x-3;

            }

            j--;
        }
        for(char i : inputArray){
            System.out.print(i);
        }



    }
    public static boolean rotatedStringIsSubString(String old_String, String rotated_String){
        if(old_String.length() == rotated_String.length() && old_String.length() > 0) {
            if(((old_String + old_String).indexOf(rotated_String)) == - 1){
                return false;
            }
            return true;
        }
        else{
            return false;
        }
    }

    public static void main(String args[]){
       /* char inputString[] = "randombtring".toCharArray();
        Arrays.sort(inputString);
        if(search(inputString,'s', 0, inputString.length -1)){
            System.out.println("Match Found");
        }
        else{
            System.out.println("Not Found");
        }
        System.out.println(convertoHttp("Joe Doe is Stupid")); */

       //basicCompression("uuurbrreedd");
        //System.out.println(isUnique("helo") ? "String is Unique" : "String is not Unique");
        //System.out.println(arePermutations("helo", "obhe") ? "Are Permutations" : "Not Permutations");
        //System.out.println(convertToIntIndex("ZZ"));
        //System.out.println(isPalindrome("ki malayalamik") ? "String is Palindrom" : "String is not Palindrom");
        //System.out.println(reverseString("God is Great"));
        //permutations("yash","");
        //combinations("", "yash");
       // Scanner scan = new Scanner(System.in);
       // System.out.println(panagram(scan.nextLine()));
       // String sample = "hello v e r a fin re";
       // char sampleChars[] = sample.toCharArray();
       // Arrays.sort(sampleChars);
       // System.out.println(sampleChars);
       // difference("aced","coolaid");
       // System.out.println(intPalindrome(1234));
       // int [] input = {1,3,5,6};
       // findOdd(input, 6);
       // System.out.println(anagramPalindrome("cdcdcdcdeeeef"));
        //combinations("", "ABC");
        //substring("YASH");
        //System.out.println(makePalindrome("cba"));
        //System.out.println(areAnagrams("hello","ehllo"));
        //reverseStringInPlace("Raja");
        //httpInPlace("Hello brother  ",13);
        System.out.println(rotatedStringIsSubString("hellobrother","rotherhelloj"));
    }
}
