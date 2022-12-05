package bridge

import camp.nextstep.edu.missionutils.Console

class Buy(private var userInput: Int, private var productList: MutableList<Products>) {
    private var orderPair = mutableListOf<String>()

    fun buyProducts(): Int {
        var isFinished = true
        var input = ""
        while (isFinished) {
            PrintForm().noticeCurrentMoney(userInput)
            PrintForm().noticeInputProductName()
            input = Console.readLine()
            if (Regex().checkIsCorrectProduct(input, userInput, productList)) {
                isFinished = buyLogic(input, productList)
            }
        }
        PrintForm().noticeCurrentMoney(userInput)
        return userInput
    }

    private fun buyLogic(productName: String, mProductList: MutableList<Products>): Boolean {
        return if (userInput >= mProductList.find { it.productName == productName }!!.price) {
            dropProductCount(productName)
            userInput -= mProductList.find { it.productName == productName }!!.price
            productList = mProductList
            if (orderPair.count { it == productName } == mProductList.find { it.productName == productName }!!.count) {
                false
            } else {
                (userInput > mProductList.minOf { it.price })
            }
        } else {
            false
        }
    }

    private fun dropProductCount(productName: String) {
        orderPair.add(productName)
    }

}