class HangmanController(private val difficulty: Difficulty) {
    private val word: String = difficulty.getRandomWord()
    private val hiddenWord = word.toCharArray()
    private val guessedWord = CharArray(word.length) { '_' }
    private val incorrectGuesses = mutableListOf<Char>()
    var attemptsLeft = difficulty.maxAttempts
        private set

    val isGameWon: Boolean
        get() = !guessedWord.contains('_')

    val isGameLost: Boolean
        get() = attemptsLeft <= 0

    fun getGuessedWord(): String = guessedWord.joinToString(" ")

    fun getIncorrectGuesses(): String = incorrectGuesses.joinToString(", ")

    fun guessLetter(letter: Char): Boolean {
        if (letter in guessedWord || letter in incorrectGuesses) {
            return false // Buchstabe wurde bereits geraten
        }

        if (letter in hiddenWord) {
            for (i in hiddenWord.indices) {
                if (hiddenWord[i] == letter) guessedWord[i] = letter
            }
            return true // Richtige Eingabe
        } else {
            incorrectGuesses.add(letter)
            attemptsLeft--
            return false // Falsche Eingabe
        }
    }
}
