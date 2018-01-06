package com.example.diego.financask.extension

import java.math.BigDecimal
import java.text.DecimalFormat
import java.util.*

fun BigDecimal.formatedCurrency(): String {
    val brazilianFormat = DecimalFormat.getCurrencyInstance(Locale("pt", "br"))
    return brazilianFormat
            .format(this)
            .replace("R$", "R$ ")
}
