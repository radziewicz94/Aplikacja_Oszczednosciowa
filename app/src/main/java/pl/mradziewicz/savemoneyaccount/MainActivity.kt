package pl.mradziewicz.savemoneyaccount

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import pl.mradziewicz.savemoneyaccount.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        //setContentView(R.layout.activity_main)
        setContentView(binding.root)
        binding.profilButton.setOnClickListener {
            val profileIntent = Intent(applicationContext, ProfileActivity::class.java)
            startActivity(profileIntent)
        }

        binding.wydatkiButton.setOnClickListener {
            val expensesActivity = Intent(this, ExpensesActivity::class.java)
            startActivity(expensesActivity)
        }
    }
}