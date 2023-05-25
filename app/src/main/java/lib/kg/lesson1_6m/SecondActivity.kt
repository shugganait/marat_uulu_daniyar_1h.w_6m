package lib.kg.lesson1_6m

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import lib.kg.lesson1_6m.MainActivity.Companion.KEY
import lib.kg.lesson1_6m.MainActivity.Companion.KEY_SEC
import lib.kg.lesson1_6m.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //сеттим то что пришло с первого активити
        binding.etText.setText(intent.getStringExtra(KEY_SEC))
        initListeners()
    }

    private fun initListeners() {
        binding.apply {
            btnSend.setOnClickListener {
                if (etText.text?.isNotEmpty() == true){
                    val intent = Intent(this@SecondActivity, MainActivity::class.java)
                    intent.putExtra(KEY, etText.text.toString())
                    setResult(Activity.RESULT_OK, intent)
                    finish()
                } else{
                    Toast.makeText(this@SecondActivity, "Field is empty((", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}