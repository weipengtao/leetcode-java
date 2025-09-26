package problem611;

import java.util.Arrays;

public class Solution {
    public int triangleNumber(int[] nums) {
        int n = nums.length, res = 0;
        if (n < 3) return 0;
        Arrays.sort(nums);

        for (int i = n - 1; i >= 2; i--) {
            int left = 0, right = i - 1;
            while (left < right) {
                if (nums[left] + nums[right] > nums[i]) {
                    res += right - left;
                    right--;
                }  else {
                    left++;
                }
            }
        }
        return res;
    }
}
