fun isSolved(): Boolean {
    // Überprüfen, ob alle Zellen ausgefüllt sind
    for (i in 0 until rows) {
        for (j in 0 until cols) {
            if (board[i][j] == 0) {
                return false // Ein leeres Feld gefunden, daher nicht gelöst
            }
        }
    }

    // Überprüfen, ob alle Zeilen gültig sind (keine Duplikate und enthält alle Zahlen von 1 bis 9)
    for (i in 0 until rows) {
        if (!isValidUnit(board[i])) {
            return false // Ungültige Zeile
        }
    }

    // Überprüfen, ob alle Spalten gültig sind
    for (j in 0 until cols) {
        val column = IntArray(rows)
        for (i in 0 until rows) {
            column[i] = board[i][j]
        }
        if (!isValidUnit(column)) {
            return false // Ungültige Spalte
        }
    }

    // Überprüfen, ob alle 3x3 Blöcke gültig sind
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
                return false // Ungültiger Block
            }
        }
    }

    return true // Sudoku ist vollständig und korrekt
}

// Hilfsfunktion zur Überprüfung, ob eine Einheit (Zeile, Spalte oder Block) gültig ist
fun isValidUnit(unit: IntArray): Boolean {
    return unit.toSet().size == unit.size && unit.all { it in 1..9 }
}