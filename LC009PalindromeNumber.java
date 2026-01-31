import java.util.Date;
import java.util.HashMap;

public class LC009PalindromeNumber {
    public static void main(String[] args) {
        int x = 13331;
        // int x = -2147483647;
        // int x = 1563847412;
        // int x = 1563847412;
        System.out.println(x);
        Date d = new Date();
        System.out.println(isPalindrome(x));
        System.out.println((new Date().getTime() - d.getTime()) + " ms");
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) return false;
        int a = x;
        long b = 0;
        int digit;
        while (a != 0) {
            digit = a % 10;
            a /= 10;
            b = b * 10 + digit;            
        }
        // System.out.println(b);

        return (b == x);    
        
    }

}
