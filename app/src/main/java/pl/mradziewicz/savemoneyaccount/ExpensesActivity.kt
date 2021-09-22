//package pl.mradziewicz.savemoneyaccount
//
//import android.content.Intent
//import android.os.Bundle
//import androidx.appcompat.app.AppCompatActivity
//import androidx.recyclerview.widget.LinearLayoutManager
//import pl.mradziewicz.savemoneyaccount.adapter.MonthlyExpenseAdapter
//import pl.mradziewicz.savemoneyaccount.databinding.ActivityExpensesBinding
//import pl.mradziewicz.savemoneyaccount.viewmodel.ExpenseViewModel
//
//class ExpensesActivity : AppCompatActivity() {
//    private lateinit var binding: ActivityExpensesBinding
//    private lateinit var expenseViewModel: ExpenseViewModel
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityExpensesBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        binding.recyclerView.layoutManager = LinearLayoutManager(this)
//
//        binding.recyclerView.adapter = MonthlyExpenseAdapter(expenseViewModel, it, this)
//
//        binding.plusButton.setOnClickListener {
//            val intentAddCostActivity = Intent(this, AddNewGroupExpense::class.java)
//            startActivity(intentAddCostActivity)
//        }
//
//    }
//
//}