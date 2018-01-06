package com.example.diego.financask.ui.adapter

import android.content.Context
import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.diego.financask.R
import com.example.diego.financask.extension.formatedCurrency
import com.example.diego.financask.extension.formatedDate
import com.example.diego.financask.model.Transaction
import com.example.diego.financask.model.Type
import kotlinx.android.synthetic.main.transacao_item.view.*

class TransactionListAdapter(
        private val context: Context,
        private val transactions: List<Transaction>
) : BaseAdapter() {

    override fun getView(pos: Int, view: View?, parent: ViewGroup?): View {
        val viewCreated = LayoutInflater.from(context)
                .inflate(R.layout.transacao_item, parent, false)

        val transaction = transactions[pos]

        addValue(transaction, viewCreated)
        addIco(transaction, viewCreated)
        viewCreated.transacao_categoria.text = transaction.category
        viewCreated.transacao_data.text = transaction.date.formatedDate()
        return viewCreated
    }

    private fun addIco(transaction: Transaction, viewCreated: View) {
        val ico: Int = colorBy(transaction.type)
        viewCreated.transacao_icone.setBackgroundResource(ico)
    }

    private fun colorBy(type: Type): Int {
        return if (type == Type.INCOME)
            R.drawable.icone_transacao_item_receita
        else
            R.drawable.icone_transacao_item_despesa
    }

    private fun addValue(transaction: Transaction, viewCreated: View) {
        val color: Int = if (transaction.type == Type.INCOME)
            ContextCompat.getColor(context, R.color.receita)
        else
            ContextCompat.getColor(context, R.color.despesa)

        viewCreated.transacao_valor.setTextColor(color)
        viewCreated.transacao_valor.text = transaction.value.formatedCurrency()
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