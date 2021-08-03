package pl.mradziewicz.savemoneyaccount

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import pl.mradziewicz.savemoneyaccount.databinding.ActivityAddCostBinding

class AddCostActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddCostBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_cost)
    }
}