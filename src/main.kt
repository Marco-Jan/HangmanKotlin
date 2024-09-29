fun main() {
    val ui = HangmanUI()

    do {
        val difficulty = setupGame(ui)
        val controller = HangmanController(difficulty)

        // Spielschleife
        while (!controller.isGameWon && !controller.isGameLost) {
            ui.displayGameStatus(controller)
            val guess = ui.askForLetter()

            if (guess == null || !guess.isLetter()) {
                println("Ungültige Eingabe. Bitte gib einen Buchstaben ein.")
                continue
            }

            if (controller.guessLetter(guess)) {
                println("Richtig!")
            } else {
                println("Falsch!")
                ui.drawHangman(controller.attemptsLeft)
            }
        }

        ui.displayEndMessage(controller, difficulty.getRandomWord())
    } while (ui.askToPlayAgain())

    println("Danke fürs Spielen!")
}

fun setupGame(ui: HangmanUI): Difficulty {
    ui.displayWelcomeMessage()
    ui.displayDifficultySelection()

    return when (readLine()?.toIntOrNull()) {
        1 -> Difficulty.EASY
        2 -> Difficulty.MEDIUM
        3 -> Difficulty.HARD
        else -> Difficulty.EASY
    }
}
