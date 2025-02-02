val rows = 9
val cols = 9
val board = Array(rows) { IntArray(cols) }
val red = "\u001B[31m"
val green = "\u001B[32m"
val yellow = "\u001B[33m"
val blue = "\u001B[34m"
val reset = "\u001B[0m"

fun isBoardFull(): Boolean {
    for (i in 0 until rows) {
        for (j in 0 until cols) {
            if (board[i][j] == 0) {
                return false
            }
        }
    }
    return true
}

fun fillBoardWithZeros() {
    for (i in 0 until rows) {
        for (j in 0 until cols) {
            board[i][j] = 0
        }
    }
}

fun main() {
    // generate a solved sudoku board
    solveSudoku()

    // get the difficulty from user input
    val difficulty = getDifficulty()

    // delete some cells based on the difficulty level
    generateSudoku(difficulty!!)

    // print the board
    printBoard()

    // as long as the board is not solved, let the player make a move and then print the board
    while (!isSolved()) {
        playerMove()
        printBoard()
    }

    // when the player won, print a congratulatory message
    println("Congratulations! You solved the Sudoku!")
}