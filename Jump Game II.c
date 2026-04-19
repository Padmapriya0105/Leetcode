int jump(int* nums, int numsSize) {
    if (numsSize <= 1) return 0;

    int jumps = 0;
    int current_jump_end = 0;
    int farthest = 0;

    for (int i = 0; i < numsSize - 1; i++) {
        if (i + nums[i] > farthest) {
            farthest = i + nums[i];
        }

        // When we hit the end of our current reach, we "commit" to a jump
        if (i == current_jump_end) {
            jumps++;
            current_jump_end = farthest;
            
            if (current_jump_end >= numsSize - 1) break;
        }
    }

    return jumps;
}
