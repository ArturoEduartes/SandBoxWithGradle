object StringUtils {
    fun isPalindrome(text: String): Boolean {
        val cleaned = text.replace("\\s+".toRegex(), "").toLowerCase()
        val plain = StringBuilder(cleaned)
        val reversed = plain.reverse().toString()
        return reversed == cleaned
    }
}