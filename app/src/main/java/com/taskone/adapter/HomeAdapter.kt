package com.taskone.adapter

import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.taskone.databinding.RecyclerHomeItemBinding
import com.taskone.model.MyListModel

class HomeAdapter(var dataList: ArrayList<MyListModel>) :
    RecyclerView.Adapter<HomeAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            RecyclerHomeItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        when (dataList[position].type) {
            0 -> holder.setData(dataList[position])
            1 -> holder.setSingleSelection(dataList[position])
            2 -> holder.setCheckbox(dataList[position])
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    class MyViewHolder(itemView: RecyclerHomeItemBinding) : RecyclerView.ViewHolder(itemView.root) {
        fun setData(item: MyListModel) {
            binding.rgRadio.visibility = View.GONE
            binding.etAnswer.visibility = View.VISIBLE
            binding.cbLayout.visibility = View.GONE

            binding.tvName.text = item.question
            binding.etAnswer.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {

                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                }

                override fun afterTextChanged(s: Editable?) {
                    item.answer = s.toString()
                }

            })
        }

        fun setSingleSelection(item: MyListModel) {
            binding.rgRadio.visibility = View.VISIBLE
            binding.etAnswer.visibility = View.GONE
            binding.cbLayout.visibility = View.GONE

            binding.tvName.text = item.question
            binding.rvOne.text = item.list[0].options
            binding.rvTwo.text = item.list[1].options
            binding.rvThree.text = item.list[2].options
            binding.rvFour.text = item.list[3].options

            binding.rgRadio.setOnCheckedChangeListener { radioGroup, i ->
                when (i) {
                    binding.rvOne.id -> item.answer = binding.rvOne.text.toString()
                    binding.rvTwo.id -> item.answer = binding.rvTwo.text.toString()
                    binding.rvThree.id -> item.answer = binding.rvThree.text.toString()
                    binding.rvFour.id -> item.answer = binding.rvFour.text.toString()
                }
            }
        }

        fun setCheckbox(item: MyListModel) {
            binding.rgRadio.visibility = View.GONE
            binding.etAnswer.visibility = View.GONE
            binding.cbLayout.visibility = View.VISIBLE

            binding.tvName.text = item.question
            binding.cbOne.text = item.list[0].options
            binding.cbTwo.text = item.list[1].options
            binding.cbThree.text = item.list[2].options
            binding.cbFour.text = item.list[3].options

            binding.cbOne.setOnCheckedChangeListener { compoundButton, b ->
                item.list[0].isSelected = b
            }
            binding.cbTwo.setOnCheckedChangeListener { compoundButton, b ->
                item.list[1].isSelected = b

            }
            binding.cbThree.setOnCheckedChangeListener { compoundButton, b ->
                item.list[2].isSelected = b

            }
            binding.cbFour.setOnCheckedChangeListener { compoundButton, b ->
                item.list[3].isSelected = b
            }
        }


        var binding: RecyclerHomeItemBinding = itemView

    }

    interface AdapterClickListener {
        fun onItemChecked(pos: Int)
    }
}