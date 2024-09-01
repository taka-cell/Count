package app.kobayashi.totti.count

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.media.AudioManager
import android.media.SoundPool
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import app.kobayashi.totti.count.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var  binding: ActivityMainBinding
    private var count: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).apply { setContentView(this.root) }

        val sharedPreferences = getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
        count = sharedPreferences.getInt("COUNT", 0)
        binding.countText.text = count.toString()

        val soundPool = SoundPool(1,AudioManager.STREAM_MUSIC,0)
        val soundId: Int = soundPool.load(this,R.raw.star,1)
        binding.countButton.setOnClickListener {
            count++
            binding.countText.text = count.toString()

            when(count % 2) {
                0 -> {
                    binding.countText.setTextColor(Color.rgb(240, 0, 0))
                }
                else ->{
                    binding.countText.setTextColor(Color.rgb(0, 0, 240))
                    soundPool.play(soundId, 1f, 1f, 0, 0, 1f)
                }
            }
        }




    }
    override fun onPause() {
        super.onPause()

        val sharedPreferences = getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putInt("COUNT", count)
        editor.apply()
    }
}