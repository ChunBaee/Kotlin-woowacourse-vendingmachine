package bridge

enum class Coin (private val amount: Int) {
    COIN_500(500), COIN_100(100), COIN_50(50), COIN_10(10);

    fun returnPrice (): Int = amount
}