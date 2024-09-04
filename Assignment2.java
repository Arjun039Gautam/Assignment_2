import java.util.*;
public class Assignment2 {
    public static String appendString(String str1, String str2){
        String intial = "";
        intial += str1 + " " + str2 ;
        return intial ;
    }
    public static int wordCount(String str){
        if(str == null || str.length() == 0){
            return 0 ;
        }
        int count = 0 ;
        boolean isWord = false;
        for(int i = 0 ; i < str.length() ; i++ ){
            char ch = str.charAt(i);
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

    public static String reverse(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }

        char[] strArray = str.toCharArray();
        int start = 0;
        int end = strArray.length - 1;

        while (start < end) {
            // Swap characters
            char temp = strArray[start];
            strArray[start] = strArray[end];
            strArray[end] = temp;

            start++;
            end--;
        }

        return new String(strArray);
    }

    public static boolean isPalindrome(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }

        int start = 0;
        int end = str.length() - 1;

        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }

    static String originalString;
    public static void main(String[] args) {
        
            Scanner sc = new Scanner(System.in);
            System.out.print("enter input  : ");
            originalString = sc.nextLine();
            System.out.println("which operation you want to execute on the string : \n 1. Append String \n 2. Word Counter \n 3. Reverse the string \n 4. isPalindrome \nType only number");
            boolean isQuit = true;
            while (isQuit) {
                System.out.print("Enter operation Number : ");
                int operation = sc.nextInt();
                switch (operation) {
                    case 1:
                        System.out.print("Enter string which you append : ");
                        Scanner forAppend = new Scanner(System.in);
                        String second = forAppend.nextLine();
                        System.out.println("Output : " + appendString(originalString, second));
                        break;
                    case 2:
                        System.out.println("Output : " + wordCount(originalString));
                        break;
                    case 3:
                        System.out.println("Output : " + reverse(originalString));
                        break;
                    case 4 :
                        System.out.println("Output : " + isPalindrome(originalString));
                    case 5:
                        isQuit = false;
                        break;
                    default :
                        System.out.println("invalid");

                }
            }
            sc.close();
        
        
    }
}
