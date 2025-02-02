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