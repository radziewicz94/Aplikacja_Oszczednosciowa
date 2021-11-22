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
import pl.mradziewicz.savemoneyaccount.model.CostItems
import pl.mradziewicz.savemoneyaccount.viewmodel.CostItemsViewModel
import pl.mradziewicz.savemoneyaccount.viewmodel.ExpensesViewModel
import pl.mradziewicz.savemoneyaccount.viewmodel.ExpensesViewModelFactory

class Expense : AppCompatActivity() {
    private lateinit var binding: ActivityExpensesBinding
    private lateinit var expensesItemViewModel: CostItemsViewModel
    private lateinit var expensesViewModel: ExpensesViewModel

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExpensesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //val costTitle = intent.getStringExtra("costTitle")
        val factory = ExpensesViewModelFactory()
       // expensesItemViewModel = ViewModelProvider(this, factory).get(CostItemsViewModel::class.java)
        expensesViewModel = ViewModelProvider(this, factory).get(ExpensesViewModel::class.java)
        initGroupRecyclerView()
        val expenseTitle = intent.getStringExtra("expenseTitle")

        binding.plusButton.setOnClickListener {
            val addCostActivity = Intent(this, AddCostActivity::class.java)
            addCostActivity.putExtra("expenseTitle", expenseTitle)
            startActivity(addCostActivity)
        }

    }


    @RequiresApi(Build.VERSION_CODES.N)
    private fun initGroupRecyclerView(){
        binding.expenseRV.layoutManager = LinearLayoutManager(this)
        observeExpenseItemData()

    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun observeExpenseItemData() {
        val expenseTitle = intent.getStringExtra("expenseTitle")
        val expense = expensesViewModel.getExpenseItems(expenseTitle.toString())
        println("wielkosc tablicy ${expense?.size}")
        println("wielkosc tablicy ${expense?.size}")
        expensesViewModel.expensesLiveData.observe(this, {
            binding.expenseRV.adapter = CostItemsAdapter(expense as MutableList<CostItems>)
        })
    }
}