package pl.mradziewicz.savemoneyaccount

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import pl.mradziewicz.savemoneyaccount.adapter.ExpenseItemAdapter
import pl.mradziewicz.savemoneyaccount.databinding.ActivityExpensesBinding
import pl.mradziewicz.savemoneyaccount.viewmodel.ExpenseItemViewModel
import pl.mradziewicz.savemoneyaccount.viewmodel.ExpenseItemViewModelFactory

class Expense : AppCompatActivity() {
    private lateinit var binding: ActivityExpensesBinding
    private lateinit var expenseItemViewModel: ExpenseItemViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExpensesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val factory = ExpenseItemViewModelFactory()
        expenseItemViewModel = ViewModelProvider(this, factory).get(ExpenseItemViewModel::class.java)
        initRecyclerView()

        binding.plusButton.setOnClickListener {
            val intentAddCostActivity = Intent(this, AddCostActivity::class.java)
            startActivity(intentAddCostActivity)
        }

    }
    private fun initRecyclerView(){
        binding.expenseRV.layoutManager = LinearLayoutManager(this)
        observeExpenseItemData()
    }

    private fun observeExpenseItemData() {
        expenseItemViewModel.expenseItemLiveData.observe(this, {
            binding.expenseRV.adapter = ExpenseItemAdapter(expenseItemViewModel, it, this)
        })
    }
}