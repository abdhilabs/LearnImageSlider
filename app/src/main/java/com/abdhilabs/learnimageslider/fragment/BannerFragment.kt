package com.abdhilabs.learnimageslider.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.abdhilabs.learnimageslider.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_banner.*

/**
 * Fragment untuk Gambar Banner
 */

class BannerFragment : Fragment() {

    companion object {
        /**
         * New instance pattern for fragment
         */
        @JvmStatic
        fun newInstance(url: String): BannerFragment {
            val newsFragment = BannerFragment()
            val args = Bundle()
            args.putString("img", url)
            newsFragment.arguments = args
            return newsFragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_banner, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val url = arguments?.getString("img")
        url.let {
            Picasso.get().load(url).into(imgBanner)
        }
    }
}