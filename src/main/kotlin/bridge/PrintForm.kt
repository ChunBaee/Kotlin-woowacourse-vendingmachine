package bridge

class PrintForm {

    fun noticeInputVendingPrice() {
        println("자판기가 보유하고 있는 금액을 입력해 주세요.")
    }

    fun noticeErrorMessage(error : Error) {
        println("[ERROR] ${error.returnErrorMessage()}")
    }
}