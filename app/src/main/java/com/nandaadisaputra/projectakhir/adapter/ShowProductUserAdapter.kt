package com.nandaadisaputra.projectakhir.adapter

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nandaadisaputra.projectakhir.R
import com.nandaadisaputra.projectakhir.model.ProductModel
import com.nandaadisaputra.projectakhir.ui.activity.product.ProductDetailsActivity
import org.jetbrains.anko.sdk27.coroutines.onClick
import java.util.*

class ShowProductUserAdapter(private val context: FragmentActivity?,
                             private val productModel: ArrayList<ProductModel>?
) : RecyclerView.Adapter<ShowProductUserAdapter.ViewHolder>() {
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val ivProduct: ImageView = view.findViewById(R.id.iv_product_user)
        val tvName: TextView = view.findViewById(R.id.tv_name_user)
        val tvProductPrices: TextView = view.findViewById(R.id.tv_prices_user)
    }

    override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
    ): ViewHolder {
        return ViewHolder(
                LayoutInflater.from(context).inflate(
                        R.layout.list_item_user, parent,
                        false))
    }

    override fun getItemCount(): Int {
        return productModel!!.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvName.text = productModel!![position].nameProduct
        holder.tvProductPrices.text = productModel!![position].priceProduct
        context?.let {
            Glide.with(it)
                    .load(productModel[position].imageProduct)
                    .override(512, 512)
                    .into(holder.ivProduct)
        }

        holder.itemView.onClick {
            val sharingIntent = Intent(Intent.ACTION_VIEW)
            sharingIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            sharingIntent.data = Uri.parse("https://web.whatsapp.com/")
            context?.startActivity(sharingIntent)
        }
    }
}