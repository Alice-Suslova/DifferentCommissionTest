package ru.netology

fun main() {

    calculateСommission("MasterCard", 40_000) // true
    calculateСommission("MasterCard", 80_000) // true
    calculateСommission("MasterCard", 100_000, 550_000) // false
    calculateСommission("Maestro", 3_000) // true
    calculateСommission("Maestro", 120_000, 100_000) // true
    calculateСommission("Maestro", 900_000) // false
    calculateСommission("Visa", 90_000) // true
    calculateСommission("Visa", 120_000, 500_000) // false
    calculateСommission("Мир", 110_000) // true
    calculateСommission("Мир", 110_000, 550_000) // false
    calculateСommission(amount = 1_000)// true
    calculateСommission(amount = 1_000_000)// false

}

fun calculateСommission  (    // сделать тип Int
    cardType: String = "VK Pay",
    amount: Int,
    oldTransfers: Int = 0
) : Int {

    var commission = 0

    if (isLimitExceeded(cardType, amount, oldTransfers)) {
         when (cardType) {
            "MasterCard", "Maestro" -> if ((amount + oldTransfers) < 75_000) {
                commission = 0
            } else {
                commission = (amount * 0.006).toInt() + 20
            }
            "Visa", "Мир"  -> if ((amount * 0.0075) < 35) {  //max !!!
                commission = 35
            } else {
                commission = (amount * 0.0075).toInt()  // отрицательное число
            }
            "VK Pay" -> commission = 0
        }
        println("Комиссия за перевод составляет $commission")
    }
    return commission
}


fun isLimitExceeded(cardType: String, amount: Int, oldTransfers: Int): Boolean {

    val limitAtOneTime = 150_000
    val summaryLimit = 600_000

    val limitAtOneTimeVk = 15_000
    val summaryLimitVk = 40_000

    if ((cardType == "MasterCard" || cardType == "Maestro" || cardType == "Visa" || cardType == "Мир")
        && (amount < limitAtOneTime && (amount + oldTransfers) < summaryLimit)
    ) {
        return true
    } else if ((cardType == "VK Pay")
        && (amount < limitAtOneTimeVk && (amount + oldTransfers) < summaryLimitVk)
    ) {
        return true
    } else {
        println("Операция отклонена, превышен лимит переводов.")
        return false
    }
}

