package pl.mradziewicz.savemoneyaccount.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pl.mradziewicz.savemoneyaccount.Expense
import pl.mradziewicz.savemoneyaccount.R
import pl.mradziewicz.savemoneyaccount.model.ExpenseItem
import pl.mradziewicz.savemoneyaccount.viewmodel.ExpenseItemViewModel

class ExpenseItemAdapter(
    expenseItemViewModel: ExpenseItemViewModel,
    arrayList: ArrayList<ExpenseItem>,
    expense: Expense
) : RecyclerView.Adapter<ExpenseItemAdapter.ExpenseItemHolder>(){

    inner class ExpenseItemHolder(val view: View) : RecyclerView.ViewHolder(view){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpenseItemHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list_expense_item, parent, false)

        return ExpenseItemHolder(view)
    }

    override fun onBindViewHolder(holder: ExpenseItemHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

}