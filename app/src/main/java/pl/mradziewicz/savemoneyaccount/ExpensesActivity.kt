package pl.mradziewicz.savemoneyaccount

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import pl.mradziewicz.savemoneyaccount.databinding.ActivityExpensesBinding

class ExpensesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityExpensesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_expenses)
        binding = ActivityExpensesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.plusButton.setOnClickListener {
            val intentAddCostActivity = Intent(this, AddCostActivity::class.java)
            startActivity(intentAddCostActivity)
        }
    }
}