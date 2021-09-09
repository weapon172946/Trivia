package com.taskone.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.taskone.databinding.RecyclerHistoryItemBinding
import com.taskone.model.QuestionModel

class HistoryAdapter(var dataList: ArrayList<QuestionModel>) :
    RecyclerView.Adapter<HistoryAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            RecyclerHistoryItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.tvDate.setText(dataList[position].created)
        holder.binding.rvSub.adapter = ListingAdapter(dataList[position])
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    class MyViewHolder(itemView: RecyclerHistoryItemBinding) :
        RecyclerView.ViewHolder(itemView.root) {
        var binding: RecyclerHistoryItemBinding = itemView
    }

}