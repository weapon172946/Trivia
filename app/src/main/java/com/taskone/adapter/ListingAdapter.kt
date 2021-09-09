package com.taskone.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.taskone.databinding.RecyclerHomeItemBinding
import com.taskone.model.MyListModel

class ListingAdapter(var dataList: ArrayList<MyListModel>) :
    RecyclerView.Adapter<ListingAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            RecyclerHomeItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.etAnswer.setText(dataList[position].answer)
        holder.binding.etAnswer.isEnabled = false
        holder.binding.tvName.setText(dataList[position].question)

        holder.binding.rgRadio.visibility = View.GONE
        holder.binding.etAnswer.visibility = View.VISIBLE
        holder.binding.cbLayout.visibility = View.GONE
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    fun updateData(dataList: java.util.ArrayList<MyListModel>) {
        this.dataList = dataList
        notifyDataSetChanged()
    }

    class MyViewHolder(itemView: RecyclerHomeItemBinding) : RecyclerView.ViewHolder(itemView.root) {
        var binding: RecyclerHomeItemBinding = itemView
    }

}