/**
 * @param {Array} arr
 * @param {number} depth
 * @return {Array}
 */
var flat = function (arr, n) {
    if (n === 0) return arr;
    
    const result = [];
    
    function helper(currentArray, currentDepth) {
        for (const item of currentArray) {
            // Check if item is an array AND we haven't exceeded the depth limit
            if (Array.isArray(item) && currentDepth < n) {
                helper(item, currentDepth + 1);
            } else {
                result.push(item);
            }
        }
    }
    
    helper(arr, 0);
    return result;
};
