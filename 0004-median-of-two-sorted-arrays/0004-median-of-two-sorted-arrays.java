import java.util.*;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums3 = new int[nums1.length + nums2.length];
        System.arraycopy(nums1, 0, nums3, 0, nums1.length);
        System.arraycopy(nums2, 0, nums3, nums1.length, nums2.length);
        Arrays.sort(nums3);

        int n = nums3.length;
        if (n % 2 != 0) {
            return nums3[n / 2];
        } else {
            return (nums3[n / 2 - 1] + nums3[n / 2]) / 2.0;
        }
    }
}
