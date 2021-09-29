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
import pl.mradziewicz.savemoneyaccount.viewmodel.ExpensesViewModel
import pl.mradziewicz.savemoneyaccount.viewmodel.ExpensesViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var expensesViewModel: ExpensesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val factory = ExpensesViewModelFactory()
        expensesViewModel = ViewModelProvider(this,factory).get(ExpensesViewModel::class.java)
        initRecyclerView()
        initButtonListener()
    }

    private fun initButtonListener() {
        binding.addBtn.setOnClickListener {
            val intent = Intent(applicationContext, AddNewGroupExpenses::class.java)
            startActivity(intent)
        }
    }

    private fun initRecyclerView() {
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        observeData()
    }

    private fun observeData() {
        expensesViewModel.expenseList.observe(this, Observer {
            Log.i("data", it.toString())
            binding.recyclerView.adapter = MonthlyExpenseAdapter(expensesViewModel, it, this)


        })
    }

}