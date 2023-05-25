package lib.kg.lesson1_6m

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import lib.kg.lesson1_6m.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val secondLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == Activity.RESULT_OK) {
                val data: Intent? = it.data
                val text = data?.getStringExtra(KEY)
                binding.etText.setText(text)
            }
        }
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initListeners()
    }

    private fun initListeners() {
        //Функция .apply позволяет обращатся к обьекту не повторяя его названия, переданный в аргументе
        binding.apply {
            btnSend.setOnClickListener {
                if (etText.text?.isNotEmpty() == true){
                    val intent = Intent(this@MainActivity, SecondActivity::class.java)
                    intent.putExtra(KEY_SEC, etText.text.toString())
                    secondLauncher.launch(intent)
                } else {
                    Toast.makeText(this@MainActivity, "Field is empty((", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    companion object {
        const val KEY_SEC = "fons"
        const val KEY = "fsksn"
    }
}