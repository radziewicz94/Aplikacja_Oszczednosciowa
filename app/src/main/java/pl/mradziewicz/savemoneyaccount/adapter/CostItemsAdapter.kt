package pl.mradziewicz.savemoneyaccount.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import pl.mradziewicz.savemoneyaccount.R
import pl.mradziewicz.savemoneyaccount.model.CostItems

class CostItemsAdapter(
    private val arrayList: MutableList<CostItems>?,
) : RecyclerView.Adapter<CostItemsAdapter.ExpenseItemHolder>(){

    inner class ExpenseItemHolder(val view: View) : RecyclerView.ViewHolder(view){
        private val costExpenseItem = view.findViewById<TextView>(R.id.value_expenseItem_TV)
        private val nameExpenseItem = view.findViewById<TextView>(R.id.name_expenseItem_TV)
        val trash = view.findViewById<ImageView>(R.id.trashImage_expenseItem_BTN)
        fun bind(costItems: CostItems){
            costExpenseItem.text = costItems.name
            nameExpenseItem.text = costItems.value.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpenseItemHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list_expense_item, parent, false)

        return ExpenseItemHolder(view)
    }

    override fun onBindViewHolder(holder: ExpenseItemHolder, position: Int) {
        holder.bind(arrayList?.get(position)!!)
        holder.trash.setOnClickListener {
            alertDialog(holder, position)
        }
    }
    private fun alertDialog(holder: ExpenseItemHolder, position: Int) {
        val alert = AlertDialog.Builder(holder.view.context)
            .setTitle("Usunięcie notatkę ${arrayList?.get(position)?.name}")
            .setMessage("Czy jesteś pewien że chcesz to usunąć")

        alert.setPositiveButton(android.R.string.ok) { dialog, id ->
            arrayList?.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, arrayList?.size!!)
        }
        alert.setNegativeButton(android.R.string.cancel) { dialog, id ->
            dialog.cancel()
        }

        alert.show()
    }

    override fun getItemCount(): Int {
        return arrayList?.size!!
    }

}