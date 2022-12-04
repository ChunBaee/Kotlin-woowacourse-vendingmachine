package bridge

class Vending {
    var vendingCoins = mutableListOf<Pair<Int, Int>>()

    fun divide(price : Int) {
        var mPrice = price
        for(i in Coin.values()) {
            vendingCoins.add(Pair(Coin.valueOf(i.name).returnPrice(), mPrice / Coin.valueOf(i.name).returnPrice()))
            mPrice %= Coin.valueOf(i.name).returnPrice()
        }
        PrintForm().noticeVendingHavePrice(vendingCoins)
    }

    fun addProducts() {
        PrintForm().noticeInputProducts()

    }
}