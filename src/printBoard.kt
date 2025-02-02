fun printBoard(difficulty: Int) {
    println("-".repeat(31))
    for (i in 0 until rows) {
        for (j in 0 until cols) {
            // add vertical lines after every 3rd cell (only for indices 0, 3, 6)
            if ((j == 0) || (j%3 == 0)) {
                print("|")
            }

            // print the numbers in the cells
            when (difficulty) {
                1 -> {
                    if (Pair(i+1, j+1) in unmodifiedNumbers) {
                        print(" ${green}${board[i][j]}${reset} ")
                    } else if (board[i][j] == 0) {
                        print(" ${gray}${board[i][j]}${reset} ")
                    } else {
                        print(" ${blue}${board[i][j]}${reset} ")
                    }
                }
                2 -> {
                    if (Pair(i+1, j+1) in unmodifiedNumbers) {
                        print(" ${yellow}${board[i][j]}${reset} ")
                    } else if (board[i][j] == 0) {
                        print(" ${gray}${board[i][j]}${reset} ")
                    } else {
                        print(" ${blue}${board[i][j]}${reset} ")
                    }
                }
                3 -> {
                    if (Pair(i+1, j+1) in unmodifiedNumbers) {
                        print(" ${red}${board[i][j]}${reset} ")
                    } else if (board[i][j] == 0) {
                        print(" ${gray}${board[i][j]}${reset} ")
                    } else {
                        print(" ${blue}${board[i][j]}${reset} ")
                    }
                }
                else -> {
                    if (Pair(i+1, j+1) in unmodifiedNumbers) {
                        print(" ${yellow}${board[i][j]}${reset} ")
                    } else if (board[i][j] == 0) {
                        print(" ${gray}${board[i][j]}${reset} ")
                    } else {
                        print(" ${blue}${board[i][j]}${reset} ")
                    }
                }
            }



/*
            if (board[i][j] == 0) {
                print(" ${board[i][j]} ")
            } else if (Pair(i+1, j+1) in unmodifiedNumbers) {
                print(" ${red}${board[i][j]}${reset} ")
            } else {
                print(" ${underline}${board[i][j]}${reset} ")
            }
*/


            // add vertical lines after last cell
            if (j == cols-1) {
                print("|")
            }
        }

        println()

        // add horizontal line after every 3rd block (only for indices 0, 3, 6, 9)
        if ((i + 1) % 3 == 0 && i != rows) {
            println("-".repeat(31))
        }
    }
}