package com.example.doan.presentation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.widget.SearchView
import android.widget.Toast
import com.example.doan.R
import com.example.doan.presentation.adapter.BannerAdapter
import com.example.doan.presentation.adapter.ProductAdapter
import com.example.doan.presentation.model.BannerItem
import com.example.doan.presentation.model.ProductItem

class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var bannerRecyclerView: RecyclerView
    private lateinit var productRecyclerView: RecyclerView
    private lateinit var searchView: SearchView

    private lateinit var bannerAdapter: BannerAdapter
    private lateinit var productAdapter: ProductAdapter

    private val bannerList = mutableListOf<BannerItem>()
    private val productList = mutableListOf<ProductItem>()
    private val filteredProductList = mutableListOf<ProductItem>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bannerRecyclerView = view.findViewById(R.id.bannerRecyclerView)
        productRecyclerView = view.findViewById(R.id.productRecyclerView)
        searchView = view.findViewById(R.id.searchView)

        // Initialize data
        initializeSampleData()

        // Setup Banner RecyclerView
        bannerRecyclerView.layoutManager = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.HORIZONTAL,
            false
        )
        bannerAdapter = BannerAdapter(bannerList) { banner ->
            Toast.makeText(requireContext(), "Clicked: ${banner.title}", Toast.LENGTH_SHORT).show()
        }
        bannerRecyclerView.adapter = bannerAdapter

        // Setup Product RecyclerView
        productRecyclerView.layoutManager = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.VERTICAL,
            false
        )
        productAdapter = ProductAdapter(
            filteredProductList,
            onProductClick = { product ->
                Toast.makeText(requireContext(), "Product: ${product.name}", Toast.LENGTH_SHORT).show()
            },
            onFavoriteClick = { product ->
                Toast.makeText(requireContext(), "Added to favorite: ${product.name}", Toast.LENGTH_SHORT).show()
            }
        )
        productRecyclerView.adapter = productAdapter

        // Setup SearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                filterProducts(query ?: "")
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterProducts(newText ?: "")
                return false
            }
        })
    }

    private fun initializeSampleData() {
        // Sample Banner Data
        bannerList.apply {
            add(BannerItem(1, "Khuyến mãi", "Giảm 50%", "Chỉ hôm nay", ""))
            add(BannerItem(2, "Flash Sale", "Giảm 40%", "Tối nay", ""))
            add(BannerItem(3, "Mua nhiều", "Giảm 30%", "Tuần này", ""))
        }

        // Sample Product Data
        productList.apply {
            add(ProductItem(1, "Laptop Dell XPS", "Máy tính xách tay", 999.99, 4.5f, "", false))
            add(ProductItem(2, "iPhone 15 Pro", "Điện thoại thông minh", 1299.99, 4.8f, "", false))
            add(ProductItem(3, "Samsung Galaxy Watch", "Đồng hồ thông minh", 399.99, 4.3f, "", false))
            add(ProductItem(4, "Sony WH-1000XM5", "Tai nghe chủ động", 349.99, 4.7f, "", false))
            add(ProductItem(5, "iPad Air", "Máy tính bảng", 599.99, 4.6f, "", false))
            add(ProductItem(6, "MacBook Pro", "Laptop cao cấp", 1999.99, 4.9f, "", false))
        }

        filteredProductList.addAll(productList)
    }

    private fun filterProducts(query: String) {
        filteredProductList.clear()
        if (query.isEmpty()) {
            filteredProductList.addAll(productList)
        } else {
            filteredProductList.addAll(
                productList.filter {
                    it.name.contains(query, ignoreCase = true) ||
                    it.description.contains(query, ignoreCase = true)
                }
            )
        }
        productAdapter.notifyDataSetChanged()
    }
}