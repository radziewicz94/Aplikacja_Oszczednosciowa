package pl.mradziewicz.savemoneyaccount

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import pl.mradziewicz.savemoneyaccount.databinding.ActivityAddCostBinding
import pl.mradziewicz.savemoneyaccount.model.CostItems
import pl.mradziewicz.savemoneyaccount.viewmodel.CostItemsViewModel
import pl.mradziewicz.savemoneyaccount.viewmodel.CostItemsViewModelFactory
import pl.mradziewicz.savemoneyaccount.viewmodel.ExpensesViewModel
import pl.mradziewicz.savemoneyaccount.viewmodel.ExpensesViewModelFactory

class AddCostActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddCostBinding
    private lateinit var costItemsViewModel: CostItemsViewModel
    private lateinit var expensesViewModel: ExpensesViewModel
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAddCostBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val factory = ExpensesViewModelFactory()
        expensesViewModel = ViewModelProvider(this, factory).get(ExpensesViewModel::class.java)
        val name = intent.getStringExtra("name")
        val value = intent.getDoubleExtra("value", 0.0)
        val title = intent.getStringExtra("title")

        expensesViewModel.getExpense(title.toString())

        binding.acceptBTN.setOnClickListener {
            val expenseItem = getExpenseItemName()
            val addItemIntent = Intent(this, Expense::class.java)
            costItemsViewModel.add(expenseItem)
                //   expensesViewModel.add(expenseItem)
            startActivity(addItemIntent)
        }

    }

    private fun getExpenseItemName(): CostItems {
        val name = binding.nameEditText.text.toString()
        val value = binding.valueEditText.text.toString().toDouble()
        val expenseItem = CostItems(name, value)
        val factory = CostItemsViewModelFactory()
        costItemsViewModel = ViewModelProvider(this, factory).get(CostItemsViewModel::class.java)
        return expenseItem
    }
}