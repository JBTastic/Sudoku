fun isSolved(): Boolean {
    // check if all cells are filled
    for (i in 0 until rows) {
        for (j in 0 until cols) {
            if (board[i][j] == 0) {
                return false // board is not solved
            }
        }
    }

    // check if all rows are valid
    for (i in 0 until rows) {
        if (!isValidUnit(board[i])) {
            return false // invalid row
        }
    }

    // check if all columns are valid
    for (j in 0 until cols) {
        val column = IntArray(rows)
        for (i in 0 until rows) {
            column[i] = board[i][j]
        }
        if (!isValidUnit(column)) {
            return false // invalid column
        }
    }

    // check if all 3x3 blocks are valid
    for (i in 0 until 9 step 3) {
        for (j in 0 until 9 step 3) {
            val block = IntArray(9)
            var index = 0
            for (di in 0..2) {
                for (dj in 0..2) {
                    block[index++] = board[i + di][j + dj]
                }
            }
            if (!isValidUnit(block)) {
                return false // invalid block
            }
        }
    }

    return true // sudoku is solved
}

// helperfunction to check if a unit (row, column, or block) is valid
fun isValidUnit(unit: IntArray): Boolean {
    return unit.toSet().size == unit.size && unit.all { it in 1..9 }
}