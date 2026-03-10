import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // Step 1: Sort the array (O(n log n))
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            // Optimization: If the current smallest number > 0, 
            // no triplet can sum to 0 because all subsequent numbers are also > 0
            if (nums[i] > 0) break;

            // Step 2: Skip duplicate values for the first element to avoid duplicate triplets
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            // Step 3: Use Two Pointers for the remaining elements
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    
                    // Skip duplicates for the second and third elements
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++; // Sum is too small, move to a larger value
                } else {
                    right--; // Sum is too large, move to a smaller value
                }
            }
        }
        return result;
    }
}
