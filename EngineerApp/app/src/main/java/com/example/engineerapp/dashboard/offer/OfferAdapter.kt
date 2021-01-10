package com.example.engineerapp.dashboard.offer

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.engineerapp.R
import kotlinx.android.synthetic.main.item_offer.view.*

class OfferAdapter(val listener: (OfferModel) -> Unit): RecyclerView.Adapter<OfferAdapter.OfferViewHolder>() {

    var offerList = ArrayList<OfferModel>()

    class OfferViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(offer: OfferModel, listener: (OfferModel) -> Unit) {
            with(itemView) {
                tv_offer_name.text = offer.project_name
                tv_offer_desc.text = offer.description
                tv_offer_status.text = offer.confirm_status
                setOnClickListener{listener(offer)}
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OfferViewHolder {
        return OfferViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_offer, parent, false)
        )
    }

    override fun onBindViewHolder(holder: OfferViewHolder, position: Int) {
        holder.bind(offerList[position], listener)
    }

    override fun getItemCount(): Int {
        return offerList.size
    }

    fun setData(newOffer: ArrayList<OfferModel>) {
        offerList = newOffer
        notifyDataSetChanged()
    }
}