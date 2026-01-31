import java.util.Date;
import java.util.HashMap;

public class LC008StringToInteger {
    public static void main(String[] args) {
        String s = "-2147483648";
        // int x = -2147483647;
        // int x = 1563847412;
        // int x = 1563847412;
        System.out.println(s);
        Date d = new Date();
        System.out.println(myAtoi(s));
        System.out.println((new Date().getTime() - d.getTime()) + " ms");
    }

    public static int myAtoi(String s) {
        if (s.length() == 0) return 0;
        int i = 0;
        boolean negative = false;
        long res = 0;
        while (i < s.length()) {
            if (s.charAt(i) != ' ') break;
            i++;
        }

        if (i == s.length()) return 0;

        if (s.charAt(i) == '+') {
            i++;
        } else if (s.charAt(i) == '-') {
            i++;
            negative = true;
        }

        while (i < s.length()) {
            int nextChar = s.charAt(i);
            if (nextChar < 58 && nextChar > 47) {
                res = res * 10 + (nextChar - 48);
            } else break;
            if (negative && res >= (long)Integer.MAX_VALUE + 1) {
                return Integer.MIN_VALUE;
            } else if (res > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }

            i++;
        }

        if (negative) res = -res;

        return (int)res;        
        
    }

}
