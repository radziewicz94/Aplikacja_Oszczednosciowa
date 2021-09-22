package pl.mradziewicz.savemoneyaccount

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import pl.mradziewicz.savemoneyaccount.adapter.MonthlyExpenseAdapter
import pl.mradziewicz.savemoneyaccount.data.CostsDataBase
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
        addExpenseGroup()
    }

    private fun addExpenseGroup() {
        binding.acceptButton.setOnClickListener {
            val acceptGroup = Intent(this, MainActivity::class.java)
//                acceptGroup.putExtra("title", binding.titleEditText.text)
//                acceptGroup.putExtra("name", binding.descriptionEditText.text)
//                CostsDataBase.listOfTitleExpenses.add(binding.titleEditText.text.toString())
//                CostsDataBase.listOfDescExpenses.add(binding.descriptionEditText.text.toString())
            val title = binding.titleEditText.text.toString()
            val desc = binding.descriptionEditText.text.toString()
            var expenses = Expenses(title, desc)
            val factory = ExpenseViewModelFactory()
            expenseViewModel = ViewModelProvider(this, factory).get(ExpenseViewModel::class.java)
            expenseViewModel.add(expenses)
            println(title)
            println(expenseViewModel.expenseList.value)
            println(desc)
            println(expenseViewModel.expenseList.value)
            println("Tytuł i opis klasy ${expenses.title}, ${expenses.desc}")
            println(expenseViewModel.addExpense[0].title)
            println(expenseViewModel.addExpense[0].desc)
            startActivity(acceptGroup)
        }
    }
}