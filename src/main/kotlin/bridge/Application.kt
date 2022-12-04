package bridge

fun main() {
    startProgram()
}

private fun startProgram() {
    val vendingCoins = Vending().divide(UserInput().inputVendingAlreadyHave())
    val productList = Vending().getProductList(UserInput().inputVendingProducts())

    val userInputPrice = UserInput().inputUserPrice()

    val jandon = Buy(userInputPrice, productList).buyProducts()

    Vending().returnJandon(vendingCoins, jandon)
}


