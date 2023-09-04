package bootcamp.sparta.advancedpractics.main

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import bootcamp.sparta.advancedpractics.R
import bootcamp.sparta.advancedpractics.databinding.MainActivityBinding

class MainActivity : AppCompatActivity() {
    private val binding : MainActivityBinding by lazy {
        MainActivityBinding.inflate(layoutInflater)
    }

    companion object {
        fun newIntent(context: Context) = Intent(context, MainActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initView()
    }

    private fun initView() = with(binding) {

    }
}