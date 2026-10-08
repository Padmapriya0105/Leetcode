class Solution {

    public int rob(int[] nums) {

        int n = nums.length;

        if (n == 1) {
            return nums[0];
        }
        int firstCase = robLinear(nums, 0, n - 2);
        int secondCase = robLinear(nums, 1, n - 1);

        return Math.max(firstCase, secondCase);
    }

    private int robLinear(int[] nums, int start, int end) {

        int previousTwo = 0;
        int previousOne = 0;

        for (int i = start; i <= end; i++) {

            int current = Math.max(
                previousOne,
                previousTwo + nums[i]
            );

            previousTwo = previousOne;
            previousOne = current;
        }

        return previousOne;
    }
}
