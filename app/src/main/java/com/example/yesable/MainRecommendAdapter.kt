package com.example.yesable

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.yesable.databinding.RecyclerviewMainRecommendBinding

class MainRecommendAdapter(val mainRecommendList: List<DataMainRecommend>):RecyclerView.Adapter<MainRecommendAdapter.MainViewHolder>(){

    inner class MainViewHolder(val itemBinding: RecyclerviewMainRecommendBinding)
        :RecyclerView.ViewHolder(itemBinding.root){
        fun bindItem(recruitItem:DataMainRecommend){
            // noti 값이 공백이 아닌 경우에만 표시
            if (recruitItem.noti.isNotBlank()) {
                itemBinding.itemNoti1.text = recruitItem.noti
                itemBinding.itemNoti1.visibility = View.VISIBLE
            } else {
                itemBinding.itemNoti1.visibility = View.GONE
            }

            itemBinding.itemNoti2.text = recruitItem.comp
            itemBinding.itemNoti3.text = recruitItem.title
            itemBinding.itemNoti4.text = recruitItem.sub
            itemBinding.itemNoti5.setImageResource(recruitItem.heart)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(
            RecyclerviewMainRecommendBinding.inflate(LayoutInflater.from(parent.context),
                parent, false))
    }

    override fun getItemCount(): Int {
        return mainRecommendList.size
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val recruit = mainRecommendList[position]
        holder.bindItem(recruit)
    }
}