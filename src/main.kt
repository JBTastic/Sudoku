val rows = 9
val cols = 9
val board = Array(rows) { IntArray(cols) }
var unmodifiedNumbers = mutableListOf<Pair<Int, Int>>()
val red = "\u001B[31m"
val green = "\u001B[32m"
val yellow = "\u001B[33m"
val blue = "\u001B[34m"
val magenta = "\u001B[35m"
val cyan = "\u001B[36m"
val black = "\u001B[30m"
val gray = "\u001B[90m"
val underline = "\u001B[4m"
val fat = "\u001B[1m"
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
    printBoard(difficulty)

    // as long as the board is not solved, let the player make a move and then print the board
    while (!isSolved()) {
        playerMove()
        printBoard(difficulty)
    }

    // when the player won, print a congratulatory message
    println("Congratulations! You solved the Sudoku!")
}