
class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solver = new Solution();
        int[] nums1 = {2, 2, 1};
        System.out.println("Output 1: " + solver.singleNumber(nums1)); 
        int[] nums2 = {4, 1, 2, 1, 2};
        System.out.println("Output 2: " + solver.singleNumber(nums2)); 
        int[] nums3 = {1};
        System.out.println("Output 3: " + solver.singleNumber(nums3));
    }
}
