package com.example.androidroomtraining.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.androidroomtraining.R
import com.example.androidroomtraining.databinding.ItemSubscriberBinding
import com.example.androidroomtraining.db.Subscriber
import kotlinx.android.synthetic.main.item_subscriber.view.*

class SubscriberAdapter(private val listSubscriber: List<Subscriber>): RecyclerView.Adapter<SubscriberAdapter.MyViewHolder>() {

    inner class MyViewHolder(private val binding: ItemSubscriberBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(subscriber: Subscriber) {
            binding.tvName.text = subscriber.name
            binding.tvEmail.text = subscriber.email
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ItemSubscriberBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.item_subscriber, parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listSubscriber.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(listSubscriber[position])
    }
}