package app.kobayashi.totti.count

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import app.kobayashi.totti.count.databinding.ActivityMainBinding
import app.kobayashi.totti.count.databinding.ActivityTitleBinding

class TitleActivity : AppCompatActivity() {
    private  lateinit var binding: ActivityTitleBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTitleBinding.inflate(layoutInflater).apply { setContentView(this.root) }

        val sharedPref = getSharedPreferences("app_preferences", Context.MODE_PRIVATE)
        val isFirst = sharedPref.getBoolean("isFirst", true)
        var tutorial = false
        var nextIntent = Intent(this, MainActivity::class.java)

        if(isFirst){
            tutorial =true
            sharedPref.edit().putBoolean("isFirst", false).apply()
        }

        binding.nextButton.setOnClickListener {
            if(tutorial){
                nextIntent = Intent(this, TutorialActivity::class.java)
            }
            startActivity(nextIntent)
        }
    }
}