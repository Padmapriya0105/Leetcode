/**
 * @param {number} dividend
 * @param {number} divisor
 * @return {number}
 */
var divide = function(dividend, divisor) {
    const MAX_INT = 2147483647;
    const MIN_INT = -2147483648;
    if (dividend === MIN_INT && divisor === -1) {
        return MAX_INT;
    }
    const isNegative = (dividend < 0) !== (divisor < 0);
    let a = Math.abs(dividend);
    let b = Math.abs(divisor);
    let quotient = 0;
    for (let i = 31; i >= 0; i--) {
        // Use Math.pow or shifting. 
        // Note: (b * 2^i) can exceed 32-bit range during calculation, 
        // so we check if (a >>> i) >= b using unsigned right shift.
        if ((a >>> i) >= b) {
            a -= (b * Math.pow(2, i));
            quotient += Math.pow(2, i);
        }
    }
    return isNegative ? -quotient : quotient;
};
