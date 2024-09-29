class HangmanUI {
    fun displayWelcomeMessage() {
        println("Willkommen zum Hangman-Spiel!")
        println("Regeln: Du musst das versteckte Wort erraten, indem du Buchstaben eingibst.")
    }

    fun displayDifficultySelection() {
        println("Wähle einen Schwierigkeitsgrad: (1) Leicht, (2) Mittel, (3) Schwer")
    }

    fun displayGameStatus(game: HangmanController) {
        println("\nWort: ${game.getGuessedWord()}")
        println("Falsche Buchstaben: ${game.getIncorrectGuesses()}")
        println("Verbleibende Versuche: ${game.attemptsLeft}")
    }

    fun displayEndMessage(game: HangmanController, word: String) {
        if (game.isGameWon) {
            println("\nGlückwunsch! Du hast das Wort '$word' erraten!")
        } else {
            println("\nDu hast verloren. Das Wort war '$word'.")
        }
    }

    fun askForLetter(): Char? {
        print("Gib einen Buchstaben ein: ")
        return readLine()?.toLowerCase()?.getOrNull(0)
    }

    fun askToPlayAgain(): Boolean {
        println("Möchtest du noch einmal spielen? (j/n)")
        val restart = readLine()
        return restart?.toLowerCase() == "j"
    }

    fun drawHangman(attempts: Int) {
        when (attempts) {
            4 -> println("""
                ________
                |      |
                |      O
                |
                |
                |
                """.trimIndent())
            3 -> println("""
                ________
                |      |
                |      O
                |      |
                |
                |
                """.trimIndent())
            2 -> println("""
                ________
                |      |
                |      O
                |     /|
                |
                |
                """.trimIndent())
            1 -> println("""
                ________
                |      |
                |      O
                |     /|\
                |
                |
                """.trimIndent())
            0 -> println("""
                ________
                |      |
                |      O
                |     /|\
                |     / 
                |
                """.trimIndent())
        }
    }
}
