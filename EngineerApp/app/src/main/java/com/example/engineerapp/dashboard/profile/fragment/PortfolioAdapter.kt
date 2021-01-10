package com.example.engineerapp.dashboard.profile.fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.engineerapp.R

class PortfolioAdapter: RecyclerView.Adapter<PortfolioAdapter.PortfolioViewHolder>() {

    private var listPortfolio = ArrayList<PortfolioModel>()

    class PortfolioViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(listPortfolio: PortfolioModel) {
            with(itemView) {
                Glide.with(itemView.context)
                    .load("http://10.0.2.2:8000/hire/portfolio/" + listPortfolio.image)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PortfolioViewHolder {
        return PortfolioViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_portfolio, parent, false)
        )
    }

    override fun onBindViewHolder(holder: PortfolioViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return listPortfolio.size
    }

    fun setData(newListPortfolio: ArrayList<PortfolioModel>) {
        listPortfolio = newListPortfolio
        notifyDataSetChanged()
    }
}