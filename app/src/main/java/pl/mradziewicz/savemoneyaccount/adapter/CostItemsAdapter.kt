package pl.mradziewicz.savemoneyaccount.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import pl.mradziewicz.savemoneyaccount.R
import pl.mradziewicz.savemoneyaccount.model.CostItems
import pl.mradziewicz.savemoneyaccount.model.Expenses
import java.util.*

class CostItemsAdapter(
    val arrayList: Optional<Expenses>?,
) : RecyclerView.Adapter<CostItemsAdapter.ExpenseItemHolder>(){

    inner class ExpenseItemHolder(val view: View) : RecyclerView.ViewHolder(view){
        val costExpenseItem = view.findViewById<TextView>(R.id.value_expenseItem_TV)
        val nameExpenseItem = view.findViewById<TextView>(R.id.name_expenseItem_TV)

        fun bind(expenses: Expenses){
            costExpenseItem.text = expenses..toString()
            nameExpenseItem.text = costItems.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpenseItemHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list_expense_item, parent, false)

        return ExpenseItemHolder(view)
    }

    override fun onBindViewHolder(holder: ExpenseItemHolder, position: Int) {
        holder.bind(arrayList?.get(position))
    }

    override fun getItemCount(): Int {
        return arrayList.
    }

}