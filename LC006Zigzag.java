import java.util.ArrayList;
import java.util.HashMap;
public class LC006Zigzag {
    public static void main(String[] args) {
        String s = "AB";
        int numRows = 1;
        System.out.println(convert(s, numRows));
    }
    
    public static String convert(String s, int numRows) {
        if (numRows == 1) return s;
        int row = 1;
        int dx = 1;
        StringBuilder result = new StringBuilder();
        StringBuilder[] resMap = new StringBuilder[numRows + 1];
        for (int i = 1; i <= numRows; i++) {
            resMap[i] = new StringBuilder();
        }
            for (int i = 0; i < s.length(); i++) {
                resMap[row].append(s.charAt(i));
                row += dx;
                if (row == numRows || row == 1) {
                    dx = -dx;
                }
            }
            for (int i = 1; i <= resMap.length - 1; i++) {
                    result.append(resMap[i]);
            }
        return result.toString();
    }

    public static String convert2(String s, int numRows) {
        int row = 1;
        int dx = 1;
        StringBuilder result = new StringBuilder();
        HashMap<Integer, ArrayList<Integer>> resMap = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                if (!resMap.containsKey(row)) resMap.put(row, new ArrayList<>());
                resMap.get(row).add(i);
                row += dx;
                if (row == numRows || row == 1) {
                    dx = -dx;
                }
            }
            for (int key : resMap.keySet()) {
                for (int i : resMap.get(key)) {
                    result.append(s.charAt(i));
                }
            }
        return result.toString();
    }


}
