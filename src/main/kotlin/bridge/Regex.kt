package bridge

class Regex {

    fun checkVendingHavePrice(userInput: String): Boolean {
        return try {
            checkIsItNumber(userInput)
            true
        } catch (exception: IllegalArgumentException) {
            PrintForm().noticeErrorMessage(Error.INPUT_INCLUDE_WORDS)
            false
        }
    }

    fun checkProduct(userInput: String): Boolean {
        return try {
            checkSemiColon(userInput)
            checkEachPriceAndAmount(userInput)
            true
        } catch (exception: IllegalArgumentException) {
            PrintForm().noticeErrorMessage(Error.INPUT_PRODUCT_HAS_WRONG_FORM)
            false
        }
    }

    fun checkUserInputPrice(userInput: String): Boolean {
        return try {
            checkIsItNumber(userInput)
            true
        } catch (exception: IllegalArgumentException) {
            PrintForm().noticeErrorMessage(Error.INPUT_PRICE_IS_WRONG)
            false
        }
    }

    fun checkIsCorrectProduct(userInput: String, inputMoney: Int, productList: MutableList<Products>): Boolean {
        return try {
            checkProductNameExists(userInput, productList)
            checkUserCanBuyThis(inputMoney, productList.find { it.productName == userInput }!!.price)
            true
        } catch (exception: IllegalArgumentException) {
            PrintForm().noticeErrorMessage(Error.INPUT_PRODUCT_IS_WRONG)
            false
        }
    }

    private fun checkProductNameExists(userInput: String, productList: MutableList<Products>) {
        if (!productList.any { it.productName == userInput }) throw IllegalArgumentException()
    }

    private fun checkUserCanBuyThis(inputMoney: Int, productPrice: Int) {
        if(inputMoney < productPrice) throw IllegalArgumentException()
    }

    private fun checkIsItNumber(userInput: String) {
        //!Pattern.matches("^[1-9]*$", userInput)
        if (!userInput.chars().allMatch { Character.isDigit(it) }) throw IllegalArgumentException()
    }

    private fun checkIsItInRange(userInput : String) {
        if(userInput.toInt() < 100 || userInput.toInt() % 10 != 0) throw IllegalArgumentException()
    }

    private fun checkSemiColon(userInput: String) {
        if (userInput.count { it == '[' } != userInput.count { it == ';' } + 1) throw IllegalArgumentException()
    }

    private fun checkEachPriceAndAmount(userInput: String) {
        val mList = userInput.split(";").toMutableList()
        checkItHasAllGwalHo(userInput, mList)
        for (i in mList) {
            checkItHaveAllElement(i)
            checkPriceIsRightNumber(i)
            checkAmountIsNumber(i)
        }
    }

    private fun checkItHasAllGwalHo(userInput: String, list: MutableList<String>) {
        if (list.size != userInput.count { it == '[' } || list.size != userInput.count { it == ']' }) throw IllegalArgumentException()
    }

    private fun checkItHaveAllElement(userInput: String) {
        val mList = userInput.split(",")
        if (mList.size != 3) throw IllegalArgumentException()
    }

    private fun checkPriceIsRightNumber(userInput: String) {
        val mList = userInput.split(",")
        checkIsItNumber(mList[1])
        checkIsItInRange(mList[1])
    }

    private fun checkAmountIsNumber(userInput: String) {
        val mList = userInput.split(",")
        checkIsItNumber(mList[2].replace("]", ""))
    }
}