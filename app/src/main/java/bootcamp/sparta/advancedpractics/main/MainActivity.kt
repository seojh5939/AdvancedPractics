package bootcamp.sparta.advancedpractics.main

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.viewpager2.widget.ViewPager2
import bootcamp.sparta.advancedpractics.R
import bootcamp.sparta.advancedpractics.databinding.MainActivityBinding
import com.google.android.material.tabs.TabLayoutMediator
import java.security.Permission

class MainActivity : AppCompatActivity() {
    private val binding: MainActivityBinding by lazy {
        MainActivityBinding.inflate(layoutInflater)
    }

    private val viewPagerAdapter: MainViewPagerAdapter by lazy {
        MainViewPagerAdapter(this@MainActivity)
    }

    init {
        _instance = this
    }

    companion object {
        private lateinit var _instance : MainActivity
        val instance get() = _instance

        fun newIntent(context: Context) = Intent(context, MainActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initView()
    }

    private fun initView() = with(binding) {
        // 연락처 추가
        mainFabAddContact.setOnClickListener {
        }
        // 전화앱 넘버패드
        mainFabNumberPad.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:"))
            startActivity(intent)
        }

        // ViewPager2 + TabLayout
        mainViewPager.adapter = viewPagerAdapter
        TabLayoutMediator(mainTabLayout, mainViewPager) { tab, position ->
            tab.setText(viewPagerAdapter.getTitle(position))
        }.attach()

        mainViewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)

                // ContactListFragment일경우 EditIcon invisible
                if (viewPagerAdapter.checkContactListFragment(position)) {
                    mainEditIcon.visibility = View.INVISIBLE
                } else {
                    mainEditIcon.visibility = View.VISIBLE
                }
            }
        })
    }
}