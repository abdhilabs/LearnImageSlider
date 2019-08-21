package com.abdhilabs.learnimageslider

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.abdhilabs.learnimageslider.groupie.*
import com.abdhilabs.learnimageslider.model.BannerPromo
import com.abdhilabs.learnimageslider.model.Product
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Section
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), BannerListener, ProductListener {

    //Declare adapter from GroupAdapter
    val groupAdapter = GroupAdapter<ViewHolder>()

    val promos = listOf(
            BannerPromo("Puncak badai uang", "https://s2.bukalapak.com/uploads/promo_partnerinfo_bloggy/2842/Bloggy_1_puncak.jpg"),
            BannerPromo("Puncak badai uang", "https://s2.bukalapak.com/uploads/promo_partnerinfo_bloggy/2842/Bloggy_1_puncak.jpg"),
            BannerPromo("Puncak badai uang", "https://s2.bukalapak.com/uploads/promo_partnerinfo_bloggy/2842/Bloggy_1_puncak.jpg"),
            BannerPromo("Puncak badai uang", "https://s2.bukalapak.com/uploads/promo_partnerinfo_bloggy/2842/Bloggy_1_puncak.jpg"),
            BannerPromo("Puncak badai uang", "https://s2.bukalapak.com/uploads/promo_partnerinfo_bloggy/2842/Bloggy_1_puncak.jpg"),
            BannerPromo("Puncak badai uang", "https://s2.bukalapak.com/uploads/promo_partnerinfo_bloggy/2842/Bloggy_1_puncak.jpg")
    )

    val products = listOf(
            Product(name = "Steam",
                    img = "http://www.stickpng.com/assets/images/58aefdc2c869e092af51ee6f.png"),
            Product(name = "Starbucks",
                    img = "http://www.stickpng.com/assets/images/58aefdc2c869e092af51ee6f.png"),
            Product(name = "Steam",
                    img = "http://www.stickpng.com/assets/images/58aefdc2c869e092af51ee6f.png"),
            Product(name = "Starbucks",
                    img = "http://www.stickpng.com/assets/images/58aefdc2c869e092af51ee6f.png"),
            Product(name = "Steam",
                    img = "http://www.stickpng.com/assets/images/58aefdc2c869e092af51ee6f.png"),
            Product(name = "Starbucks",
                    img = "http://www.stickpng.com/assets/images/58aefdc2c869e092af51ee6f.png"),
            Product(name = "Steam",
                    img = "http://www.stickpng.com/assets/images/58aefdc2c869e092af51ee6f.png"),
            Product(name = "Starbucks",
                    img = "http://www.stickpng.com/assets/images/58aefdc2c869e092af51ee6f.png"),
            Product(name = "Steam",
                    img = "http://www.stickpng.com/assets/images/58aefdc2c869e092af51ee6f.png")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Inisialisasi recyclerview
        rvMain.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = groupAdapter
        }

        //Declare Banner Item
        val bannerItem = BannerItem(promos, supportFragmentManager, this)
        groupAdapter.add(bannerItem)

        //Declare Product Category
        Section().apply {
            add(makeProductCategory(products))
            groupAdapter.add(this)
        }
    }

    private fun makeProductCategory(products: List<Product>): ProductCategoryItem {
        val productItemGroupAdapter = GroupAdapter<ViewHolder>()
        products.map {
            productItemGroupAdapter.add(ProductItem(it, this))
        }
        return ProductCategoryItem(productItemGroupAdapter)
    }

    override fun onSeenAllPromoClick() {
        Toast.makeText(this, "See all Promos", Toast.LENGTH_SHORT).show()
    }

    override fun onBannerClick(promo: BannerPromo) {

    }

    override fun onProductClicked(product: Product) {
        Toast.makeText(this, "clicked ${product.name}", Toast.LENGTH_SHORT).show()
    }
}
