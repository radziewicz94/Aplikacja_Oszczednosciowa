package pl.mradziewicz.savemoneyaccount

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import pl.mradziewicz.savemoneyaccount.databinding.ActivityAddCostBinding
import pl.mradziewicz.savemoneyaccount.model.ExpenseItem
import pl.mradziewicz.savemoneyaccount.viewmodel.ExpenseItemViewModel
import pl.mradziewicz.savemoneyaccount.viewmodel.ExpenseItemViewModelFactory
import pl.mradziewicz.savemoneyaccount.viewmodel.ExpensesViewModel

class AddCostActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddCostBinding
    private lateinit var expenseItemViewModel: ExpenseItemViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAddCostBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.acceptBTN.setOnClickListener {
//            val sendValue = Intent(this, AddNewGroupExpenses::class.java)
//            sendValue.putExtra("name", binding.nameEditText.text)
//            val name = binding.nameEditText.text.toString()
//            val value= binding.valueEditText.text.toString().toDouble()
//            sendValue.putExtra("value", value)
//            sendValue.putExtra("name", name)
            val expenseItem = getExpenseItemName()
            val addItemIntent = Intent(this, Expense::class.java)
            startActivity(addItemIntent)
        }

    }

    private fun getExpenseItemName(): ExpenseItem {
        val name = binding.nameEditText.text.toString()
        val value = binding.valueEditText.text.toString().toDouble()
        val expenseItem = ExpenseItem(name, value)
        val factory = ExpenseItemViewModelFactory()
        expenseItemViewModel = ViewModelProvider(this, factory).get(ExpenseItemViewModel::class.java)
        return expenseItem
    }
}