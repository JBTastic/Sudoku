import kotlin.random.Random

val rows = 9
val cols = 9
val board = Array(rows) { IntArray(cols) }

fun printBoard() {
    println("-".repeat(31))
    for (i in 0 until rows) {
        for (j in 0 until cols) {
            // Vertikale Trennlinien nach jedem 3. Feld hinzufügen (nur für Indizes 0, 3, 6)
            if ((j == 0) || (j%3 == 0)) {
                print("|")
            }

            // Drucke den Wert des aktuellen Feldes
            print(" ${board[i][j]} ")

            if (j == cols-1) {
                print("|")
            }
        }


        println() // Neue Zeile nach jeder Reihe

        
        
        // Horizontale Trennlinie nach jedem 3. Block hinzufügen (nur für Indizes 0, 3, 6)
        if ((i + 1) % 3 == 0 && i != rows) {
            println("-".repeat(31))  // Länge der Trennlinie ist 29, um 3x3 Blöcke zu trennen
        }
    }
}

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

fun isValid(row: Int, col: Int, num: Int): Boolean {
    // Überprüfe Zeile
    for (i in 0 until cols-1) {
        if (board[row][i] == num) {
            return false
        }
    }

    // Überprüfe Spalte
    for (i in 0 until rows-1) {
        if (board[i][col] == num) {
            return false
        }
    }

    // Überprüfe 3x3 Block
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

fun generateSudoku(difficulty: Int) {
    // Zufällige Anzahl von Feldern löschen, um das Sudoku zu generieren
    val emptyCells = when (difficulty) {
        1 -> 10
        2 -> 20
        3 -> 30
        else -> 20
    }

    for (i in 0 until emptyCells) {
        val row = Random.nextInt(0, rows)
        val col = Random.nextInt(0, cols)
        board[row][col] = 0
    }
}

fun playerMove(): Boolean {
    println("Enter row, column and number (1-9) separated by spaces:")

    try {
        // Liest die Eingabe und versucht, sie zu splitten und in Ganzzahlen zu konvertieren
        val (row, col, num) = readLine()!!.split(" ").map { it.toInt() }

        // Überprüft, ob die Werte im Bereich von 1 bis 9 liegen
        if (row in 1..9 && col in 1..9 && num in 1..9) {
            // Gültiger Zug
            board[row-1][col-1] = num
            return true
        } else if (row == -1 && col == -1 && num == -1) {
            println("Goodbye!")
            System.exit(0)
            return false            
        } else {
            println("Invalid input! Row, column, and number must be between 1 and 9.")
            return false
        }
    } catch (e: Exception) {
        // Falls eine Ausnahme auftritt (z.B. ungültige Eingabe oder nicht konvertierbare Werte)
        println("Invalid input! Please enter valid integers separated by spaces.")
        return false
    }
}

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



fun main() {
    //fillBoardWithZeros()
    solveSudoku()
    println("Enter difficulty level (1, 2, 3):")
    val difficulty = readLine()!!.toInt()
    generateSudoku(difficulty)
    printBoard()
    while (!isSolved()) {
        playerMove()
        printBoard()
    }
    println("Congratulations! You solved the Sudoku!")
}