package com.example.devshunter.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.devshunter.R
import com.example.devshunter.models.EngineerModel
import com.example.devshunter.models.EngineerResponse
import kotlinx.android.synthetic.main.item_engineers.view.*

class EngineerAdapter(val listener: (EngineerModel)-> Unit): RecyclerView.Adapter<EngineerAdapter.EngineerViewHolder>() {

    private var myEngineerList = emptyArray<EngineerModel>()

    class EngineerViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)  {
        fun bind(listEngineer: EngineerModel, listener: (EngineerModel) -> Unit) {
            with(itemView) {
                tv_engineer_name.text = listEngineer.nama
                tv_engineer_jobdesc.text = listEngineer.jobdesc
                tv_engineer_skill.text = listEngineer.skill
                setOnClickListener{ listener(listEngineer) }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EngineerViewHolder {
        return EngineerViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_engineers, parent, false))
    }

    override fun onBindViewHolder(holder: EngineerViewHolder, position: Int) {
        holder.bind(myEngineerList[position], listener)
    }

    override fun getItemCount(): Int {
        return myEngineerList.size
    }

    fun setData(newEngineerList: Array<EngineerModel>) {
        myEngineerList = newEngineerList
        notifyDataSetChanged()
    }
}