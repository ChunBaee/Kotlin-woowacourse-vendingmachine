package bridge

import camp.nextstep.edu.missionutils.Console

class Buy(private var userInput: Int, private val productList: MutableList<Products>) {
    private var orderPair = mutableListOf<String>()

    fun buyProducts(): Int {
        var isFinished = true
        var input = ""
        while (isFinished) {
            PrintForm().noticeCurrentMoney(userInput)
            PrintForm().noticeInputProductName()
            input = Console.readLine()
            if (Regex().checkIsCorrectProduct(input, userInput, productList)) {
                isFinished = buyLogic(input)
            }
        }
        PrintForm().noticeCurrentMoney(userInput)
        return userInput
    }

    private fun buyLogic(productName: String): Boolean {
        return if (userInput >= productList.find { it.productName == productName }!!.price) {
            dropProductCount(productName)
            userInput -= productList.find { it.productName == productName }!!.price
            if (orderPair.count { it == productName } == productList.find { it.productName == productName }!!.count) {
                false
            } else {
                (userInput > productList.minOf { it.price })
            }
        } else {
            false
        }
    }

    private fun dropProductCount(productName: String) {
        orderPair.add(productName)
    }

}