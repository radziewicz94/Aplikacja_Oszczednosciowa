package pl.mradziewicz.savemoneyaccount.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pl.mradziewicz.savemoneyaccount.R

class ExpenseItemAdapter : RecyclerView.Adapter<ExpenseItemAdapter.ExpenseItemHolder>(){

    inner class ExpenseItemHolder(val view: View) : RecyclerView.ViewHolder(view){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpenseItemHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_add_cost, parent, false)

        return ExpenseItemHolder(view)
    }

    override fun onBindViewHolder(holder: ExpenseItemHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

}