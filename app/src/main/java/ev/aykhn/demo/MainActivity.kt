package ev.aykhn.demo

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import ev.aykhn.demo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(ActivityMainBinding.inflate(layoutInflater).also { binding = it }.root)
        bindUI()
    }

    private fun bindUI() {

        binding?.let { ui ->

            ui.buttonShowButton.setOnClickListener {
                ExampleDialog.newInstance(
                    onAccept = {
                        Toast
                            .makeText(applicationContext, "On Accept Listener", Toast.LENGTH_SHORT)
                            .show()
                    },
                    onCancel = {
                        Toast
                            .makeText(applicationContext, "On Cancel Listener", Toast.LENGTH_SHORT)
                            .show()
                    }
                ).show(supportFragmentManager, "TAG")
            }

        }

    }

}