import java.util.Date;

public class LC007ReverseInteger2 {
    public static void main(String[] args) {
        int x = -123;
        // int x = -2147483647;
        // int x = 1563847412;
        // int x = 1563847412;
        System.out.println(x);
        Date d = new Date();
        System.out.println(reverse(x));
        System.out.println((new Date().getTime() - d.getTime()) + " ms");
    }

    public static int reverse(int x) {
        int res = 0;
        int digit;
        // if (x < 0) {
        //     x = -x;
        //     negative = true;
        // }
        while(x != 0) {

            digit = x % 10;
            x = x / 10;
            if (res > Integer.MAX_VALUE/10 || res < Integer.MIN_VALUE/10) return 0;
            res = res * 10 + digit;
        }

        return res;
        
    }

}
