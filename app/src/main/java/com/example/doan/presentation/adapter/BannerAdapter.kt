package com.example.doan.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.doan.R
import com.example.doan.presentation.model.BannerItem

class BannerAdapter(
    private val bannerList: List<BannerItem>,
    private val onBannerClick: (BannerItem) -> Unit
) : RecyclerView.Adapter<BannerAdapter.BannerViewHolder>() {

    inner class BannerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val bannerTitle: TextView = itemView.findViewById(R.id.bannerTitle)
        private val discountText: TextView = itemView.findViewById(R.id.discountText)
        private val bannerDescription: TextView = itemView.findViewById(R.id.bannerDescription)
        private val shopNowBtn: Button = itemView.findViewById(R.id.shopNowBtn)

        fun bind(banner: BannerItem) {
            bannerTitle.text = banner.title
            discountText.text = banner.discount
            bannerDescription.text = banner.description

            shopNowBtn.setOnClickListener {
                onBannerClick(banner)
            }

            itemView.setOnClickListener {
                onBannerClick(banner)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BannerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_banner, parent, false)
        return BannerViewHolder(view)
    }

    override fun onBindViewHolder(holder: BannerViewHolder, position: Int) {
        holder.bind(bannerList[position])
    }

    override fun getItemCount(): Int = bannerList.size
}

