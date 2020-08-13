package com.example.devshunter.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.devshunter.R
import com.example.devshunter.models.IntroSliderModel
import kotlinx.android.synthetic.main.item_slider.view.*

class IntroSliderAdapter(val listIntroSlider: ArrayList<IntroSliderModel>): RecyclerView.Adapter<IntroSliderAdapter.MyIntroSLiderViewHolder>() {

     inner class MyIntroSLiderViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
         private var image: ImageView = itemView.iv_intro_image
         private var title: TextView = itemView.tv_intro_title
         private var description: TextView  = itemView.tv_intro_desc
         fun bind(listIntro: IntroSliderModel) {
             image.setImageResource(listIntro.image)
             title.text = listIntro.title
             description.text = listIntro.description
         }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyIntroSLiderViewHolder {
        return MyIntroSLiderViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_slider, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return listIntroSlider.size
    }

    override fun onBindViewHolder(holder: MyIntroSLiderViewHolder, position: Int) {
        holder.bind(listIntroSlider[position])
    }
}