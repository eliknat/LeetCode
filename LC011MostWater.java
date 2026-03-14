import java.util.Date;

public class LC011MostWater {
    public static void main(String[] args) {
        int[] height = new int[] {
            1,8,6,2,5,4,8,3,7
        };
        Date d = new Date();
        System.out.println(maxArea(height));
        System.out.println((new Date().getTime() - d.getTime()) + " ms");
    }

    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int currentHeightLeft;
        int currentHeightRight;
        int currentMaxArea;
        int maxArea = 0;
        while(left < right) {
            currentHeightLeft = height[left];
            currentHeightRight = height[right];

            currentMaxArea = Math.min(height[left], height[right]) * (right - left);
            if (currentMaxArea > maxArea) {
                maxArea = currentMaxArea;
            }
            if (currentHeightLeft < currentHeightRight) {
                left++;
            } else {
                right--;
            } 
        }
        return maxArea;
    }
}
