class Solution {
    public int maxDistance(int side, int[][] points, int k) {
        int n = points.length;
        long[] d = new long[n];
        for (int i = 0; i < n; i++) {
            int x = points[i][0], y = points[i][1];
            if (y == 0) d[i] = x;
            else if (x == side) d[i] = (long) side + y;
            else if (y == side) d[i] = 2L * side + (side - x);
            else d[i] = 3L * side + (side - y);
        }
        java.util.Arrays.sort(d);

        long totalLen = 4L * side;
        int low = 1, high = (int) (totalLen / k);
        int ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canPlace(mid, d, k, totalLen)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    private boolean canPlace(int minDist, long[] d, int k, long totalLen) {
        int n = d.length;
        for (int i = 0; i < n; i++) {
            if (d[i] > d[0] + minDist) break;
            
            int count = 1;
            long lastPos = d[i];
            boolean possible = true;
            
            for (int j = 1; j < k; j++) {
                int nextIdx = findNext(d, lastPos + minDist);
                if (nextIdx == n) {
                    possible = false;
                    break;
                }
                lastPos = d[nextIdx];
                count++;
            }
            
            if (possible && (d[i] + totalLen - lastPos) >= minDist) {
                return true;
            }
        }
        return false;
    }

    private int findNext(long[] d, long target) {
        int l = 0, r = d.length;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (d[m] < target) l = m + 1;
            else r = m;
        }
        return l;
    }
}
