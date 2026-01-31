import java.util.*;
public class LC005LongestPalindrome {


    public static void main(String[] args) {
        String s;
        s = "a";
        // s = "hamburger";
        // System.out.println(longestPalindrome(s));
        System.out.println(longestPalindrome(s));
        
    }

    public static String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        String palindrome = null;
        String longestPalindrome = String.valueOf(chars[0]);

        for (int i = 0; i < s.length() - 1; i++) {
            if (chars[i] == chars[i+1]) {
                palindrome = expand(s, chars, i, i + 1);
                if (palindrome.length() > longestPalindrome.length()) {
                    longestPalindrome = palindrome;
                }
            }
            if ((i < s.length() - 2) &&
            chars[i] == chars[i+2]) {
                palindrome = expand(s, chars, i, i + 2);
                if (palindrome.length() > longestPalindrome.length()) {
                    longestPalindrome = palindrome;
                }
            }
        }
        return longestPalindrome;
    }

    public static String expand(String s, char[] chars, int start, int end) {
        while(start >= 1 && end < chars.length - 1) {
            if (!(chars[--start] == chars[++end])) {
                start++;
                end--;
                break;
            }
        }
        return s.substring(start, end + 1);
    }



    // daccaf
    
    public static String longestPalindrome2(String s) {
        int longest = 0;
        String palindrome = null;
        HashMap<Character, TreeSet<Integer>> charMap = new HashMap<>();
        String reversedS;
        int textLength = s.length();
        StringBuilder reversedStringBuilder = new StringBuilder();
        for (int i = textLength - 1; i >= 0; i--) {
            char c = s.charAt(i);
            reversedStringBuilder.append(c);
            charMap.putIfAbsent(c, new TreeSet<>());
            charMap.get(c).add(i);
        }
        
        reversedS = reversedStringBuilder.toString();
        
        int end;
        for (int start = 0; start < textLength; start++) {
            char c = s.charAt(start);
            Iterator<Integer> iter = charMap.get(c).descendingIterator();
            
            while(iter.hasNext() && (end = iter.next()) > start) {
                if (isPalindrome(s, reversedS, start, end)) {
                    if (end + 1 - start > longest) {
                        longest = end + 1 - start;
                        palindrome =  s.substring(start, end + 1);
                    }
                }
                
            }
        }
        return palindrome;
    }

    public static boolean isPalindrome(String original, String reversed, int start, int end) {
        int lengthToCompare = (end - start)/2 + 1;
        String firstHalf = original.substring(start, start + lengthToCompare);
        String reversedSecondHalf = reversed.substring(original.length() - 1 - end, original.length() - 1 - end + lengthToCompare);
        return (firstHalf.equals(reversedSecondHalf));
    }

}
