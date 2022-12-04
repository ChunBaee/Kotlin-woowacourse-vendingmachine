package bridge

const val VENDING_MACHINE_HAVE_MONEY = 0
const  val VENDING_PRODUCTS = 1
const val USER_INPUT_PRICE = 2

fun main() {
    startProgram()
}

private fun startProgram() {
    val vendingCoins = Vending().divide(UserInput().inputTotalLogic(VENDING_MACHINE_HAVE_MONEY).toString().toInt())
    val productList = Vending().getProductList(UserInput().inputTotalLogic(VENDING_PRODUCTS) as MutableList<String>)

    val userInputPrice = UserInput().inputTotalLogic(USER_INPUT_PRICE).toString().toInt()

    val jandon = Buy(userInputPrice, productList).buyProducts()

    Vending().returnJandon(vendingCoins, jandon)
}


