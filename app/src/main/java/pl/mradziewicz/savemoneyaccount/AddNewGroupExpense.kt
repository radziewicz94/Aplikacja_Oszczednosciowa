package pl.mradziewicz.savemoneyaccount

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import pl.mradziewicz.savemoneyaccount.databinding.ActivityAddNewGroupExpenseBinding
import pl.mradziewicz.savemoneyaccount.model.Expenses
import pl.mradziewicz.savemoneyaccount.viewmodel.ExpenseViewModel
import pl.mradziewicz.savemoneyaccount.viewmodel.ExpenseViewModelFactory

class AddNewGroupExpense : AppCompatActivity() {

    private lateinit var binding: ActivityAddNewGroupExpenseBinding
    private lateinit var expenseViewModel: ExpenseViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAddNewGroupExpenseBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val title = intent.getStringExtra("title")
        val desc = intent.getStringExtra("desc")
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
            val expense = getText()
            if (position != null) {
                expenseViewModel.update(position, expense)
            }
            startActivity(acceptGroup)
        }
    }

    private fun addExpanseGroup() {
        binding.acceptButton.setOnClickListener {
            val expenses = getText()
            val acceptGroup = Intent(this, MainActivity::class.java)
            expenseViewModel.add(expenses)
            startActivity(acceptGroup)
        }
    }

    private fun getText(): Expenses {
        val title = binding.titleEditText.text.toString()
        val desc = binding.descriptionEditText.text.toString()
        val expenses = Expenses(title, desc)
        val factory = ExpenseViewModelFactory()
        expenseViewModel = ViewModelProvider(this, factory).get(ExpenseViewModel::class.java)
        return expenses
    }
}