package pl.mradziewicz.savemoneyaccount

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import pl.mradziewicz.savemoneyaccount.databinding.ActivityExpensesBinding

class ExpensesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityExpensesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExpensesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        binding.recyclerView.adapter = MonthlyExpenseAdapter()

        binding.plusButton.setOnClickListener {
            val intentAddCostActivity = Intent(this, AddNewGroupExpense::class.java)
            startActivity(intentAddCostActivity)
        }

    }

}