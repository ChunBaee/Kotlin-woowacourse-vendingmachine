package bridge

enum class Error(private val message : String) {
    INPUT_INCLUDE_WORDS("금액은 숫자여야 합니다."), INPUT_PRODUCT_HAS_WRONG_FORM("상품 추가 입력값이 잘못되었습니다."), INPUT_PRICE_IS_WRONG("투입 금액은 숫자여야 합니다."), INPUT_PRODUCT_IS_WRONG("상품 입력에 오류가 있습니다.");

    fun returnErrorMessage() : String = message
}