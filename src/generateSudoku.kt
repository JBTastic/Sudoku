import kotlin.random.Random

fun generateSudoku(difficulty: Int) {
    // Zufällige Anzahl von Feldern löschen, um das Sudoku zu generieren
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
}