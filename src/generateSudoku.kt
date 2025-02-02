import kotlin.random.Random

fun generateSudoku(difficulty: Int) {
    // delete some cells based on the difficulty level
    val emptyCells = when (difficulty) {
        1 -> 10
        2 -> 20
        3 -> 30
        else -> 20
    }
    var i = 0
    while (i < emptyCells) {
        val row = Random.nextInt(0, rows)
        val col = Random.nextInt(0, cols)
        if (board[row][col] != 0) {
            board[row][col] = 0
            i++
        }
    }
    // saves the unmodified numbers so we know which cells are not to be modified
    for (i in 0 until rows) {
        for (j in 0 until cols) {
            if (board[i][j] != 0) {
                unmodifiedNumbers.add(Pair(i+1, j+1))
            }
        }
    }
}