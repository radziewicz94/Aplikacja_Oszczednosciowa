package pl.mradziewicz.savemoneyaccount

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class MonthlyExpenseAdapter: RecyclerView.Adapter<MyViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.list_monthly_expenses, viewGroup, false)

        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.title.text = CostsDataBase.listOfTitleExpenses[position]
        holder.desc.text = CostsDataBase.listOfDescExpenses[position]

    }

    override fun getItemCount(): Int {
        return CostsDataBase.listOfTitleExpenses.size
    }
}

class MyViewHolder(val view: View): RecyclerView.ViewHolder(view){
    val title: TextView = view.findViewById(R.id.title_textView)
    val desc: TextView = view.findViewById(R.id.description_textView)

}