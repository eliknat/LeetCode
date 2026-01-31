import java.util.Date;
import java.util.HashMap;

public class LC010RegEx {
    public static void main(String[] args) {
        String s = "abcde";
        String p = "a.****aaaa**aa*aaaa";
        // int x = -2147483647;
        // int x = 1563847412;
        // int x = 1563847412;
        // System.out.println(s);
        p = normalize(p);
        System.out.println(p);
        Date d = new Date();
        // System.out.println(isMatch(s, p));
        System.out.println((new Date().getTime() - d.getTime()) + " ms");
    }

    public static boolean isMatch(String s, String p) {
        boolean result = false;

        return result;    
        
    }

    public static String normalize(String s) {
        boolean lastAddedIsStar = false;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != '*') {
                sb.append(c);
                lastAddedIsStar = false;
            } else  if (lastAddedIsStar) {
                continue;
            } else {
                sb.append('*');
                lastAddedIsStar = true;

            }
        }

        return sb.toString();
    }

}
