package com.example.engineerapp.dashboard.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.engineerapp.R
import kotlinx.android.synthetic.main.item_engineer.view.*

class EngineerAdapter: RecyclerView.Adapter<EngineerAdapter.EngineerViewHolder>() {

    private var myEngineerList = ArrayList<EngineerModel>()

    class EngineerViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(engineer: EngineerModel) {
            with(itemView) {
                tv_username.text = engineer.nama
                tv_skill.text = engineer.skill
                tv_jobdesc.text = engineer.jobdesc
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EngineerViewHolder {
        return EngineerViewHolder(
                LayoutInflater.from(parent.context)
                        .inflate(R.layout.item_engineer, parent, false)
        )
    }

    override fun onBindViewHolder(holder: EngineerViewHolder, position: Int) {
       holder.bind(myEngineerList[position])
    }

    override fun getItemCount(): Int {
        return myEngineerList.size
    }

    fun setData(newEngineerList: ArrayList<EngineerModel>) {
        myEngineerList = newEngineerList
        notifyDataSetChanged()
    }
}