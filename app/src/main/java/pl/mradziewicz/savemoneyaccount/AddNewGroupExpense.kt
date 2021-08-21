package pl.mradziewicz.savemoneyaccount

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import pl.mradziewicz.savemoneyaccount.databinding.ActivityAddNewGroupExpenseBinding

class AddNewGroupExpense : AppCompatActivity() {

    private lateinit var binding: ActivityAddNewGroupExpenseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_add_new_group_expense)

        binding = ActivityAddNewGroupExpenseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.acceptButton.setOnClickListener {
            val acceptGroup = Intent(this, ExpensesActivity::class.java)
            acceptGroup.putExtra("title", binding.titleEditText.text)
            acceptGroup.putExtra("name", binding.descriptionEditText.text)
            CostsDataBase.listOfTitleExpenses.add(binding.titleEditText.text.toString())
            CostsDataBase.listOfDescExpenses.add(binding.descriptionEditText.text.toString())
            startActivity(acceptGroup)
        }
    }
}