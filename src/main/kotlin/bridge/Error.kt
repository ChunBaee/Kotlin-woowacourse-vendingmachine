package bridge

enum class Error(private val message : String) {
    INPUT_INCLUDE_WORDS("금액은 숫자여야 합니다.");

    fun returnErrorMessage() : String = message
}