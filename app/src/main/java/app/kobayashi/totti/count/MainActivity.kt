package app.kobayashi.totti.count

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import app.kobayashi.totti.count.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var  binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).apply { setContentView(this.root) }

        var count = 0

        binding.countButton.setOnClickListener {
            count++
            binding.countText.text = count.toString()

            when(count % 2) {
                0 -> {
                    binding.countText.setTextColor(Color.rgb(240, 0, 0))
                }
                else ->{
                    binding.countText.setTextColor(Color.rgb(0, 0, 240))
                }
            }
        }


    }
}