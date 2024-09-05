/***
 * -> Problem : When the program is run, the user will first enter a string. After that, the program should
ask the user which operation they want to execute on the string. The available operations are
listed below: Append, CountWords, Replace, isPalindrome, Splice, Split,
MaxRepeatingCharacter, Sort, Shift, and Reverse. Each method should perform its
respective operation based on the user's input.
-> Owner-Name : Arjun Gautam
-> Date of creation : 04/09/24
 */
import java.util.*;
public class Assignment2 {

    //Append method()
    public static String appendString(String originalString, String userStr){
        String intial = "";
        intial += originalString + " " + userStr ;
        return intial ;
    }

    //Word Count method()
    public static int wordCount(String originalString){
        if(originalString == null || originalString.length() == 0){
            return 0 ;
        }
        int count = 0 ;
        boolean isWord = false;
        for(int i = 0 ; i < originalString.length() ; i++ ){
            char ch = originalString.charAt(i);
            if(ch != ' ' && ch!= '\t' && ch != '.'){
                if(!isWord){
                    count++;
                    isWord = true;
                }
            }else{
                isWord = false;
            }
        }
        return count;
    }

    //Reverse String method()
    public static String reverse(String orginalString) {
        if (orginalString == null || orginalString.length() == 0) {
            return orginalString;
        }

        char[] orginalStrArray = orginalString.toCharArray();
        int start = 0;
        int end = orginalStrArray.length - 1;

        while (start < end) {
           
            char temp = orginalStrArray[start];
            orginalStrArray[start] = orginalStrArray[end];
            orginalStrArray[end] = temp;

            start++;
            end--;
        }

        return new String(orginalStrArray);
    }

