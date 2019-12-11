package com.nandaadisaputra.projectakhir.activity.item

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.viewpager.widget.ViewPager
import com.nandaadisaputra.projectakhir.R
import com.nandaadisaputra.projectakhir.fragment.DeleteFragment
import com.nandaadisaputra.projectakhir.fragment.AddProductFragment
import com.nandaadisaputra.projectakhir.fragment.ShowFragment
import com.ogaclejapan.smarttablayout.SmartTabLayout
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems
import kotlinx.android.synthetic.main.activity_product.*

class ProductActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)

        val sharedPreferences = getSharedPreferences(
                "LSP",
                MODE_PRIVATE)
        tvToken.text = sharedPreferences.getString("SHARED_TOKEN","")



        val adapter = FragmentPagerItemAdapter(
                supportFragmentManager, FragmentPagerItems.with(this)
                .add("Produk", ShowFragment::class.java)
                .add("Tambah Produk", AddProductFragment::class.java)
                .add("Hapus Produk", DeleteFragment::class.java)
                .create()
        )
        val viewPager = findViewById<View>(R.id.viewpager) as ViewPager
        viewPager.adapter = adapter

        val viewPagerTab = findViewById<View>(R.id.viewpagertab) as SmartTabLayout
        viewPagerTab.setViewPager(viewPager)

    }


}
