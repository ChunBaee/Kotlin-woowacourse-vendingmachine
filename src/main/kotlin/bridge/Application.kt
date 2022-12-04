package bridge

fun main() {
    startProgram()
}

private fun startProgram() {
    val vendingCoins = Vending().divide(UserInput().inputVendingAlreadyHave())
    val productList = Vending().getProductList(UserInput().inputVendingProducts())

}


