fun isValid(row: Int, col: Int, num: Int): Boolean {
    // check row
    for (i in 0 until cols-1) {
        if (board[row][i] == num) {
            return false
        }
    }

    // check column
    for (i in 0 until rows-1) {
        if (board[i][col] == num) {
            return false
        }
    }

    // check 3x3 block
    val startRow = row / 3 * 3
    val startCol = col / 3 * 3
    for (i in startRow until startRow + 3) {
        for (j in startCol until startCol + 3) {
            if (board[i][j] == num) {
                return false
            }
        }
    }

    return true
}