package pl.mradziewicz.savemoneyaccount

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import pl.mradziewicz.savemoneyaccount.databinding.ActivityExpensesBinding
import pl.mradziewicz.savemoneyaccount.viewmodel.ExpensesViewModel

class Expense : AppCompatActivity() {
    private lateinit var binding: ActivityExpensesBinding
    private lateinit var expensesViewModel: ExpensesViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExpensesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecyclerView()

        binding.plusButton.setOnClickListener {
            val intentAddCostActivity = Intent(this, AddCostActivity::class.java)
            startActivity(intentAddCostActivity)
        }

    }
    private fun initRecyclerView(){
        binding.expenseRV.layoutManager = LinearLayoutManager(this)
        binding.expenseRV.adapter
    }
}