import java.util.*;

public class test {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String s = console.nextLine();


    }

    private static String longestPalindrome(String s) {
       String palindrome = "";

        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = 0; j < s.length() - 1; j++) {
                if (s.charAt(i) == s.charAt(j + 1)){

                }
            }
        }

        return palindrome;
    }
}
//reverse(str.substring(1)) + str.charAt(0)


//babab