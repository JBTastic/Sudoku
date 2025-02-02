fun solveSudoku(): Boolean {
    for (row in 0 until rows) {
        for (col in 0 until cols) {
            if (board[row][col] == 0) {
                // try all numbers from 1 to 9
                val numbers = (1..9).toList().shuffled()
                for (num in numbers) {
                    if (isValid(row, col, num)) {
                        board[row][col] = num
                        if (solveSudoku()) {
                            return true
                        }
                        // backtracking
                        board[row][col] = 0
                    }
                }
                return false
            }
        }
    }
    // board is solved
    return true
}