package pl.mradziewicz.savemoneyaccount

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import pl.mradziewicz.savemoneyaccount.databinding.ActivityAddCostBinding

class AddCostActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddCostBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // setContentView(R.layout.activity_add_cost)

        binding = ActivityAddCostBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            val sendValue = Intent(this, ExpensesActivity::class.java)
            sendValue.putExtra("cost", binding.valueEditText.text)
            sendValue.putExtra("name", binding.nameEditText.text)
            CostsDataBase.productName.add(binding.nameEditText.text.toString())
            println(CostsDataBase.productName[0])
            startActivity(sendValue)
        }

    }
}