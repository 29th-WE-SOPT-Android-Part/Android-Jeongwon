package com.example.androidassignment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.androidassignment.databinding.ItemFollowerListBinding

class FollowerListAdapter : RecyclerView.Adapter<FollowerListAdapter.FollowerViewHolder>() {

    val followerList = mutableListOf<FollowerListData>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FollowerViewHolder {
        val binding = ItemFollowerListBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,false
        )
        return FollowerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FollowerViewHolder, position: Int) {
        holder.onBind(followerList[position])
    }

    override fun getItemCount(): Int = followerList.size

    class FollowerViewHolder(private val binding: ItemFollowerListBinding)
        : RecyclerView.ViewHolder(binding.root) {
        fun onBind(data : FollowerListData) {
            Glide.with(binding.ivPhoto)
                .load(data.imageUrl)
                .circleCrop()
                .into(binding.ivPhoto)
            binding.tvName.text = data.name
            binding.tvIntro.text = data.introduction
        }
    }
}