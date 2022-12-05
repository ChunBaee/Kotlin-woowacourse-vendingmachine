package bridge

class PrintForm {

    fun noticeInputVendingPrice() {
        println("자판기가 보유하고 있는 금액을 입력해 주세요.")
    }

    fun noticeErrorMessage(error : Error) {
        println("[ERROR] ${error.returnErrorMessage()}")
    }

    fun noticeVendingHavePrice(coinList : MutableList<Pair<Int,Int>>) {
        println("자판기가 보유한 동전")
        for(i in coinList) {
            println("${i.first}원 - ${i.second}개")
        }
    }

    fun noticeInputProducts() {
        println("상품명과 가격, 수량을 입력해 주세요.")
    }

    fun noticeInputUserPrice() {
        println("투입 금액을 입력해주세요.")
    }

    fun noticeCurrentMoney(money : Int) {
        println("투입 금액: ${money}원")
    }

    fun noticeInputProductName() {
        println("구매할 상품명을 입력해 주세요.")
    }

    fun noticeVendingResult(jandonList : MutableList<Pair<Int, Int>>) {
        println("잔돈")
        for(i in jandonList.filter { it.second != 0 }) {
            println("${i.first}원 - ${i.second}개")
        }
    }
}