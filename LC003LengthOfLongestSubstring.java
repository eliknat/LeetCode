import java.util.stream.Stream;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class LC003LengthOfLongestSubstring {

    public static void main(String[] args) {
        String s = "abcnabcbb";
        // LengthOfLongestSubstring app = new LengthOfLongestSubstring();
        // String s = "pwwkew";
        // String s = "bbbbb";
        
        System.out.println(lengthOfLongestSubstring(s));
    }
    
        
        public static int lengthOfLongestSubstring(String s) {
            int max = 0;
            int left = 0, right = 0;
            int length = s.length();
            Set<Character> chars = new HashSet<>();
            while (right < length) {
                // System.out.println(chars.toString());
                if (chars.contains(s.charAt(right))) {
                    chars.remove(s.charAt(left));
                    left++;
                } else {
                    chars.add(s.charAt(right));
                    right++;
                }
                max = (Math.max(max, right - left));
            }
            return max;
        }

        
        // public static int lengthOfLongestSubstring2(String s) {
        //     if (s.length() == 1) return 1;
        //     int length = 0;
        //     int max = 0;
        //     int index;
        //     StringBuilder word = new StringBuilder();
        //     for (int i = 0; i < s.length(); i++) {
        //         char c = s.charAt(i);
        //         if (! ((index = word.indexOf(String.valueOf(c))) > -1)) {
        //             length++;
        //             word.append(c);
        //             max = Math.max(max, length);
        //         } else {
        //             length -= index;
        //             word.delete(0,index + 1);
        //             word.append(c);
        //         }
        //     }
        //     return max;
        // }
        
    }
