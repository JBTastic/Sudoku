fun solveSudoku(): Boolean {
    for (row in 0 until rows) {
        for (col in 0 until cols) {
            if (board[row][col] == 0) {
                val numbers = (1..9).toList().shuffled() // Zufällige Reihenfolge der Zahlen
                for (num in numbers) {
                    if (isValid(row, col, num)) {
                        board[row][col] = num
                        if (solveSudoku()) {
                            return true
                        }
                        board[row][col] = 0 // Rückgängig machen (Backtracking)
                    }
                }
                return false // Keine gültige Zahl gefunden
            }
        }
    }
    return true // Das Board ist voll ausgefüllt
}