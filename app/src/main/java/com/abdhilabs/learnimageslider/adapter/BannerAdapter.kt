package com.abdhilabs.learnimageslider.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.abdhilabs.learnimageslider.fragment.BannerFragment
import com.abdhilabs.learnimageslider.model.BannerPromo

/**
 * Banner adapter untuk ViewPager
 */

class BannerAdapter(fragmentManager: FragmentManager, private val banners: List<BannerPromo>) :
        FragmentPagerAdapter(fragmentManager) {

    override fun getItem(position: Int): Fragment {
        return BannerFragment.newInstance(banners[position].image)
    }

    override fun getCount(): Int = banners.size

}