package pl.mradziewicz.savemoneyaccount

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import pl.mradziewicz.savemoneyaccount.adapter.MonthlyExpenseAdapter
import pl.mradziewicz.savemoneyaccount.databinding.ActivityMainBinding
import pl.mradziewicz.savemoneyaccount.viewmodel.ExpenseViewModel
import pl.mradziewicz.savemoneyaccount.viewmodel.ExpenseViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var expenseViewModel: ExpenseViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val factory = ExpenseViewModelFactory()
        expenseViewModel = ViewModelProvider(this,factory).get(ExpenseViewModel::class.java)
        println(expenseViewModel.addExpense.size)
        println(expenseViewModel.addExpense.size)
        println(expenseViewModel.addExpense.size)
        println(expenseViewModel.addExpense.size)
        println(expenseViewModel.addExpense.size)
        println(expenseViewModel.addExpense.size)
        println(expenseViewModel.addExpense.size)
        println(expenseViewModel.addExpense.size)
        println(expenseViewModel.addExpense.size)
        initRecyclerView()
        initButtonListener()
    }
    private fun initButtonListener() {
        binding.addBtn.setOnClickListener {
            val intent = Intent(applicationContext, AddNewGroupExpense::class.java)
            startActivity(intent)
        }
    }

    private fun initRecyclerView() {
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        observeData()
    }

    private fun observeData() {
        expenseViewModel.expenseList.observe(this, Observer {
            Log.i("data", it.toString())
            Log.i("data", it.toString())
            Log.i("data", it.toString())
            Log.i("data", it.toString())
            Log.i("data", it.toString())
            Log.i("data", it.toString())
            Log.i("data", it.toString())
            binding.recyclerView.adapter = MonthlyExpenseAdapter(expenseViewModel, it, this)


        })
    }

}