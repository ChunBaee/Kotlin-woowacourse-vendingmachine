package bridge

import bridge.Regex
import camp.nextstep.edu.missionutils.Console

class Vending {
    fun divide(price: Int): MutableList<Pair<Int, Int>> {
        val vendingCoins = mutableListOf<Pair<Int, Int>>()
        var mPrice = price
        for (i in Coin.values()) {
            vendingCoins.add(Pair(Coin.valueOf(i.name).returnPrice(), mPrice / Coin.valueOf(i.name).returnPrice()))
            mPrice %= Coin.valueOf(i.name).returnPrice()
        }
        PrintForm().noticeVendingHavePrice(vendingCoins)
        return vendingCoins
    }

    fun getProductList(productList: MutableList<String>): MutableList<Products> {
        val mProductList = mutableListOf<Products>()
        for (i in productList.indices) {
            productList[i] = removeGwalho(productList[i])
            mProductList += addToProductList(productList[i])
        }
        return mProductList
    }

    private fun removeGwalho(input: String): String {
        return input.replace("[", "").replace("]", "")
    }

    private fun addToProductList(input: String): Products {
        val productForm = input.split(",")
        return Products(productForm[0], productForm[1].toInt(), productForm[2].toInt())
    }

    fun returnJandon(vendingCoin: MutableList<Pair<Int, Int>>, returnCoin: Int) {
        val jandonPair = mutableListOf<Pair<Int,Int>>()
        var mReturnCoin = returnCoin
        for(i in vendingCoin.filter { it.second != 0 }) {
            if(mReturnCoin / i.first >= i.second && mReturnCoin < 1000) {
                jandonPair.add(Pair(i.first, i.second))
                mReturnCoin -= i.first * i.second
            }
        }
        PrintForm().noticeVendingResult(jandonPair)
    }
}