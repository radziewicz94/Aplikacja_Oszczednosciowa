package pl.mradziewicz.savemoneyaccount

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import pl.mradziewicz.savemoneyaccount.databinding.ActivityAddNewGroupExpenseBinding
import pl.mradziewicz.savemoneyaccount.model.ExpenseItem
import pl.mradziewicz.savemoneyaccount.model.Expenses
import pl.mradziewicz.savemoneyaccount.viewmodel.ExpensesViewModel
import pl.mradziewicz.savemoneyaccount.viewmodel.ExpensesViewModelFactory

class AddNewGroupExpenses : AppCompatActivity() {

    private lateinit var binding: ActivityAddNewGroupExpenseBinding
    private lateinit var expensesViewModel: ExpensesViewModel
   // private var lista: ArrayList<ExpenseItem> = ArrayList()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAddNewGroupExpenseBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val title = intent.getStringExtra("title")
        val desc = intent.getStringExtra("desc")
        val name = intent.getStringExtra("name")
        val value = intent.getDoubleExtra("value", 0.0)
        val position = intent.getIntExtra("id", 0)

        if (title.equals(null) && desc.equals(null)) {
            addExpanseGroup()
        } else {
            editExpenseGroup(title, desc, position)
        }
    }

    private fun editExpenseGroup(title: String?, desc: String?, position: Int?) {
        var title = title
        if(title?.contains("...")!!) title = title.replace("...", "")
        binding.titleEditText.setText(title)
        binding.descriptionEditText.setText(desc)
        binding.acceptButton.setOnClickListener {
            val acceptGroup = Intent(this, MainActivity::class.java)
            val expense = getExpensesNameGroup()
            if (position != null) {
                expensesViewModel.update(position, expense)
            }
            startActivity(acceptGroup)
        }
    }

    private fun addExpanseGroup() {
        binding.acceptButton.setOnClickListener {
            val expenses = getExpensesNameGroup()
            val acceptGroup = Intent(this, MainActivity::class.java)
            expensesViewModel.add(expenses)
            startActivity(acceptGroup)
        }
    }

//    private fun getExpenseItem(): ExpenseItem {
//        return ExpenseItem(name,cost)
//    }

    private fun getExpensesNameGroup(): Expenses {
        val title = binding.titleEditText.text.toString()
        val desc = binding.descriptionEditText.text.toString()
        val expenses = Expenses(title, desc)
        val factory = ExpensesViewModelFactory()
        expensesViewModel = ViewModelProvider(this, factory).get(ExpensesViewModel::class.java)
        return expenses
    }
}