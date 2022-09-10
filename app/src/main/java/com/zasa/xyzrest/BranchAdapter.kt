package com.zasa.xyzrest

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

/**
 **@Project -> XYZRest
 **@Author -> Sangeeth on 9/9/2022
 */
class BranchAdapter(val context: Context, private val branchList: List<BranchResult>) :
    RecyclerView.Adapter<BranchAdapter.ViewHolder>() {

    lateinit var mListener : onItemClickListner

    interface onItemClickListner{
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListner){
        mListener = listener

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_branch, parent, false), mListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val  branch = branchList[position]
        holder.bind(branch)
    }

    override fun getItemCount() = branchList.size

    inner class ViewHolder(itemView: View, listener: onItemClickListner) : RecyclerView.ViewHolder(itemView) {
        fun bind(branch: BranchResult) {
            itemView.findViewById<TextView>(R.id.tvCity).text = branch.name
            Glide.with(context).load(branch.image_url).into(itemView.findViewById(R.id.ivRestuarant))
        }
        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }
    }
}
