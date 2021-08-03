package pl.mradziewicz.savemoneyaccount

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import pl.mradziewicz.savemoneyaccount.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        binding = ActivityProfileBinding.inflate(layoutInflater)


    }
}