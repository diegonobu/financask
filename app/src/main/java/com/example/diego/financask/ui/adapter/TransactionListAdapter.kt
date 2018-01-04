package com.example.diego.financask.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.diego.financask.R
import com.example.diego.financask.extension.formatedDate
import com.example.diego.financask.model.Transaction
import kotlinx.android.synthetic.main.transacao_item.view.*

class TransactionListAdapter(
        context: Context,
        transactions: List<Transaction>
) : BaseAdapter() {

    private val context = context
    private val transactions = transactions

    override fun getView(pos: Int, view: View?, parent: ViewGroup?): View {
        val viewCreated = LayoutInflater.from(context)
                .inflate(R.layout.transacao_item, parent, false)

        val transaction = transactions[pos]

        viewCreated.transacao_valor.text = transaction.value.toString()
        viewCreated.transacao_categoria.text = transaction.category
        viewCreated.transacao_data.text = transaction.date.formatedDate()
        return viewCreated
    }

    override fun getItem(pos: Int): Transaction {
        return transactions[pos]
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return transactions.size
    }

}