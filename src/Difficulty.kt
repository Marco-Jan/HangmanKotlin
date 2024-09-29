enum class Difficulty(val words: List<String>, val maxAttempts: Int) {
    EASY(listOf("apple", "banana", "grape", "pear", "plum"), 8),
    MEDIUM(listOf("pineapple", "strawberry", "blueberry", "raspberry", "watermelon"), 6),
    HARD(listOf("pomegranate", "cantaloupe", "persimmon", "cranberry", "boysenberry"), 4);

    fun getRandomWord(): String {
        return words.random()
    }
}
