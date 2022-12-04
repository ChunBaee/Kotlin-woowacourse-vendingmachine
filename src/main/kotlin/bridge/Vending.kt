package bridge

import bridge.Regex
import camp.nextstep.edu.missionutils.Console

class Vending {
    var vendingCoins = mutableListOf<Pair<Int, Int>>()
    var productList = mutableListOf<Products>()

    fun divide(price : Int) {
        var mPrice = price
        for(i in Coin.values()) {
            vendingCoins.add(Pair(Coin.valueOf(i.name).returnPrice(), mPrice / Coin.valueOf(i.name).returnPrice()))
            mPrice %= Coin.valueOf(i.name).returnPrice()
        }
        PrintForm().noticeVendingHavePrice(vendingCoins)
    }
}