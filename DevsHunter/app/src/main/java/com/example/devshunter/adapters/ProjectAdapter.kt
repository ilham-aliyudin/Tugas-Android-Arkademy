package com.example.devshunter.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.devshunter.R
import com.example.devshunter.models.ProjectModel
import kotlinx.android.synthetic.main.item_project.view.*

class ProjectAdapter: RecyclerView.Adapter<ProjectAdapter.MyViewHolder>() {

     class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_project, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
    }

    override fun getItemCount(): Int{
        return 0
    }
}