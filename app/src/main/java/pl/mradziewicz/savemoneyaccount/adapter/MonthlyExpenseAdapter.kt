package pl.mradziewicz.savemoneyaccount.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import pl.mradziewicz.savemoneyaccount.AddNewGroupExpense
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
        holder.bind(arrayList[position])
        holder.trash.setOnClickListener {
            alertDialog(holder, position)
        }
        editNoteListener(holder, position)
    }

    private fun editNoteListener(holder: MyViewHolder, position: Int) {
        holder.cardView.setOnLongClickListener{ view ->
            var intent = Intent(view.context, AddNewGroupExpense::class.java)

            intent.putExtra("title", arrayList[position].title.toString())
            intent.putExtra("desc", arrayList[position].desc.toString())
            intent.putExtra("id", position)
            startActivity(view.context, intent, null)
            true
        }
    }

    private fun alertDialog(holder: MyViewHolder, position: Int){
        val alert = AlertDialog.Builder(holder.view.context)
            .setTitle("Usunięcie notatkę ${arrayList[position].title}")
            .setMessage("Czy jesteś pewien że chcesz to usunąć")

        alert.setPositiveButton(android.R.string.ok) { dialog, id ->
            arrayList.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, arrayList.size)
        }
        alert.setNegativeButton(android.R.string.cancel){dialog, id ->
            dialog.cancel()
        }

        alert.show()
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }
}

class MyViewHolder(val view: View): RecyclerView.ViewHolder(view){
    private val title: TextView = view.findViewById(R.id.title_textView)
    private val desc: TextView = view.findViewById(R.id.description_textView)
    val trash: ImageView = view.findViewById(R.id.trash_icon)
    val cardView: CardView = view.findViewById(R.id.cardView)
    fun bind(expenses: Expenses) {
        title.text = expenses.title
        desc.text = expenses.desc
    }
}