package com.example.doan.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.doan.R
import com.example.doan.presentation.model.ProductItem

class ProductAdapter(
    private val productList: List<ProductItem>,
    private val onProductClick: (ProductItem) -> Unit,
    private val onFavoriteClick: (ProductItem) -> Unit
) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    inner class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val productImage: ImageView = itemView.findViewById(R.id.productImage)
        private val productName: TextView = itemView.findViewById(R.id.productName)
        private val productDescription: TextView = itemView.findViewById(R.id.productDescription)
        private val productPrice: TextView = itemView.findViewById(R.id.productPrice)
        private val productRating: RatingBar = itemView.findViewById(R.id.productRating)
        private val favoriteBtn: ImageButton = itemView.findViewById(R.id.favoriteBtn)

        fun bind(product: ProductItem) {
            productName.text = product.name
            productDescription.text = product.description
            productPrice.text = String.format("$%.2f", product.price)
            productRating.rating = product.rating

            // Update favorite button appearance
            updateFavoriteButton(product.isFavorite)

            favoriteBtn.setOnClickListener {
                onFavoriteClick(product)
            }

            itemView.setOnClickListener {
                onProductClick(product)
            }
        }

        fun updateFavoriteButton(isFavorite: Boolean) {
            if (isFavorite) {
                favoriteBtn.setImageResource(R.drawable.ic_heart)
                favoriteBtn.setColorFilter(android.graphics.Color.RED)
            } else {
                favoriteBtn.setImageResource(R.drawable.ic_heart)
                favoriteBtn.setColorFilter(android.graphics.Color.GRAY)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(productList[position])
    }

    override fun getItemCount(): Int = productList.size
}

