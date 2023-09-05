package bootcamp.sparta.advancedpractics.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import bootcamp.sparta.advancedpractics.R
import bootcamp.sparta.advancedpractics.main.model.TabModel
import bootcamp.sparta.advancedpractics.mypage.MyPageFragment

class MainViewPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity){
    private val list = ArrayList<TabModel>()

    init {
        list.add(
            TabModel(
                fragment = ContactListFragment.newInstance(),
                titleRes = R.string.tab_list
            )
        )
        list.add(
            TabModel(
                fragment = MyPageFragment.newInstance(),
                titleRes = R.string.tab_mypage,
            )
        )
    }

    fun getContactListFragment() : ContactListFragment = list.find { it.fragment is ContactListFragment }?.fragment as ContactListFragment
    fun getMyPageFragment() : MyPageFragment = list.find { it.fragment is MyPageFragment }?.fragment as MyPageFragment

    fun getTitle(position: Int) : Int = list[position].titleRes
    fun checkContactListFragment(position: Int) : Boolean = list[position].fragment is ContactListFragment

    override fun getItemCount(): Int {
        return list.size
    }

    override fun createFragment(position: Int): Fragment {
        return list[position].fragment
    }
}