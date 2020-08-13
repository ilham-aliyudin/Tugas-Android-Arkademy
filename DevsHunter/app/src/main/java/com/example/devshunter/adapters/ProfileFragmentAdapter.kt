package com.example.devshunter.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.devshunter.fragment.EducationFragment
import com.example.devshunter.fragment.PersonalFragment
import com.example.devshunter.fragment.PortofolioFragment

class ProfileFragmentAdapter(fm: FragmentManager): FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when(position) {
            0 -> PersonalFragment()
            1 -> EducationFragment()
            2 -> PortofolioFragment()
            else -> PersonalFragment()
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position) {
            0 -> "Personal"
            1 -> "Education"
            2 -> "Portofolio"
            else -> "Personal"
        }
    }

    override fun getCount(): Int {
        return 3
    }
}