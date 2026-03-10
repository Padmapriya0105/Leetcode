/**
 * @param {number} rowsCount
 * @param {number} colsCount
 * @return {Array<Array<number>>}
 */
Array.prototype.snail = function(rowsCount, colsCount) {
    // Check if the dimensions match the array length
    if (rowsCount * colsCount !== this.length) {
        return [];
    }

    // Initialize the 2D array with empty rows
    const result = Array.from({ length: rowsCount }, () => []);

    for (let i = 0; i < this.length; i++) {
        const col = Math.floor(i / rowsCount);
        const rowInCol = i % rowsCount;
        
        // If column is even, go top-to-bottom (0, 1, 2...)
        // If column is odd, go bottom-to-top (rowsCount-1, rowsCount-2...)
        const row = col % 2 === 0 
            ? rowInCol 
            : (rowsCount - 1 - rowInCol);
        
        result[row][col] = this[i];
    }

    return result;
}
