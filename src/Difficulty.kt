enum class Difficulty(val words: List<String>, val maxAttempts: Int) {
    EASY(listOf("apple", "banana", "grape", "pear", "plum"), 6),
    MEDIUM(listOf("pineapple", "strawberry", "blueberry", "raspberry", "watermelon"), 6),
    HARD(listOf("pomegranate", "cantaloupe", "persimmon", "cranberry", "boysenberry"), 6);

    fun getRandomWord(): String {
        return words.random()
    }
}
