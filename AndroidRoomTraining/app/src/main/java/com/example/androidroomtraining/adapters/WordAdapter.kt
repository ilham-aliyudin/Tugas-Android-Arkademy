package com.example.androidroomtraining.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidroomtraining.R
import com.example.androidroomtraining.models.WordModel
import kotlinx.android.synthetic.main.word_item.view.*

class WordAdapter(private val wordList: ArrayList<WordModel>): RecyclerView.Adapter<WordAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.word_item, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return wordList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val current = wordList[position]
        holder.word.text = current.word
    }

    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
     val word: TextView = itemView.tv_word
    }
}