package app.kobayashi.totti.count

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.viewpager2.widget.ViewPager2
import app.kobayashi.totti.count.databinding.ActivityTutorialBinding

class TutorialActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTutorialBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTutorialBinding.inflate(layoutInflater).apply{setContentView(this.root)}

        val viewPager = findViewById<ViewPager2>(R.id.viewPager)
        val pagerAdapter = TutorialPagerAdapter(this)
        viewPager.adapter = pagerAdapter


    }
}