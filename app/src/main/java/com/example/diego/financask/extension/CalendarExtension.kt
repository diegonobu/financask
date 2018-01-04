package com.example.diego.financask.extension

import java.text.SimpleDateFormat
import java.util.*

fun Calendar.formatedDate(): String {
    val simpleDateFormat = SimpleDateFormat("dd/MM/yyyy")
    return simpleDateFormat.format(this.time)
}