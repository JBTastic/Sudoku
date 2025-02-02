fun getDifficulty(): Int? {
    var difficulty: Int? = null
    while (difficulty !in listOf(1,2,3)) {
        println("Enter difficulty level:\n1 = Easy\n2 = Medium (default)\n3 = Hard")
        val input = readLine()
        if (input.isNullOrEmpty()) {
            return 2
        }
        try {
            val number = input?.toInt()
            if (number in listOf(1,2,3, -1)) {
                return number
            } else {
                println("Invalid difficulty level! Please enter 1, 2, or 3.")
            }
        } catch (e: Exception) {
            println("Invalid difficulty level! Please enter 1, 2, or 3.")
        }
    }
    return 2
}