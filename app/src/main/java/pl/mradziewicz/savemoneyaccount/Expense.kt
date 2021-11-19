package pl.mradziewicz.savemoneyaccount

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import pl.mradziewicz.savemoneyaccount.adapter.CostItemsAdapter
import pl.mradziewicz.savemoneyaccount.databinding.ActivityExpensesBinding
import pl.mradziewicz.savemoneyaccount.viewmodel.CostItemsViewModel
import pl.mradziewicz.savemoneyaccount.viewmodel.CostItemsViewModelFactory
import pl.mradziewicz.savemoneyaccount.viewmodel.ExpensesViewModel

class Expense : AppCompatActivity() {
    private lateinit var binding: ActivityExpensesBinding
    private lateinit var expensesItemViewModel: CostItemsViewModel
    private lateinit var expensesViewModel: ExpensesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExpensesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val factory = CostItemsViewModelFactory()
       // expensesItemViewModel = ViewModelProvider(this, factory).get(CostItemsViewModel::class.java)
          expensesViewModel = ViewModelProvider(this, factory).get(ExpensesViewModel::class.java)

        binding.plusButton.setOnClickListener {
            val intentAddCostActivity = Intent(this, AddCostActivity::class.java)
            startActivity(intentAddCostActivity)
        }

    }


    private fun initGroupRecyclerView(){
        binding.expenseRV.layoutManager = LinearLayoutManager(this)
        observeExpenseItemData()
    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun observeExpenseItemData() {
        title = intent.getStringExtra("title")
        expensesViewModel.expensesLiveData.observe(this, {
            binding.expenseRV.adapter = CostItemsAdapter(expensesViewModel.getExpense(title.toString()))
        })
    }
}