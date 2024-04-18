package maslovat.taniachifractal.scissors_lizard_rock_paper_spock

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import maslovat.taniachifractal.scissors_lizard_rock_paper_spock.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var fld: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fld = ActivityMainBinding.inflate(layoutInflater)
        setContentView(fld.root)

    }
}