fun playerMove(): Boolean {
    println("Enter row, column (1-9) and number (0-9) separated by spaces:")

    try {
        // reads the input from the player and splits it into three integers
        val (row, col, num) = readLine()!!.split(" ").map { it.toInt() }

        // checks if the inpus is in the valid range 1..9
        if (row in 1..9 && col in 1..9 && num in 0..9 && Pair(row, col) !in unmodifiedNumbers) {
            board[row-1][col-1] = num
            return true
        } else if (row == -1 && col == -1 && num == -1) {
            println("Goodbye!")
            System.exit(0)
            return false            
        } else {
            println("Invalid input! Row and column must be between 1 and 9, number must be between 0 and 9, you can only edit empty cells.")
            return false
        }
    } catch (e: Exception) {
        // if the input is not valid, catch the exception and print an error message
        println("Invalid input! Please enter valid integers separated by spaces.")
        return false
    }
}