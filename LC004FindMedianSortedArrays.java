public class LC004FindMedianSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {1,2,6};
        int[] nums2 = {3,4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int combinedLength = nums1.length + nums2.length;
        int combinedCounter = 0;
        double medianTotal = 0;
        int nums1CurIndex = 0;
        int nums2CurIndex = 0;
        int curElementValue = 0;

        int targetIndex2 = combinedLength/2;
        int targetIndex1 = ((combinedLength & 1) == 0) ? targetIndex2 - 1 : targetIndex2;
        while (combinedCounter <= targetIndex2) {
            if (nums2CurIndex == nums2.length || (nums1CurIndex < nums1.length && nums1[nums1CurIndex] < nums2[nums2CurIndex])) {
                curElementValue = nums1[nums1CurIndex];
                nums1CurIndex++;
            } else {
                curElementValue = nums2[nums2CurIndex];
                nums2CurIndex++;
            }
            if (combinedCounter == targetIndex1) {
                medianTotal += curElementValue;
            }
            if (combinedCounter == targetIndex2) {
                medianTotal += curElementValue;
            }

            combinedCounter ++;
        }
        return medianTotal / 2;
    }
    
}

// 4 - 1,2
// 5 - 2,2