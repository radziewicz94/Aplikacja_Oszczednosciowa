package pl.mradziewicz.savemoneyaccount.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import pl.mradziewicz.savemoneyaccount.MainActivity
import pl.mradziewicz.savemoneyaccount.R
import pl.mradziewicz.savemoneyaccount.model.Expenses
import pl.mradziewicz.savemoneyaccount.viewmodel.ExpenseViewModel

class MonthlyExpenseAdapter(
    var expenseViewModel: ExpenseViewModel,
    var arrayList: ArrayList<Expenses>,
    var mainActivity: MainActivity
) : RecyclerView.Adapter<MyViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.list_monthly_expenses, viewGroup, false)

        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        //holder.title.text = CostsDataBase.listOfTitleExpenses[position]
        //holder.desc.text = CostsDataBase.listOfDescExpenses[position]
        holder.bind(arrayList[position])
    }

    override fun getItemCount(): Int {
        println(arrayList.size)
        println(arrayList.size)
        println(arrayList.size)
        println(arrayList.size)
        println(arrayList.size)
        println(arrayList.size)
        println(arrayList.size)
        return arrayList.size
    }
}

class MyViewHolder(val view: View): RecyclerView.ViewHolder(view){
    val title: TextView = view.findViewById(R.id.title_textView)
    val desc: TextView = view.findViewById(R.id.description_textView)

    fun bind(expenses: Expenses) {
        title.text = expenses.title
        desc.text = expenses.desc
        println(expenses.title)
        println(expenses.title)
        println(expenses.title)
        println(expenses.title)
        println(expenses.title)
        println(expenses.title)
    }


}