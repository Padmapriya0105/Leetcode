class Solution {
    public int singleNumber(int[] nums) {
        int ones = 0;
        int twos = 0;
        
        for (int num : nums) {
            ones = (ones ^ num) & ~twos;
            twos = (twos ^ num) & ~ones;
        }
        
        return ones;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solver = new Solution();

        int[] nums1 = {2, 2, 3, 2};
        System.out.println("Output 1: " + solver.singleNumber(nums1));

        int[] nums2 = {0, 1, 0, 1, 0, 1, 99};
        System.out.println("Output 2: " + solver.singleNumber(nums2));
    }
}
