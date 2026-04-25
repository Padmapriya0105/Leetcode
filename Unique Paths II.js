var uniquePathsWithObstacles = function(obstacleGrid) {
    const m = obstacleGrid.length;
    const n = obstacleGrid[0].length;
    const dp = new BigInt64Array(n);

    dp[0] = obstacleGrid[0][0] === 0 ? 1n : 0n;

    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            if (obstacleGrid[i][j] === 1) {
                dp[j] = 0n;
            } else if (j > 0) {
                dp[j] += dp[j - 1];
            }
        }
    }

    return Number(dp[n - 1]);
};