    //IsPalindrome method()
    public static boolean isPalindrome(String originalString) {
        if (originalString == null || originalString.length() == 0) {
            return false;
        }

        int start = 0;
        int end = originalString.length() - 1;

        while (start < end) {
            if (originalString.charAt(start) != originalString.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }

    //Replace character method()
    public static String replace(String originalString, String charToreplace, String replacewith){
        String result = "";
        int i = 0;
        int length = charToreplace.length();

        while (i <= originalString.length() - length) {
            if (originalString.substring(i, i + length).equals(charToreplace)) {
                result += replacewith;
                i += length;
            } else {
                result += originalString.charAt(i);
                i++;
            }
        }
        result += originalString.substring(i);
        return result ;

    }

    //Sort String method()
    public static String sortString(String originalString) {
        if (originalString == null || originalString.length() == 0) {
            return originalString;
        }
        char[] strArray = originalString.toCharArray();

        // Bubble sort algorithm
        for (int i = 0; i < strArray.length - 1; i++) {
            for (int j = 0; j < strArray.length - 1 - i; j++) {
                if (strArray[j] > strArray[j + 1]) {
                    char temp = strArray[j];
                    strArray[j] = strArray[j + 1];
                    strArray[j + 1] = temp;
                }
            }
        }
        return new String(strArray);
    }

    //Splice method()
    public static String splice(String originalString, int startIndex, int length) {
        String result = "";

        for (int i = 0; i < originalString.length(); i++) {
            if (i >= startIndex && i < startIndex + length) {
                continue;
            } else {
                result += originalString.charAt(i);
            }
        }
        return result;
    }

    //Max repeat method()
    public static void maxRepeat(String originalString) {
        int maxCount = 0;
        char maxChar = originalString.charAt(0);

        for (int i = 0; i < originalString.length(); i++) {
            char currentChar = originalString.charAt(i);
            int count = 0;
            for (int j = 0; j < originalString.length(); j++) {
                if (originalString.charAt(j) == currentChar) {
                    count++;
                }
            }
            if (count > maxCount) {
                maxCount = count;
                maxChar = currentChar;
            }
        }
        System.out.print(maxChar + " " );
        System.out.println(maxCount);
    }

    //Shift method()
    public static void shift(String origiString , int n){
        Constants constant = new Constants();
        n= n % origiString.length();
        char[] arr = new char[origiString.length()];
        int index = 0;
        for(int i =origiString.length() - n;i<origiString.length();i++ ){
            arr[index++] = origiString.charAt(i);
        }
        for(int i = 0; i < origiString.length() - n ; i++){
            arr[index++] = origiString.charAt(i);
        }
        System.out.print(constant.Shift2);
        System.out.println(arr);
    }

    //Split method()
    public static String[] split(String originalString){
        String temp = originalString;
        String[] words = new String[wordCount(originalString)];
        temp = " "+temp+" ";
        int index = 0;
        for(int i = 0;i<temp.length()-1;i++){
            for(int j = i+1;j<temp.length();j++){
                if(temp.charAt(i)==' ' && temp.charAt(j)==' ' && temp.charAt(i+1) != ' '){
                    words[index++] = temp.substring(i,j);
                    i = j;
                }
            }
        }
        return words;
    }

    static String originalString;
    public static void main(String[] args) {
        Constants constant = new Constants();
        Scanner sc = new Scanner(System.in);
        originalString = "";
        System.out.print(constant.ENTER_INPUT);
        originalString = sc.nextLine().toLowerCase();
        System.out.println(constant.OPERATION_TYPE);
        boolean isQuit = true;
        while (isQuit) {
            System.out.print(constant.OPERATION_NO);
            String operation = sc.nextLine();
            switch (operation) {
                case "1" :                        
                    System.out.print(constant.APPEND_INPUT);
                    Scanner forAppend = new Scanner(System.in);
                    String second = forAppend.nextLine();
                    System.out.println(constant.OUTPUT + appendString(originalString, second));
                    break ;
                case "2" :
                    System.out.println(constant.OUTPUT + wordCount(originalString));
                    break ;
                case "3" :
                    System.out.println(constant.OUTPUT + reverse(originalString));
                    break ;
                case "4" :
                    System.out.println(constant.OUTPUT + isPalindrome(originalString));
                    break ;
                case "5" :
                    Scanner forReplace = new Scanner(System.in);
                    System.out.print(constant.CHAR_TO_REPLACE);
                    String charToreplace = forReplace.nextLine();
                    System.out.print(constant.REPLACEMENT_CHAR);
                    String replacewith = forReplace.nextLine();
                    System.out.println(constant.OUTPUT + replace(originalString, charToreplace, replacewith));    
                    break ;
                case "6" :
                    System.out.println(sortString(originalString));
                    break ;
                case "7" : 
                    System.out.print(constant.ENTER_INDEX);
                    Scanner forSplice = new Scanner(System.in);
                    int index = forSplice.nextInt();
                    System.out.print(constant.ENTER_LENGTH);
                    int length = forSplice.nextInt();
                    System.out.println(constant.OUTPUT + splice(originalString, index, length)); 
                    break ;
                case "8" : 
                    System.out.print(constant.OUTPUT);
                    maxRepeat(originalString);
                    break ;
                case "9" :
                    Scanner forShift = new Scanner(System.in);
                    System.out.print(constant.NO_OF_ELEMENT);
                    int element = forShift.nextInt();
                    System.out.print(constant.OUTPUT);
                    shift(originalString, element );
                    break ;
                case "10" :
                    String[] arr = split(originalString);
                    for (String s : arr) {
                        System.out.print("'" + s + "'" + ",");
                    }
                    System.out.println();
                    break ;
                case "0" : 
                    isQuit = false;
                    break ;
                default :
                    System.out.println(constant.INVALID);

            }
            // System.out.println("Do you want to continue? (yes/no)");
            // String continueChoice = sc.nextLine().trim().toLowerCase();

            // if (!continueChoice.equals("yes")) {
            //     isQuit = false;
            //     System.out.println("Exiting the program...");
            // }
            
        }
        sc.close();
    }
}
