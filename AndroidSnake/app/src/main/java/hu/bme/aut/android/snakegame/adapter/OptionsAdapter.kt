package hu.bme.aut.android.snakegame.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import hu.bme.aut.android.snakegame.fragment.BackGroundColorFragment
import hu.bme.aut.android.snakegame.fragment.DifficultyFragment
import hu.bme.aut.android.snakegame.fragment.SnakeColorFragment

class OptionsAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getItem(position: Int): Fragment = when(position){
        0 -> BackGroundColorFragment()
        1 -> SnakeColorFragment()
        2 -> DifficultyFragment()
        else -> BackGroundColorFragment()
    }

    override fun getCount() : Int = NUM_PAGES

    companion object{
        const val NUM_PAGES = 3
    }
}