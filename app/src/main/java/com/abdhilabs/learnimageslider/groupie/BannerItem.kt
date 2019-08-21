package com.abdhilabs.learnimageslider.groupie

import androidx.fragment.app.FragmentManager
import com.abdhilabs.learnimageslider.R
import com.abdhilabs.learnimageslider.adapter.BannerAdapter
import com.abdhilabs.learnimageslider.model.BannerPromo
import com.xwray.groupie.kotlinandroidextensions.Item
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.item_carousel_banner.view.*

interface BannerListener {
    fun onSeenAllPromoClick()
    fun onBannerClick(promo: BannerPromo)
}

/**
 * Item Layout Groupie
 */

class BannerItem(
        private val banners: List<BannerPromo>,
        private val supportFragmentManager: FragmentManager,
        private val listener: BannerListener
) : Item() {

    override fun bind(viewHolder: ViewHolder, position: Int) {
        val viewPagerAdapter = BannerAdapter(supportFragmentManager, banners)
        viewHolder.containerView.vpBanner.adapter = viewPagerAdapter
        viewHolder.containerView.indicator.setViewPager(viewHolder.containerView.vpBanner)

        viewHolder.containerView.btnPromo.setOnClickListener {
            listener.onSeenAllPromoClick()
        }
    }

    override fun getLayout(): Int = R.layout.item_carousel_banner

}
