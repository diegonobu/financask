package com.example.diego.financask.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.diego.financask.R
import com.example.diego.financask.model.Transaction
import com.example.diego.financask.model.Type
import com.example.diego.financask.ui.adapter.TransactionListAdapter
import kotlinx.android.synthetic.main.activity_lista_transacoes.*
import java.math.BigDecimal

class TransactionListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_transacoes)

        val transactions = fillList()

        lista_transacoes_listview.adapter = TransactionListAdapter(this, transactions)
    }

    private fun fillList(): List<Transaction> {
        return listOf(
                Transaction(BigDecimal(20.50), "Almoço de final de semana", type = Type.EXPENSE),
                Transaction(BigDecimal(20.50), type = Type.EXPENSE),
                Transaction(BigDecimal(100.00), "Economia", Type.INCOME)
        )
    }
}