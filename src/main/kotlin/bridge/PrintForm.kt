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
}