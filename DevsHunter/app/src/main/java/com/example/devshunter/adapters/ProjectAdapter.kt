package com.example.devshunter.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import com.example.devshunter.R
import com.example.devshunter.databinding.ActivityDashboardBinding
import com.example.devshunter.models.ProjectModel
import kotlinx.android.synthetic.main.item_project.view.*

class ProjectAdapter(private val listProject: ArrayList<ProjectModel>): RecyclerView.Adapter<ProjectAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private var ivProject = itemView.iv_project
        private var tvProject = itemView.tv_project

        fun bind(list: ProjectModel) {
            ivProject.setImageResource(list.image)
            tvProject.text = list.project
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_project, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(listProject[position])
    }

    override fun getItemCount(): Int {
        return listProject.size
    }
}