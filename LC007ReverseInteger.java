import java.util.Date;

public class LC007ReverseInteger {
    public static void main(String[] args) {
        int x = 123;
        // int x = -2147483647;
        // int x = 1563847412;
        // int x = 1563847412;
        System.out.println(x);
        char cc = '1';
        int ci = cc;
        System.out.println(ci);
        System.out.println();
        Date d = new Date();
        System.out.println(reverse(x));
        System.out.println((new Date().getTime() - d.getTime()) + " ms");
    }

    public static int reverse(int x) {
        char[] digitChars = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        boolean negative = (x < 0);
        int size = size(x);
        int negShift = 0;
        if (!negative) {
            x = -x;
            negShift = 1;
        }
        char[] chars = new char[size];
        int charPos = size;
        while( x <= -10) {
            int r = x / 10 * 10 - x;
            x = x / 10;
            chars[size - (--charPos) - negShift] = digitChars[r];
        }
        chars[size - (--charPos) - negShift] = digitChars[-x];
        if (negative) {
            chars[0] = '-';
            // Integer.parseInt(null)
        }
        String s = new String(chars);
        if ((negative && size == 11 && s.substring(1).compareTo("2147483648") > 0) || (!negative && size == 10 && s.compareTo("2147483647") > 0)) {
            return 0;
        }
        int result = chars[1 - negShift] - '0';
        for (int i = 2 - negShift; i < size; i++) {
            result = result * 10 + (chars[i] - '0');
        }
        if (negative) result = -result;
        return result;
    }

    public static int size(int x) {
        int d = 1;
        if (x >= 0) {
            d = 0;
            x = -x;
        }
        int p = -10;
        for (int i = 1; i < 10; i++) {
            if (p < x) {
                return i + d;
            }
            p = 10 * p;
        }
        return 10 + d;
    }
}
