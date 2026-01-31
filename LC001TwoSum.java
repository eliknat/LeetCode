import java.util.Arrays;
import java.util.HashMap;

class LC001TwoSum {
    public static void main(String[] args) {
        int[] arr = {3,2,4};
        System.out.println(Arrays.toString(twoSum(arr, 6)));
        
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap <Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
                int complement = target - nums[i];
                if (map.containsKey(complement)) {
                    return new int[] {i,map.get(complement)};
                } else {
                    map.put(nums[i], i);
                }
        };
        return new int[]{};
    }
}