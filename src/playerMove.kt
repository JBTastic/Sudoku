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