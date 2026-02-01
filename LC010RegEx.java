import java.util.Date;
import java.util.HashMap;

public class LC010RegEx {
    public static void main(String[] args) {
        String s = "a";
        String p = "a*";
        // String p = "a.****aaaa**aa*aaaa";
        // int x = -2147483647;
        // int x = 1563847412;
        // int x = 1563847412;
        // System.out.println(s);
        p = normalize(p);
        System.out.println("s=" + s);
        System.out.println("p=" + p);
        Date d = new Date();
        System.out.println(isMatch(s, p));
        System.out.println((new Date().getTime() - d.getTime()) + " ms");
    }

    public static boolean isMatch(String s, String p) {
        if (s.equals(p))
            return true;
        // if (s.length() == 0 && )
        boolean result = false;
        char pLastChar = 0;
        // int sCurIndex = 0;
        if (p.length() > 0 && p.charAt(0) == '*')
            return false;
        int i;
        for (i = 0; i < p.length(); i++) {
            char pCurChar = p.charAt(i);
            if (pCurChar != '*') {
                pLastChar = pCurChar;
                if (i < s.length() &&
                (pCurChar == '.'
                || pCurChar == s.charAt(i))
                || (p.length() > i + 1 && p.charAt(i + 1) == '*')
                )
                {
                    if (i < s.length() && (pCurChar == '.' || pCurChar == s.charAt(i))) {
                        System.out.println(s.charAt(i) + "=" + pCurChar);
                    } else {
                        System.out.println(pCurChar + " doesn't match but next char is *");
                    }
                    continue;
                } else
                    if (i >= s.length()) {
                        System.out.println("s is too short");
                    } else
                        System.out.println(s.charAt(i) + "!=" + pCurChar);
                    return false;
            } 
            else {
                System.out.println("* found");
                if (isMatch(s.substring(i - 1), p.substring(i + 1))) {
                    System.out.println("s=" + s.substring(i - 1) + ", p=" + p.substring(i + 1));
                    return true;
                } else if (isMatch(s.substring(i), p.substring(i + 1))) {
                    System.out.println("s=" + s.substring(i) + ", p=" + p.substring(i + 1));
                    return true;
                }
                // for (int j = )
                // if (isMatch())
            }
        }
        if (i == s.length()) {

            return true;
        } else
            System.out.println("s=" + s + ", p=" + p + ", p is too short");
            return false;

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
