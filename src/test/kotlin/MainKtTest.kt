package ru.netology
import org.junit.Test
import org.junit.Assert.*

class MainKtTest {

    @Test
    fun calculateСommissionWithoutDiscountMasterCard() {
        val cardType = "MasterCard"
        val amount = 40_000
        val oldTransfers = 0

        val result = calculateСommission(cardType, amount, oldTransfers)

        assertEquals(0, result)
    }

    @Test
    fun calculateСommissionWithDiscountMasterCard() {
        val cardType = "MasterCard"
        val amount = 80_000
        val oldTransfers = 0

        val result = calculateСommission(cardType, amount, oldTransfers)

        assertEquals(500, result)
    }

    @Test
    fun calculateСommissionWithoutDiscountMaestro() {
        val cardType = "Maestro"
        val amount = 3_000
        val oldTransfers = 0

        val result = calculateСommission(cardType, amount, oldTransfers)

        assertEquals(0, result)
    }

    @Test
    fun calculateСommissionWithDiscountVisa() {
        val cardType = "Visa"
        val amount = 90_000
        val oldTransfers = 0

        val result = calculateСommission(cardType, amount, oldTransfers)

        assertEquals(675, result)
    }

    @Test
    fun calculateСommissionWithoutDiscountVisa() {
        val cardType = "Visa"
        val amount = 1_000
        val oldTransfers = 0

        val result = calculateСommission(cardType, amount, oldTransfers)

        assertEquals(35, result)
    }

    @Test
    fun calculateСommissionWithDiscountMir() {
        val cardType = "Мир"
        val amount = 110_000
        val oldTransfers = 0

        val result = calculateСommission(cardType, amount, oldTransfers)

        assertEquals(825, result)
    }

    @Test
    fun calculateСommissionWithoutDiscountMir() {
        val cardType = "Мир"
        val amount = 1_000
        val oldTransfers = 0

        val result = calculateСommission(cardType, amount, oldTransfers)

        assertEquals(35, result)
    }

    @Test
    fun calculateСommissionWithoutDiscountVKPay() {
        val cardType = "VK Pay"
        val amount = 10_000
        val oldTransfers = 0

        val result = calculateСommission(cardType, amount, oldTransfers)

        assertEquals(0, result)
    }

    @Test
    fun isLimitExceededTrueMasterCard() {
        val cardType = "MasterCard"
        val amount = 100_000
        val oldTransfers = 550_000

        val result = isLimitExceeded(cardType, amount, oldTransfers)

        assertEquals(false, result)
    }

    @Test
    fun isLimitExceededTrueMaestro() {
        val cardType = "Maestro"
        val amount = 900_000
        val oldTransfers = 0

        val result = isLimitExceeded(cardType, amount, oldTransfers)

        assertEquals(false, result)
    }

    @Test
    fun isLimitExceededTrueVisa() {
        val cardType = "Visa"
        val amount = 120_000
        val oldTransfers = 500_000

        val result = isLimitExceeded(cardType, amount, oldTransfers)

        assertEquals(false, result)
    }

    @Test
    fun isLimitExceededTrueMir() {
        val cardType = "Мир"
        val amount = 110_000
        val oldTransfers = 500_000

        val result = isLimitExceeded(cardType, amount, oldTransfers)

        assertEquals(false, result)
    }

    @Test
    fun isLimitExceededTrueVKPay() {
        val cardType = "VK Pay"
        val amount = 1_000_000
        val oldTransfers = 0

        val result = isLimitExceeded(cardType, amount, oldTransfers)

        assertEquals(false, result)
    }
}