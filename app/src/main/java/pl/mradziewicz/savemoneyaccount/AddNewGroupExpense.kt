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
        //setContentView(R.layout.activity_add_new_group_expense)

        binding = ActivityAddNewGroupExpenseBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val title = intent.getStringExtra("title")
        val desc = intent.getStringExtra("desc")
        if(title.equals(null) && desc.equals(null)) {
            addExpanseGroup()
        }
        else{
            val title = intent.getStringExtra("title").toString()
            val desc = intent.getStringExtra("desc").toString()
            val position = intent.getStringExtra("id")?.toInt()
            editExpenseGroup(title, desc, position)
        }
    }

    private fun editExpenseGroup(title: String?, desc: String?, position: Int?) {
        binding.titleEditText.setText(title)
        binding.descriptionEditText.setText(desc)
        binding.acceptButton.setOnClickListener{
            val title = binding.titleEditText.text.toString()
            val desc = binding.descriptionEditText.text.toString()
            val acceptGroup = Intent(this, MainActivity::class.java)
            val expense = Expenses(title, desc)
            val factory = ExpenseViewModelFactory()
            val expenseViewModel = ViewModelProvider(this, factory).get(ExpenseViewModel::class.java)
            expenseViewModel.update(position, expense)
            startActivity(acceptGroup)
        }
    }

    private fun addExpanseGroup() {
        binding.acceptButton.setOnClickListener {
            val title = binding.titleEditText.text.toString()
            val desc = binding.descriptionEditText.text.toString()
            val acceptGroup = Intent(this, MainActivity::class.java)
            val expenses = Expenses(title, desc)
            val factory = ExpenseViewModelFactory()
            expenseViewModel = ViewModelProvider(this, factory).get(ExpenseViewModel::class.java)
            expenseViewModel.add(expenses)
            startActivity(acceptGroup)
        }
    }
}