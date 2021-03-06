package com.example.devshunter.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.example.devshunter.R
import com.example.devshunter.models.EngineerModel
import com.example.devshunter.models.EngineerResponse
import kotlinx.android.synthetic.main.item_engineers.view.*
import java.util.*
import kotlin.collections.ArrayList

class EngineerAdapter(val listener: (EngineerModel) -> Unit) :
    RecyclerView.Adapter<EngineerAdapter.EngineerViewHolder>(), Filterable {

    private var myEngineerList = ArrayList<EngineerModel>()
    private var myFilteredEngineerList = ArrayList<EngineerModel>()

    class EngineerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(listEngineer: EngineerModel, listener: (EngineerModel) -> Unit) {
            with(itemView) {
                tv_engineer_name.text = listEngineer.nama
                tv_engineer_jobdesc.text = listEngineer.jobdesc
                tv_engineer_skill.text = listEngineer.skill
                setOnClickListener { listener(listEngineer) }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EngineerViewHolder {
        return EngineerViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_engineers, parent, false)
        )
    }

    override fun onBindViewHolder(holder: EngineerViewHolder, position: Int) {
        holder.bind(myEngineerList[position], listener)
    }

    override fun getItemCount(): Int {
        return myEngineerList.size
    }

    fun setData(newEngineerList: ArrayList<EngineerModel>) {
        myEngineerList = newEngineerList
        myFilteredEngineerList = newEngineerList
        notifyDataSetChanged()
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(p0: CharSequence?): FilterResults {
                val filterResult = FilterResults()
                if (p0 == null || p0.length < 0) {
                    filterResult.count = myFilteredEngineerList.size
                    filterResult.values = myFilteredEngineerList
                } else {
                    val searchChar = p0.toString().toLowerCase()
                    val myEngineer = ArrayList<EngineerModel>()
                    for (item in myFilteredEngineerList) {
                        if (item.skill!!.toLowerCase()
                                .contains(searchChar) || item.lokasi!!.toLowerCase()
                                .contains(searchChar)
                        ) {
                            myEngineer.add(item)
                        }
                    }
                    filterResult.count = myEngineer.size
                    filterResult.values = myEngineer
                }
                return filterResult
            }

            override fun publishResults(p0: CharSequence?, p1: FilterResults?) {
                myEngineerList = p1?.values as ArrayList<EngineerModel>
                notifyDataSetChanged()
            }
        }
    }
}